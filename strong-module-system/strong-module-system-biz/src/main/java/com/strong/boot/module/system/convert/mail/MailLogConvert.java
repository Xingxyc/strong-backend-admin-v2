package com.strong.boot.module.system.convert.mail;

import com.strong.boot.framework.common.pojo.PageResult;
import com.strong.boot.module.system.controller.admin.mail.vo.log.MailLogRespVO;
import com.strong.boot.module.system.dal.dataobject.mail.MailLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MailLogConvert {

    MailLogConvert INSTANCE = Mappers.getMapper(MailLogConvert.class);

    PageResult<MailLogRespVO> convertPage(PageResult<MailLogDO> pageResult);

    MailLogRespVO convert(MailLogDO bean);

}
