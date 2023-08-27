package com.strong.boot.module.system.dal.mysql.mail;

import com.strong.boot.framework.common.pojo.PageResult;
import com.strong.boot.framework.mybatis.core.mapper.BaseMapperX;
import com.strong.boot.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.strong.boot.framework.mybatis.core.query.QueryWrapperX;
import com.strong.boot.module.system.controller.admin.mail.vo.account.MailAccountPageReqVO;
import com.strong.boot.module.system.dal.dataobject.mail.MailAccountDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MailAccountMapper extends BaseMapperX<MailAccountDO> {

    default PageResult<MailAccountDO> selectPage(MailAccountPageReqVO pageReqVO) {
        return selectPage(pageReqVO, new LambdaQueryWrapperX<MailAccountDO>()
                .likeIfPresent(MailAccountDO::getMail, pageReqVO.getMail())
                .likeIfPresent(MailAccountDO::getUsername , pageReqVO.getUsername()));
    }

}
