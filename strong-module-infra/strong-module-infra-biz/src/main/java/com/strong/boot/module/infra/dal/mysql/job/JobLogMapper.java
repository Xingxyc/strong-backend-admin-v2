package com.strong.boot.module.infra.dal.mysql.job;

import com.strong.boot.framework.common.pojo.PageResult;
import com.strong.boot.framework.mybatis.core.mapper.BaseMapperX;
import com.strong.boot.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.strong.boot.module.infra.controller.admin.job.vo.log.JobLogExportReqVO;
import com.strong.boot.module.infra.controller.admin.job.vo.log.JobLogPageReqVO;
import com.strong.boot.module.infra.dal.dataobject.job.JobLogDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 任务日志 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface JobLogMapper extends BaseMapperX<JobLogDO> {

    default PageResult<JobLogDO> selectPage(JobLogPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JobLogDO>()
                .eqIfPresent(JobLogDO::getJobId, reqVO.getJobId())
                .likeIfPresent(JobLogDO::getHandlerName, reqVO.getHandlerName())
                .geIfPresent(JobLogDO::getBeginTime, reqVO.getBeginTime())
                .leIfPresent(JobLogDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(JobLogDO::getStatus, reqVO.getStatus())
                .orderByDesc(JobLogDO::getId) // ID 倒序
        );
    }

    default List<JobLogDO> selectList(JobLogExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<JobLogDO>()
                .eqIfPresent(JobLogDO::getJobId, reqVO.getJobId())
                .likeIfPresent(JobLogDO::getHandlerName, reqVO.getHandlerName())
                .geIfPresent(JobLogDO::getBeginTime, reqVO.getBeginTime())
                .leIfPresent(JobLogDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(JobLogDO::getStatus, reqVO.getStatus())
                .orderByDesc(JobLogDO::getId) // ID 倒序
        );
    }

}
