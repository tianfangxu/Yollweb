//package org.springboot.cloud.utils;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpSession;
//
//import org.json.JSONObject;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
//
//
///**
// * 
// * @author wilson
// * redis工具类
// *
// */
//public class RedisTools {
//
//	public static int SECONDS = 3600 * 24;//为key指定过期时间，单位是秒
//
//	private static JedisPool pool;
//	
//
//	static {
//		JedisPoolConfig config = new JedisPoolConfig();
//		config.setMaxActive(2000000);//控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态就成exhausted了
//		config.setMaxIdle(1000000);//控制一个pool最多有多少个状态为idle的jedis实例；
//		config.setMaxWait(new Long(3000).longValue());//表示当borrow一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
//		config.testOnBorrow = true;//在borrow一个jedis实例时，是否提前进行alidate操作；如果为true，则得到的jedis实例均是可用的；
//
//		if(pool == null){//config：配置参数； 6379：默认端口号，可以更改；e_learning：密码
////			pool = new JedisPool(config, "192.168.0.52", 6379, 2000, "e_learning");
////			pool = new JedisPool(config, "192.168.0.13", 6381, 2000, "e_learning");
//			pool = new JedisPool(config, "localhost", 6379, 0);
//		}
//
//
//	}
//	public static Jedis getJedis() {
//		return pool.getResource();
//	}
//	
//	public static void closeJedis(Jedis jedis) {
//		pool.returnResource(jedis);
//	}
//	
//	/**
//	 * 添加String类型数据
//	 * @param key
//	 * @param value
//	 */
//	public static void set(String key, String value){
//		Jedis jedis = RedisTools.getJedis();
//		if(jedis.exists(key)){
//			jedis.del(key);
//		}
//		jedis.set(key, value);
//		jedis.expire(key, SECONDS);
//		RedisTools.closeJedis(jedis);
//	}
//	public static void set(Jedis jedis,String key, String value){
//		if(jedis.exists(key)){
//			jedis.del(key);
//		}
//		jedis.set(key, value);
//		jedis.expire(key, SECONDS);
//	}
//	
//	/**
//	 * 设置string类型数据，并设置过期时间
//	 * @param key
//	 * @param value
//	 * @param exp
//	 */
//	public static void set(String key, String value,int exp){
//		Jedis jedis = RedisTools.getJedis();
//		if(jedis.exists(key)){
//			jedis.del(key);
//		}
//		jedis.set(key, value);
//		jedis.expire(key, exp);
//		RedisTools.closeJedis(jedis);
//	}
//	public static void set(Jedis jedis,String key, String value,int exp){
//		if(jedis.exists(key)){
//			jedis.del(key);
//		}
//		jedis.set(key, value);
//		jedis.expire(key, exp);
//	}
//	/**
//	 * 获取string
//	 * @param key
//	 * @return
//	 */
//	public static String get(String key){
//		Jedis jedis = RedisTools.getJedis();
//		if(jedis.exists(key)){
//			return jedis.get(key);
//		}
//		RedisTools.closeJedis(jedis);
//		return null;
//	}
//	public static String get(Jedis jedis,String key){
//		if(jedis.exists(key)){
//			return jedis.get(key);
//		}
//		return null;
//	}
//	/**
//	 * 设置List<String>类型数据
//	 * @param key
//	 * @param list
//	 */
//	public static void setList(String key , List<String> list){
//		Jedis jedis = RedisTools.getJedis();
//		if(jedis.exists(key)){
//			jedis.del(key);
//		}
//		for(String str:list){
//			jedis.rpush(key, str);
//		}
//		RedisTools.closeJedis(jedis);
//	}
//	public static void appendRightList(String key , String str){
//		Jedis jedis = RedisTools.getJedis();
//			jedis.rpush(key, str);
//		RedisTools.closeJedis(jedis);
//	}
//	public static void appendLeftList(String key , String str){
//		Jedis jedis = RedisTools.getJedis();
//		jedis.lpush(key, str);
//		RedisTools.closeJedis(jedis);
//	}
//	public static void setList(Jedis jedis,String key , List<String> list){
//		for(String str:list){
//			jedis.lpush(key, str);
//		}
//	}
//	public static boolean deleteValueOfList(String key , String value){
//		Jedis jedis = RedisTools.getJedis();
//		List<String> list = new ArrayList<String>();
//		long l = jedis.llen(key);
//		if(l==0){
//			return false;
//		}
//		list = jedis.lrange(key, 0, l);
//		boolean remove = list.remove(value.trim());
//		if (remove) {
//			jedis.del(key);
//			for (String string : list) {
//				jedis.lpush(key, string);
//			}
//		}
//		RedisTools.closeJedis(jedis);
//		return remove;
//	}
//	/**
//	 * 获取List<String>
//	 * @param key
//	 * @return
//	 */
//	public static List<String> getList(String key){
//		Jedis jedis = RedisTools.getJedis();
//		List<String> list = new ArrayList<String>();
//		long l = jedis.llen(key);
//		if(l==0){
//			return null;
//		}
//		list = jedis.lrange(key, 0, l);
//		RedisTools.closeJedis(jedis);
//		return list;
//	}
//	public static List<String> getList(Jedis jedis,String key){
//		List<String> list = new ArrayList<String>();
//		long l = jedis.llen(key);
//		if(l==0){
//			return null;
//		}
//		list = jedis.lrange(key, 0, l);
//		return list;
//	}
//	/**
//	 * 判断key是否存在
//	 * @param key
//	 * @return
//	 */
//	public static boolean exists(String key){
//		boolean exists = false;
//		Jedis jedis = RedisTools.getJedis();
//		if(jedis.exists(key)){
//			exists = true;
//		}
//		RedisTools.closeJedis(jedis);
//		return exists;
//	}
//	public static boolean exists(Jedis jedis,String key){
//		boolean exists = false;
//		if(jedis.exists(key)){
//			exists = true;
//		}
//		return exists;
//	}
//	/**
//	 * 删除key
//	 * @param key
//	 */
//	public static void del(String key){
//		Jedis jedis = RedisTools.getJedis();
//		if(jedis.exists(key)){
//			jedis.del(key);
//		}
//		RedisTools.closeJedis(jedis);
//	}
//	public static void del(Jedis jedis,String key){
//		if(jedis.exists(key)){
//			jedis.del(key);
//		}
//	}
//	/**
//	 * 清空当前库
//	 */
//	public static void flushDB(){
//		Jedis jedis = RedisTools.getJedis();
//		jedis.flushDB();
//		RedisTools.closeJedis(jedis);
//	}
//	/**
//	 * 添加一个string元素到key对应的set集合中，成功返回1,如果元素已经在集合中返回0,key对应的set不存在返回错误
//	 * @param key
//	 * @param ownerId
//	 * @param toId
//	 * @param value
//	 */
//	public static void push(String key, int ownerId, int toId, String value) {
//		Jedis jedis = RedisTools.getJedis();
//		jedis.sadd(key + ownerId, key + toId);
//		if(jedis.exists(key  + toId)){
//			jedis.del(key  + toId);
//		}
//		jedis.set(key  + toId, value);
//		jedis.expire(key + ownerId, SECONDS);
//		jedis.expire(key  + toId, SECONDS);
//		RedisTools.closeJedis(jedis);
//	}
//	/**
//	 * 非可用方法
//	 * 将对象集合存放到redis里，可重新设计，传递不同类型pojo，在此提供模板
//	 * @param key主键
//	 * @param menus
//	 */
//	public static void saveBeanListToRedis(Jedis jedis,String key, List<HttpSession>  sessions ) {
//		if (sessions != null) {
//			for (HttpSession session : sessions) {
//				saveBeanToRedis(jedis,key, session);
//			}
//		}
//	}
//	public static void saveToRedis(String key, List<HttpSession>  sessions  ) {
//		Jedis jedis = RedisTools.getJedis();
//		if (sessions != null) {
//			for (HttpSession session : sessions) {
//				saveBeanToRedis(jedis,key, session);
//			}
//		}
//		RedisTools.closeJedis(jedis);
//	}
//	/**
//	 * 存放当个bean到redis
//	 * @param key
//	 * @param menu
//	 */
//	public static void saveBeanToRedis(Jedis jedis,String key, HttpSession session) {
//		jedis.lpush(key, changeJsonToSave(session));
//	}
//	public static void saveBeanToRedis(String key, HttpSession session) {
//		Jedis jedis = getJedis();
//		jedis.lpush(key, changeJsonToSave(session));
//		closeJedis(jedis);
//	}
//	/**
//	 * 将bean转换为json
//	 * @param key
//	 * @param menu
//	 */
//	public static String changeJsonToSave(HttpSession session) {
//		JSONObject jsonObject = JSONObject.fromObject(session);
//		 return session.getClass().getCanonicalName() + "ゎ∴♂㊣ф≒ж☆♀∴ぁ"
//					+ jsonObject.toString();
//	}
//	/**
//	 * 通过key，查询beanList
//	 * @param key
//	 * @return
//	 */
//	public static List<HttpSession> getBeanList(String key){
//		Jedis jedis = getJedis();
//		long len = jedis.llen(key);
//		List<String> list = jedis.lrange(key, 0, (int)len-1);
//		List<HttpSession> sessions = new ArrayList<HttpSession>();
//		for (String value : list) {
//			sessions.add(changeStringToBean(value));
//		}
//		RedisTools.closeJedis(jedis);
//		return sessions;
//	}
//	public static List<HttpSession> getBeanList(Jedis jedis,String key){
//		long len = jedis.llen(key);
//		List<String> list = jedis.lrange(key, 0, (int)len-1);
//		List<HttpSession> sessions = new ArrayList<HttpSession>();
//		for (String value : list) {
//			sessions.add(changeStringToBean(value));
//		}
//		return sessions;
//	}
//	/**
//	 * 通过key，查询单个的bean
//	 * @param key
//	 * @return
//	 */
//	public static HttpSession getBean(String key){
//		Jedis jedis = getJedis();
//		List<String> list = jedis.lrange(key, 0, 0);
//		HttpSession session = null;
//		for (String value : list) {
//			session = changeStringToBean(value);
//		}
//		RedisTools.closeJedis(jedis);
//		return session;
//	}
//	public static HttpSession getBean(Jedis jedis,String key){
//		List<String> list = jedis.lrange(key, 0, 0);
//		HttpSession session = null;
//		for (String value : list) {
//			session = changeStringToBean(value);
//		}
//		return session;
//	}
//	/**
//	 * 转换json为bean
//	 * @param activeRecordJson
//	 * @return
//	 */
//	public static HttpSession changeStringToBean(String beanJson) {
//		if(beanJson != null && !"".equals(beanJson)){
//		String[] params = beanJson.split("ゎ∴♂㊣ф≒ж☆♀∴ぁ");
//		if(params != null && params.length == 2){
//			String className = "";
//			String realJson = "";
//			HttpSession session = null;
//			try {
//				if (params[0] == null || "".equals(params[0])) {
//					 throw new Exception("beanJson中未找到实体类名");
//				} else {
//					className = params[0];
//					realJson = params[1];
//					session= (HttpSession)Class.forName(className).newInstance();
//					JSONObject fromObject = JSONObject.fromObject(realJson);
//					session = (HttpSession)JSONObject.toBean(fromObject, HttpSession.class);
//					
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return session;
//		}else{
//			return null;
//		}
//		}else{
//			return null;
//		}
//	}
//	
//}
