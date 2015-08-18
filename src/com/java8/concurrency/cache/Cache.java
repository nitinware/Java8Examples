package com.java8.concurrency.cache;

import com.java8.concurrency.model.Key;
import com.java8.concurrency.model.UserVO;

public interface Cache<K, V> {
	
	public void put(Key key, UserVO value);
	
	public UserVO get(Key key);
	
	public int getSize();

}
