package com.strong.boot.module.demo.service.board;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import com.strong.boot.framework.test.core.ut.BaseDbUnitTest;

import com.strong.boot.module.demo.controller.admin.board.vo.*;
import com.strong.boot.module.demo.dal.dataobject.board.BoardDO;
import com.strong.boot.module.demo.dal.mysql.board.BoardMapper;
import com.strong.boot.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static com.strong.boot.module.demo.enums.ErrorCodeConstants.*;
import static com.strong.boot.framework.test.core.util.AssertUtils.*;
import static com.strong.boot.framework.test.core.util.RandomUtils.*;
import static com.strong.boot.framework.common.util.date.LocalDateTimeUtils.*;
import static com.strong.boot.framework.common.util.object.ObjectUtils.*;
import static com.strong.boot.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * {@link BoardServiceImpl} 的单元测试类
 *
 * @author xingyichuan
 */
@Import(BoardServiceImpl.class)
public class BoardServiceImplTest extends BaseDbUnitTest {

    @Resource
    private BoardServiceImpl boardService;

    @Resource
    private BoardMapper boardMapper;

    @Test
    public void testCreateBoard_success() {
        // 准备参数
        BoardCreateReqVO reqVO = randomPojo(BoardCreateReqVO.class);

        // 调用
        Long boardId = boardService.createBoard(reqVO);
        // 断言
        assertNotNull(boardId);
        // 校验记录的属性是否正确
        BoardDO board = boardMapper.selectById(boardId);
        assertPojoEquals(reqVO, board);
    }

    @Test
    public void testUpdateBoard_success() {
        // mock 数据
        BoardDO dbBoard = randomPojo(BoardDO.class);
        boardMapper.insert(dbBoard);// @Sql: 先插入出一条存在的数据
        // 准备参数
        BoardUpdateReqVO reqVO = randomPojo(BoardUpdateReqVO.class, o -> {
            o.setId(dbBoard.getId()); // 设置更新的 ID
        });

        // 调用
        boardService.updateBoard(reqVO);
        // 校验是否更新正确
        BoardDO board = boardMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, board);
    }

    @Test
    public void testUpdateBoard_notExists() {
        // 准备参数
        BoardUpdateReqVO reqVO = randomPojo(BoardUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> boardService.updateBoard(reqVO), BOARD_NOT_EXISTS);
    }

    @Test
    public void testDeleteBoard_success() {
        // mock 数据
        BoardDO dbBoard = randomPojo(BoardDO.class);
        boardMapper.insert(dbBoard);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbBoard.getId();

        // 调用
        boardService.deleteBoard(id);
       // 校验数据不存在了
       assertNull(boardMapper.selectById(id));
    }

    @Test
    public void testDeleteBoard_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> boardService.deleteBoard(id), BOARD_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetBoardPage() {
       // mock 数据
       BoardDO dbBoard = randomPojo(BoardDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       boardMapper.insert(dbBoard);
       // 测试 name 不匹配
       boardMapper.insert(cloneIgnoreId(dbBoard, o -> o.setName(null)));
       // 测试 status 不匹配
       boardMapper.insert(cloneIgnoreId(dbBoard, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       boardMapper.insert(cloneIgnoreId(dbBoard, o -> o.setCreateTime(null)));
       // 准备参数
       BoardPageReqVO reqVO = new BoardPageReqVO();
       reqVO.setName(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<BoardDO> pageResult = boardService.getBoardPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbBoard, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetBoardList() {
       // mock 数据
       BoardDO dbBoard = randomPojo(BoardDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       boardMapper.insert(dbBoard);
       // 测试 name 不匹配
       boardMapper.insert(cloneIgnoreId(dbBoard, o -> o.setName(null)));
       // 测试 status 不匹配
       boardMapper.insert(cloneIgnoreId(dbBoard, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       boardMapper.insert(cloneIgnoreId(dbBoard, o -> o.setCreateTime(null)));
       // 准备参数
       BoardExportReqVO reqVO = new BoardExportReqVO();
       reqVO.setName(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<BoardDO> list = boardService.getBoardList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbBoard, list.get(0));
    }

}
