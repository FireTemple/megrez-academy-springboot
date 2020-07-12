package com.bohan.config;

import com.bohan.serializer.MyStringRedisSerialize;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){

        // 固定代码
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        // 配置两种序列化模式
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        MyStringRedisSerialize myStringRedisSerialize = new MyStringRedisSerialize();

        template.setKeySerializer(stringRedisSerializer);
        template.setValueSerializer(myStringRedisSerialize);
        template.setHashKeySerializer(stringRedisSerializer);
        template.setHashValueSerializer(myStringRedisSerialize);

        return template;

    }
}
