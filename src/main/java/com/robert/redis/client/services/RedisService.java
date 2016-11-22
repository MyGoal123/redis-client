package com.robert.redis.client.services;

import java.util.Set;

import com.robert.redis.client.config.RedisPool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;

public class RedisService implements IRedisService{

	
	public RedisService(){
		
	}
	
	private Jedis getJResource(){
		Jedis jResource = null;
		RedisPool rp = new RedisPool();
		jResource = rp.getJedis();
		return jResource;
	}
	private ShardedJedis getShardResource(){
		ShardedJedis sResource = null;
		RedisPool rp = new RedisPool();
		sResource = rp.getShardedJedis();
		return sResource;
	}
	
	public Boolean setString(String key, String value) {
		boolean result = false;
		ShardedJedis resource = null;
		try{
			resource = getShardResource();
			if(resource != null){
				resource.set(key, value);
				result = true;
			}
			
		}catch(Exception e){
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	public String getString(String key) {
		String result = null;
		ShardedJedis resource = null;
		try{
			resource = getShardResource();
			if(resource != null){
				result = resource.get(key);
			}
			
		}catch(Exception e){
			result = null;
			e.printStackTrace();
		}
		return result;
	}

	public Boolean existsKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long delKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public String typeKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> keys(String key) {
		Set<String> result = null;
		Jedis resource = null;
		try{
			resource = getJResource();
			if(resource != null){
				result = resource.keys(key);
			}
			
		}catch(Exception e){
			result = null;
			e.printStackTrace();
		}
		return result;
	}

}
