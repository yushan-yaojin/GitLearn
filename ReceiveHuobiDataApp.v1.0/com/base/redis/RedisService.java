package base.redis;

import org.springframework.stereotype.Service;

@Service("redisService")
public class RedisService extends RedisTemplateSupport implements IRedisService {

	
	public void addRedis(Object key, Object obj,long livetime) {
		// TODO Auto-generated method stub
		super.add(key, obj,livetime);
	}

	
	public void addRedisString(String key, Object obj, long livetime) {
		// TODO Auto-generated method stub
		super.addAsStr(key, obj, livetime);
	}


	@Override
	public Object getValueAsStr(String key) {
		// TODO Auto-generated method stub
		return super.getValueAsStr(key);
	}


	public  void addRedisSynchronized(Object key, Object obj, long livetime) {
		// TODO Auto-generated method stub
		synchronized(this){
			super.add(key, obj,livetime);
		}
	}

	
	public Object findRedis(Object key) {
		// TODO Auto-generated method stub
		return super.findByKey(key);
	}

	
	public void updateRedis(Object key, Object obj) {
		super.set(key, obj);
	}

	
	public void delRedis(String key) {
		// TODO Auto-generated method stub
		super.delete(key);
	}

	/**
	 * 过期时间（单位秒）
	 */
	
	public void setExpireRedis(Object key, long expire) {
		// TODO Auto-generated method stub
		super.setExpire(key, expire);
	}

	
	public void addList(String k, Object v, long time) {
		// TODO Auto-generated method stub
		super.addList(k, v, time);
	}

	
	public Object getAllList(String k) {
		// TODO Auto-generated method stub
		return super.getAllList(k);
	}

	
	public void removeElement(String key, long index, Object obj) {
		// TODO Auto-generated method stub
		super.removeListElement(key, index, obj);
	}


	@Override
	public void removeKeyStr(String key) {
		// TODO Auto-generated method stub
		super.removeKeyStr(key);
	}

}
