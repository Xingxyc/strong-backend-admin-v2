package com.strong.boot.module.demo.service.board;

import java.util.*;
import javax.validation.*;
import com.strong.boot.module.demo.controller.admin.board.vo.*;
import com.strong.boot.module.demo.dal.dataobject.board.BoardDO;
import com.strong.boot.framework.common.pojo.PageResult;

/**
 * 格局版 demo Service 接口
 *
 * @author xingyichuan
 */
public interface BoardService {

    /**
     * 创建格局版 demo
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createBoard(@Valid BoardCreateReqVO createReqVO);

    /**
     * 更新格局版 demo
     *
     * @param updateReqVO 更新信息
     */
    void updateBoard(@Valid BoardUpdateReqVO updateReqVO);

    /**
     * 删除格局版 demo
     *
     * @param id 编号
     */
    void deleteBoard(Long id);

    /**
     * 获得格局版 demo
     *
     * @param id 编号
     * @return 格局版 demo
     */
    BoardDO getBoard(Long id);

    /**
     * 获得格局版 demo列表
     *
     * @param ids 编号
     * @return 格局版 demo列表
     */
    List<BoardDO> getBoardList(Collection<Long> ids);

    /**
     * 获得格局版 demo分页
     *
     * @param pageReqVO 分页查询
     * @return 格局版 demo分页
     */
    PageResult<BoardDO> getBoardPage(BoardPageReqVO pageReqVO);

    /**
     * 获得格局版 demo列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 格局版 demo列表
     */
    List<BoardDO> getBoardList(BoardExportReqVO exportReqVO);

}
