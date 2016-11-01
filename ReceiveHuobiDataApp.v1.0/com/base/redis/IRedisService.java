package base.redis;


public interface IRedisService {

	void addRedis(Object key,Object obj,long livetime);
	
	void addRedisSynchronized(Object key,Object obj,long livetime);
	
	Object findRedis(Object key);
	
	void updateRedis(Object key,Object obj);
	
	void delRedis(String key);
	
	void setExpireRedis(Object key,long expire);
	
	void addList(String key,Object obj,long expire);
	
	Object getAllList(String k);
	
	void removeElement(String key,long index,Object obj);
	
	void addRedisString(String key,Object obj,long livetime);
	
	Object getValueAsStr(String key);
	
	public void removeKeyStr(String key);
}
