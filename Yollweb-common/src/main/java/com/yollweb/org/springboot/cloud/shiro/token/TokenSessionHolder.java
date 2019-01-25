package com.yollweb.org.springboot.cloud.shiro.token;

import com.yollweb.org.springboot.cloud.ctx.AppContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenSessionHolder {

    private static final String T_S_PREFIX = "token_session:";

    private static final String S_T_PREFIX = "session_token:";

    private static final TokenSessionHolder instance = new TokenSessionHolder();

    private final static Map<String, String> holder = new ConcurrentHashMap<String, String>();

    private RedisTemplate redisTemplate = AppContext.getBean("redisTemplate", RedisTemplate.class);

    private TokenSessionHolder() {

    }

    public static TokenSessionHolder instance() {
        return instance;
    }

    public String getSID(String token) {
        return (String) redisTemplate.opsForValue().get(T_S_PREFIX + token);
    }

    public void setSID(String token, String sid) {
        redisTemplate.opsForValue().set(T_S_PREFIX + token, sid);
        redisTemplate.opsForValue().set(S_T_PREFIX + sid, token);
    }

    public void rmSID(Serializable sid) {
        String token = (String)redisTemplate.opsForValue().get(S_T_PREFIX + sid);
        redisTemplate.delete(S_T_PREFIX + sid);
        redisTemplate.delete(T_S_PREFIX + token);
    }


    public static String getSessionId(String token) {
        return holder.get(token);
    }

    public static void setSessionId(String token, String sessionId) {
        holder.put(token, sessionId);
    }

    public static void removeBySessionId(Serializable sessionId) {
        if (sessionId == null) {
            return;
        }
        String sid = sessionId.toString();
        String token = "";
        Iterator<Map.Entry<String, String>> it = holder.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            if (sid.equals(entry.getValue())) {
                token = entry.getKey();
            }
        }
        holder.remove(token);
    }
}
