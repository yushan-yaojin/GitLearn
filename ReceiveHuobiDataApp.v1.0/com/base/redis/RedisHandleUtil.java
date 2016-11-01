package base.redis;

import base.util.SpringContextHolder;


/**
 * redis操作工具
* @Title: RedisHandleUtil.java 
* @Package com.timer.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author yaoj   
* @date 2016年5月30日 下午3:38:51 
* @version V1.0
 */
public class RedisHandleUtil {

	/**
	 * 新增缓存
	* @Title: addRedis 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param key
	* @param @param value    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static void addRedis(Object key,Object value,long time){
		IRedisService redisService=SpringContextHolder.getBean("redisService");
		redisService.addRedis(key, value,time);
	}
	
	/**
	 * 新增缓存（字符串操作）
	 * @param key
	 * @param value
	 * @param time
	 */
	public static void addRedisString(String key,Object value,long time){
		IRedisService redisService=SpringContextHolder.getBean("redisService");
		redisService.addRedisString(key, value,time);
	}
	
	/**
	 * 获取缓存（字符串操作）
	 * @param key
	 * @return
	 */
	public static Object getValueAsStr(String key){
		IRedisService redisService=SpringContextHolder.getBean("redisService");
		return redisService.getValueAsStr(key);
	}
	
	/**
	 * 删除缓存（字符串操作）
	 * @param key
	 */
	public static void removeStr(String key){
		IRedisService redisService=SpringContextHolder.getBean("redisService");
		redisService.removeKeyStr(key);
	}
	
	
	public static void addRedisSynchronized(Object key,Object value,long time){
		IRedisService redisService=SpringContextHolder.getBean("redisService");
		redisService.addRedisSynchronized(key, value, time);
	}
	
	/**
	 * 修改缓存
	* @Title: updateRedis 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param key
	* @param @param value    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static void updateRedis(Object key,Object value){
		IRedisService redisService=SpringContextHolder.getBean("redisService");
		redisService.updateRedis(key, value);
	}
	
	/**
	 * 删除缓存
	* @Title: delRedis 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param key    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static void delRedis(String key){
		IRedisService redisService=SpringContextHolder.getBean("redisService");
		redisService.delRedis(key);
	}
	
	/**
	 * 获取redis
	* @Title: findRedis 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param key
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	public static Object findRedis(Object key){
		IRedisService redisService=SpringContextHolder.getBean("redisService");
		return  redisService.findRedis(key);
	}
	
	/**
	 * 过期时间（单位秒）
	 * @param key
	 * @param expire
	 */
	public static void setExpireRedis(Object key, long expire){
		IRedisService redisService=SpringContextHolder.getBean("redisService");
		redisService.setExpireRedis(key, expire);
	}
	
	/**
	 * 添加list集合到redis
	 * @param key
	 * @param obj
	 * @param expire
	 */
	public static void addList(String key,Object obj,long expire){
		IRedisService redisService=SpringContextHolder.getBean("redisService");
		redisService.addList(key, obj, expire);
	}
	
	/**
	 * 获取某集合
	 * @param key
	 * @return
	 */
	public static Object getAllList(String key){
		IRedisService redisService=SpringContextHolder.getBean("redisService");
		return redisService.getAllList(key);
	}
	
	/**
	 * 移除集合中的某元素
	 * @param key
	 * @param index
	 * @param obj
	 */
	public static void removeElement(String key,long index,Object obj){
		IRedisService redisService=SpringContextHolder.getBean("redisService");
		redisService.removeElement(key, index, obj);
	}
}
