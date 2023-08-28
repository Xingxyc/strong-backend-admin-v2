package com.strong.boot.module.demo.framework.web.config;

import com.strong.boot.framework.swagger.config.StrongSwaggerAutoConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: DemoWebConfiguration
 * Package: com.strong.boot.module.demo.framework.web.config
 * Description:
 * demo 模块的 web 组件的 Configuration
 * @Author xingyichuan
 * @Create 2023/8/27 22:20
 */
@Configuration(proxyBeanMethods = false)

public class DemoWebConfiguration {

    /**
     * demo 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi demoGroupedOpenApi() {
        return StrongSwaggerAutoConfiguration.buildGroupedOpenApi("demo");
    }
}
