package top.qilixiang.examination.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangzhx on 2018/4/24.
 */
@Slf4j
public class RedisWithCRUD {

    private static RedisTemplate<Serializable, Object> redisTemplate = new RedisTemplate<>();

    /**
     * 写入/更新redis
     *
     * @param key
     * @param value
     * @return
     */
    public static boolean set(String key, Object value) {
        boolean isSetted = false;
        try {
            ValueOperations<Serializable, Object> valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key, value);
            isSetted = true;
        } catch (Exception e) {
            log.error("write redis is faill");
        }
        return isSetted;
    }

    /**
     * 写入/更新redis，且设置失效时间
     *
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    public static boolean set(String key, Object value, Long expireTime) {
        boolean isSetted = false;
        try {
            ValueOperations<Serializable, Object> valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            isSetted = true;
        } catch (Exception e) {
            log.error("write redis is faill");
        }
        return isSetted;
    }

    public static Object get(String key) {
        ValueOperations<Serializable, Object> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    /**
     * 删除key
     *
     * @param key
     */
    public static void delete(String key) {
        if (redisTemplate.hasKey(key)) {
            redisTemplate.delete(key);
            log.info("delete key is {}", key);
        } else {
            log.warn("{} is nonexistent", key);
        }
    }

    /**
     * 批量删除key
     *
     * @param keys
     */
    public static void delete(String... keys) {
        for (String key : keys) {
            delete(key);
        }
    }
}
