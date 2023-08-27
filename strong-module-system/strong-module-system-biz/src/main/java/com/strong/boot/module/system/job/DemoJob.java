package com.strong.boot.module.system.job;

import com.strong.boot.framework.quartz.core.handler.JobHandler;
import com.strong.boot.module.system.dal.dataobject.user.AdminUserDO;
import com.strong.boot.module.system.dal.mysql.user.AdminUserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DemoJob implements JobHandler {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    public String execute(String param) throws Exception {
        List<AdminUserDO> users = adminUserMapper.selectList();
        return "用户数量：" + users.size();
    }

}
