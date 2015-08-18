package com.java8.concurrency.cache;

import java.util.concurrent.ConcurrentHashMap;

import com.java8.concurrency.model.Key;
import com.java8.concurrency.model.UserVO;

public class CacheImpl implements Cache<Key, UserVO> {
	
	private static CacheImpl instance;
	
	private ConcurrentHashMap<Key, UserVO> cacheMap;
	
	static {
		synchronized (CacheImpl.class) {
			if(CacheImpl.instance == null) {
				CacheImpl.instance = new CacheImpl();
			}
		}
	}
	
	private CacheImpl() {
		cacheMap = new ConcurrentHashMap<>();
	}
	
	public static Cache<Key, UserVO> getCache() {
		return instance;
	}

	@Override
	public void put(Key key, UserVO value) {
		
		UserVO userVO = cacheMap.get(key);
		
		if(userVO == null) {
			userVO = cacheMap.putIfAbsent(key, userVO);
			if(userVO == null)
				userVO = value;
		}
		
	}

	@Override
	public UserVO get(Key key) {
		return cacheMap.get(key);
	}

	@Override
	public int getSize() {
		return cacheMap.keySet().size();
	}

}
