package com.strong.boot.module.bpm.dal.mysql.oa;

import com.strong.boot.module.bpm.controller.admin.oa.vo.BpmOALeavePageReqVO;
import com.strong.boot.module.bpm.dal.dataobject.oa.BpmOALeaveDO;
import com.strong.boot.framework.common.pojo.PageResult;
import com.strong.boot.framework.mybatis.core.mapper.BaseMapperX;
import com.strong.boot.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 请假申请 Mapper
 *
 * @author jason
 * @author 芋道源码
 */
@Mapper
public interface BpmOALeaveMapper extends BaseMapperX<BpmOALeaveDO> {

    default PageResult<BpmOALeaveDO> selectPage(Long userId, BpmOALeavePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BpmOALeaveDO>()
                .eqIfPresent(BpmOALeaveDO::getUserId, userId)
                .eqIfPresent(BpmOALeaveDO::getResult, reqVO.getResult())
                .eqIfPresent(BpmOALeaveDO::getType, reqVO.getType())
                .likeIfPresent(BpmOALeaveDO::getReason, reqVO.getReason())
                .betweenIfPresent(BpmOALeaveDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BpmOALeaveDO::getId));
    }

}
