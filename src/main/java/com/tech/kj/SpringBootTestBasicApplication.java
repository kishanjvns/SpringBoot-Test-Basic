package com.tech.kj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SpringBootApplication
public class SpringBootTestBasicApplication implements ApplicationRunner {

	@Autowired
	Jedis jedis;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestBasicApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		jedis.set("mykey","1001");
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  "+jedis.get("mykey"));
	}
}
