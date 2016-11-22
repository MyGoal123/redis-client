package com.robert.redis.client.services;

import java.util.Set;

public interface IRedisService {

	
	public Boolean setString(String key, String value);
	public String getString(String key);
	public Boolean existsKey(String key);
	public Long delKey(String key);
	public String typeKey(String key);
	public Set<String> keys(String key);
	
}
