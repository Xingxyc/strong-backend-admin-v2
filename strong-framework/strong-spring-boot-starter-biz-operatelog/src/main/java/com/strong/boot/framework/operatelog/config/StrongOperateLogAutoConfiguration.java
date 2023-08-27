package com.strong.boot.framework.operatelog.config;

import com.strong.boot.framework.operatelog.core.aop.OperateLogAspect;
import com.strong.boot.framework.operatelog.core.service.OperateLogFrameworkService;
import com.strong.boot.framework.operatelog.core.service.OperateLogFrameworkServiceImpl;
import com.strong.boot.module.system.api.logger.OperateLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class StrongOperateLogAutoConfiguration {

    @Bean
    public OperateLogAspect operateLogAspect() {
        return new OperateLogAspect();
    }

    @Bean
    public OperateLogFrameworkService operateLogFrameworkService(OperateLogApi operateLogApi) {
        return new OperateLogFrameworkServiceImpl(operateLogApi);
    }

}
