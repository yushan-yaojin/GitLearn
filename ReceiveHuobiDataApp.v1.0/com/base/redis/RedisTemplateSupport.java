package base.redis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;



public abstract class RedisTemplateSupport {

	@Resource(name = "redisTemplate")
	private RedisTemplate<Serializable, Object> redisTemplate;

	/**
	 * 新增--单个实体对象
	 * @param keys
	 * @param object
	 */
	public void add(final Object keys, final Object object,final long expire) {
		
		this.redisTemplate.execute(new RedisCallback<Object>() {
			
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] key = SerializeUtil.serialize(keys);
				byte[] value = SerializeUtil.serialize(object);
				connection.set(key, value);
				if(expire>0){
					connection.expire(key, expire);
				}
				return null;
			}
		});
	}
	
	/**
	 * 新增--单个实体对象
	 * @param keys
	 * @param object
	 * @param expire--过期时间（单位秒）
	 */
	public void setExpire(final Object keys, final long expire) {
		
		this.redisTemplate.execute(new RedisCallback<Object>() {
			
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] key = SerializeUtil.serialize(keys);
				connection.expire(key, expire);
				return null;
			}
		});
	}
	
	
	/**
	 * 修改--单个实体对象
	 * @param keys
	 * @param object
	 */
	public void set(final Object keys, final Object object){
		this.redisTemplate.execute(new RedisCallback<Object>() {
			
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] key = SerializeUtil.serialize(keys);
				byte[] value = SerializeUtil.serialize(object);
				connection.set(key, value);
				return null;
			}
		});
	}

	/**
	 * 查询
	 * @param keys
	 * @return
	 */
	public Object findByKey(final Object keys) {
		return redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] key = SerializeUtil.serialize(keys);
				byte[] value = connection.get(key);
				if (value == null) {
					return null;
				}
				return SerializeUtil.unserialize(value);
			}
		});
	}

	/**
	 * 删除
	 * @param keys
	 */
	 public long delete(final String keys) {  
		 return redisTemplate.execute(new RedisCallback<Long>() {  
	            public Long doInRedis(RedisConnection connection)  
	                    throws DataAccessException {  
	                long result = 0;
	                byte[] key = SerializeUtil.serialize(keys);
	                result = connection.del(key);
	                return result;  
	            }  
	        }); 
	}
	 
	 /**
		 * 给某集合添加元素
		 * @param k
		 * @param v
		 * @param time
		 */
		public void addList(final String k, final Object v, final long time) {
		       ListOperations<Serializable, Object> listOps =  redisTemplate.opsForList();
	            listOps.rightPushAll(k, v);
	            if (time > 0) redisTemplate.expire(k, time, TimeUnit.SECONDS);
	            /*redisTemplate.execute(new RedisCallback<Object>() {
					@Override
					public Object doInRedis(RedisConnection connection)
							throws DataAccessException {
						byte[] key = SerializeUtil.serialize(k);
						byte[] value = SerializeUtil.serialize(v);
						connection.rPush(key, value);
						return null;
					}
	            	
	            });*/
		}
		
		/**
		 * 获取某集合
		 * @param k
		 * @return
		 */
		public Object getAllList(final String k){
			ListOperations<Serializable, Object> listOps =  redisTemplate.opsForList();
			return listOps.range(k, 0, -1);
			/*return redisTemplate.execute(new RedisCallback<Object>() {
				@Override
				public Object doInRedis(RedisConnection connection)
						throws DataAccessException {
					byte[] key = SerializeUtil.serialize(k);
					List<byte[]> value = connection.lRange(key, 0, -1);
					List<Object> list=new ArrayList<Object>();
					for(byte[] s:value){
						list.add(SerializeUtil.unserialize(s));
					}
					return list;
				}
	        	
	        });*/
		}
	
	/**
	 * 移除元素
	 * @param key
	 * @param index
	 * @param obj
	 */
	public void removeListElement(final String k,final long index,final Object obj){
		ListOperations<Serializable, Object> listOps =  redisTemplate.opsForList();
		listOps.remove(k, index, obj);
	}
	
	/**
	 * 保存(字符串操作)
	 * @param key
	 * @param obj
	 * @param time
	 */
	public void addAsStr(final String key,Object obj,long time){
		 ValueOperations<Serializable, Object> valueOps =  redisTemplate.opsForValue();
         valueOps.set(key, obj);
         if (time > 0) redisTemplate.expire(key, time, TimeUnit.SECONDS);
	}
	
	/**
	 * 获取value(字符串操作)
	 * @param key
	 * @return
	 */
	public Object getValueAsStr(final String key){
		 ValueOperations<Serializable, Object> valueOps =  redisTemplate.opsForValue();
         return valueOps.get(key);
	}
	
	/**
	 * 移除缓存（字符串操作）
	 * @param key
	 */
	public void removeKeyStr(final String key){
		redisTemplate.delete(key);
	}
	
	/**
	 * 获取集合的长度
	 * @param k
	 * @return
	 */
	public Long getListLength(String k){
		 ListOperations<Serializable, Object> listOps =  redisTemplate.opsForList();
		 return listOps.size(k);
	}

}
