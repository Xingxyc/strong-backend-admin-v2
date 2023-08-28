package com.strong.boot.module.demo.dal.mysql.board;

import java.util.*;

import com.strong.boot.framework.common.pojo.PageResult;
import com.strong.boot.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.strong.boot.framework.mybatis.core.mapper.BaseMapperX;
import com.strong.boot.module.demo.dal.dataobject.board.BoardDO;
import org.apache.ibatis.annotations.Mapper;
import com.strong.boot.module.demo.controller.admin.board.vo.*;

/**
 * 格局版 demo Mapper
 *
 * @author xingyichuan
 */
@Mapper
public interface BoardMapper extends BaseMapperX<BoardDO> {

    default PageResult<BoardDO> selectPage(BoardPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BoardDO>()
                .likeIfPresent(BoardDO::getName, reqVO.getName())
                .eqIfPresent(BoardDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(BoardDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BoardDO::getId));
    }

    default List<BoardDO> selectList(BoardExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<BoardDO>()
                .likeIfPresent(BoardDO::getName, reqVO.getName())
                .eqIfPresent(BoardDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(BoardDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BoardDO::getId));
    }

}
