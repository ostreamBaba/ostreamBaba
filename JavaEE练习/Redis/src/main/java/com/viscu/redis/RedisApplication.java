package com.viscu.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

@SpringBootApplication
public class RedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}


	//Spring Boot自动配置了RedisTemplate 而RedisTemplate使用了JdkSerializationRedisSerializer(二进制形式存储数据)
	//对Redis Client并不友好 所以自己配置RedisTemplate
	@Bean
	@SuppressWarnings("unchecked")
	public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)throws UnknownHostException{
		RedisTemplate<Object,Object> redisTemplate=new RedisTemplate<Object, Object>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om=new ObjectMapper();
		om.setVisibility( PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);

		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer); //设置值的序列化 采用jackson2JsonRedisSerializer
		redisTemplate.setKeySerializer(new StringRedisSerializer()); //设置键的序列化 采用StringRedisSerializer

		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
}


