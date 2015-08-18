package com.java8.concurrency.cache;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;

import com.java8.concurrency.model.Key;
import com.java8.concurrency.model.UserVO;

public class CacheTest {
	
	private static Cache<Key, UserVO> cache1, cache2;
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		cache1 = CacheImpl.getCache();
		System.out.println("Cache1 - " + cache1);
		System.out.println("Cache1 - hashcode: " + cache1.hashCode());
		cache2 = CacheImpl.getCache();
		System.out.println("Cache2 - " + cache2);
		System.out.println("Cache2 - hashcode: " + cache2.hashCode());
	}

	@Test
	public void testUnique() {
		assertTrue(cache1 == cache2);
	}
	
	@Test
	public void testThreadSafety(){
		
		int threadCount = 5;
		
		ExecutorService service = Executors.newFixedThreadPool(threadCount);
		
		List<Future<Void>> futures = new ArrayList<>();
		
		for(int count = 0; count < threadCount ; count++) {
			
			final int i = count;
			
			Callable<Void> callable = new Callable<Void>() {
				
				@Override
				public Void call() throws Exception {
					Key key1 = new Key("Ware", (20+i));
					CacheImpl.getCache().put(key1, new UserVO("ware", "800 West Trade St.", "Consultant", 8));
					Key key2 = new Key("Nitin", 24);
					CacheImpl.getCache().put(key2, new UserVO("Nitin", "7416 Marchand Lane, Charlotte", "Consultant", (7 + i)));
					return null;
				}
			};
			Future<Void> submit = service.submit(callable);
			futures.add(submit);
		}
		
		service.shutdown();
		
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		/*for(Future<Void> future : futures) {
			try {
				future.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}*/
		assertEquals(6, CacheImpl.getCache().getSize());		
	}

}
