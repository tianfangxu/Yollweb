//
//package org.springboot.cloud.utils;
//
//
//import java.util.Collections;
//
//
//public class RedisTool {
//    private static final String LOCK_SUCCESS = "OK";
//    /**
//     * NX|XX, NX -- Only set the key if it does not already exist.
//     * XX Only set the key if it already exist.
//     */
//    private static final String SET_IF_NOT_EXIST = "NX";
//    /**
//     * EX|PX, expire time units: EX = seconds; PX = milliseconds
//     */
//    private static final String SET_WITH_EXPIRE_TIME = "EX";
//
//    private static final Long RELEASE_SUCCESS = 1L;
//
//
//    /**
//     * 尝试获取分布式锁
//     *
//     * @param jedis      Redis客户端
//     * @param lockKey    锁
//     * @param requestId  请求标识
//     * @param expireTime 超期时间
//     * @return 是否获取成功
//     */
//    public static boolean tryGetDistributedLock(JedisClusterUtils jedis, String lockKey, String requestId, long
//            expireTime) {
//
//        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
//
//        if (LOCK_SUCCESS.equals(result)) {
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 释放分布式锁
//     *
//     * @param jedis     Redis客户端
//     * @param lockKey   锁
//     * @param requestId 请求标识
//     * @return 是否释放成功
//     */
//    public static boolean releaseDistributedLock(JedisClusterUtils jedis, String lockKey, String requestId) {
//
//        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return " +
//                "0 end";
//        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
//
//        if (RELEASE_SUCCESS.equals(result)) {
//            return true;
//        }
//        return false;
//    }
//}
