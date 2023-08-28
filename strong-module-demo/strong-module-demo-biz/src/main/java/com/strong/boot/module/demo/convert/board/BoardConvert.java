package com.strong.boot.module.demo.convert.board;

import java.util.*;

import com.strong.boot.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.strong.boot.module.demo.controller.admin.board.vo.*;
import com.strong.boot.module.demo.dal.dataobject.board.BoardDO;

/**
 * 格局版 demo Convert
 *
 * @author xingyichuan
 */
@Mapper
public interface BoardConvert {

    BoardConvert INSTANCE = Mappers.getMapper(BoardConvert.class);

    BoardDO convert(BoardCreateReqVO bean);

    BoardDO convert(BoardUpdateReqVO bean);

    BoardRespVO convert(BoardDO bean);

    List<BoardRespVO> convertList(List<BoardDO> list);

    PageResult<BoardRespVO> convertPage(PageResult<BoardDO> page);

    List<BoardExcelVO> convertList02(List<BoardDO> list);

}
