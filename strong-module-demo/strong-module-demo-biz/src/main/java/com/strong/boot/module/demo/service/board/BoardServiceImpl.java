package com.strong.boot.module.demo.service.board;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import com.strong.boot.module.demo.controller.admin.board.vo.*;
import com.strong.boot.module.demo.dal.dataobject.board.BoardDO;
import com.strong.boot.framework.common.pojo.PageResult;

import com.strong.boot.module.demo.convert.board.BoardConvert;
import com.strong.boot.module.demo.dal.mysql.board.BoardMapper;

import static com.strong.boot.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.strong.boot.module.demo.enums.ErrorCodeConstants.*;

/**
 * 格局版 demo Service 实现类
 *
 * @author xingyichuan
 */
@Service
@Validated
public class BoardServiceImpl implements BoardService {

    @Resource
    private BoardMapper boardMapper;

    @Override
    public Long createBoard(BoardCreateReqVO createReqVO) {
        // 插入
        BoardDO board = BoardConvert.INSTANCE.convert(createReqVO);
        boardMapper.insert(board);
        // 返回
        return board.getId();
    }

    @Override
    public void updateBoard(BoardUpdateReqVO updateReqVO) {
        // 校验存在
        validateBoardExists(updateReqVO.getId());
        // 更新
        BoardDO updateObj = BoardConvert.INSTANCE.convert(updateReqVO);
        boardMapper.updateById(updateObj);
    }

    @Override
    public void deleteBoard(Long id) {
        // 校验存在
        validateBoardExists(id);
        // 删除
        boardMapper.deleteById(id);
    }

    private void validateBoardExists(Long id) {
        if (boardMapper.selectById(id) == null) {
            throw exception(BOARD_NOT_EXISTS);
        }
    }

    @Override
    public BoardDO getBoard(Long id) {
        return boardMapper.selectById(id);
    }

    @Override
    public List<BoardDO> getBoardList(Collection<Long> ids) {
        return boardMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<BoardDO> getBoardPage(BoardPageReqVO pageReqVO) {
        return boardMapper.selectPage(pageReqVO);
    }

    @Override
    public List<BoardDO> getBoardList(BoardExportReqVO exportReqVO) {
        return boardMapper.selectList(exportReqVO);
    }

}
