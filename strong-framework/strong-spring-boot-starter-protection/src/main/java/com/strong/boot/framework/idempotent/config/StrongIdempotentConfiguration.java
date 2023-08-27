package com.strong.boot.framework.idempotent.config;

import com.strong.boot.framework.idempotent.core.aop.IdempotentAspect;
import com.strong.boot.framework.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import com.strong.boot.framework.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import com.strong.boot.framework.idempotent.core.keyresolver.IdempotentKeyResolver;
import com.strong.boot.framework.idempotent.core.redis.IdempotentRedisDAO;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import com.strong.boot.framework.redis.config.StrongRedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@AutoConfiguration(after = StrongRedisAutoConfiguration.class)
public class StrongIdempotentConfiguration {

    @Bean
    public IdempotentAspect idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspect(keyResolvers, idempotentRedisDAO);
    }

    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========

    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }

}
