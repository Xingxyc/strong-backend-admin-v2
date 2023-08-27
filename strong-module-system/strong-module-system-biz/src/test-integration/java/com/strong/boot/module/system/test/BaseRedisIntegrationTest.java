package com.strong.boot.module.system.test;

import com.strong.boot.framework.redis.config.StrongRedisAutoConfiguration;
import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = BaseRedisIntegrationTest.Application.class)
@ActiveProfiles("integration-test") // 设置使用 application-integration-test 配置文件
public class BaseRedisIntegrationTest {

    @Import({
            // Redis 配置类
            RedisAutoConfiguration.class, // Spring Redis 自动配置类
            StrongRedisAutoConfiguration.class, // 自己的 Redis 配置类
            RedissonAutoConfiguration.class, // Redisson 自动高配置类
    })
    public static class Application {
    }

}
