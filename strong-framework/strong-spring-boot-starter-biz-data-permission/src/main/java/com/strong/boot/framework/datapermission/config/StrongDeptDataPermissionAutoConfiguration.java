package com.strong.boot.framework.datapermission.config;

import com.strong.boot.framework.datapermission.core.rule.dept.DeptDataPermissionRule;
import com.strong.boot.framework.datapermission.core.rule.dept.DeptDataPermissionRuleCustomizer;
import com.strong.boot.framework.security.core.LoginUser;
import com.strong.boot.module.system.api.permission.PermissionApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * 基于部门的数据权限 AutoConfiguration
 *
 * @author 芋道源码
 */
@AutoConfiguration
@ConditionalOnClass(LoginUser.class)
@ConditionalOnBean(value = {PermissionApi.class, DeptDataPermissionRuleCustomizer.class})
public class StrongDeptDataPermissionAutoConfiguration {

    /*
    * customizers拿到所有的DeptDataPermissionRuleCustomizer的实现类
    * 然后依次执行所有实现类的方法补全配置
    * */
    @Bean
    public DeptDataPermissionRule deptDataPermissionRule(PermissionApi permissionApi,
                                                         List<DeptDataPermissionRuleCustomizer> customizers) {
        // 创建 DeptDataPermissionRule 对象
        DeptDataPermissionRule rule = new DeptDataPermissionRule(permissionApi);
        // 补全表配置
        customizers.forEach(customizer -> customizer.customize(rule));
        return rule;
    }

}
