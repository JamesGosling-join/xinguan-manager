package com.quan.redis;

import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author 全俊
 * @version 1.0
 * @className RedisUtils
 * @description TODO
 * @date 2020/8/5 21:02
 */
@Component
public class RedisUtils<K, V> {
    /**
     * @param
     * @return void
     * @description 切换redis数据库
     * @methodName connectionFactory
     * @author 全俊
     * @date 2020/8/5 21:03
     */
    public void connectionFactory(RedisTemplate<K, V> redisTemplate) {
        LettuceConnectionFactory connectionFactory = (LettuceConnectionFactory) redisTemplate.getConnectionFactory();
        assert connectionFactory != null;
        connectionFactory.setDatabase(15);
        redisTemplate.setConnectionFactory(connectionFactory);
        connectionFactory.afterPropertiesSet();
    }

    /**
     * @param redisTemplate
     * @param k
     * @return void
     * @description 清空当前数据库
     * @methodName flushdb
     * @author 全俊
     * @date 2020/8/5 21:08
     */
    public void flushdb(RedisTemplate redisTemplate) {
        redisTemplate.delete(Objects.requireNonNull(redisTemplate.keys("*")));
    }
}
