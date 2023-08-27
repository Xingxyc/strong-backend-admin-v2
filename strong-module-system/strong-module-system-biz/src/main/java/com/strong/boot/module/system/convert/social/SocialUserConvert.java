package com.strong.boot.module.system.convert.social;

import com.strong.boot.module.system.api.social.dto.SocialUserBindReqDTO;
import com.strong.boot.module.system.api.social.dto.SocialUserUnbindReqDTO;
import com.strong.boot.module.system.controller.admin.socail.vo.SocialUserBindReqVO;
import com.strong.boot.module.system.controller.admin.socail.vo.SocialUserUnbindReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SocialUserConvert {

    SocialUserConvert INSTANCE = Mappers.getMapper(SocialUserConvert.class);

    SocialUserBindReqDTO convert(Long userId, Integer userType, SocialUserBindReqVO reqVO);

    SocialUserUnbindReqDTO convert(Long userId, Integer userType, SocialUserUnbindReqVO reqVO);

}
