package com.strong.boot.module.demo.controller.admin.board;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import com.strong.boot.framework.common.pojo.PageResult;
import com.strong.boot.framework.common.pojo.CommonResult;
import static com.strong.boot.framework.common.pojo.CommonResult.success;

import com.strong.boot.framework.excel.core.util.ExcelUtils;

import com.strong.boot.framework.operatelog.core.annotations.OperateLog;
import static com.strong.boot.framework.operatelog.core.enums.OperateTypeEnum.*;

import com.strong.boot.module.demo.controller.admin.board.vo.*;
import com.strong.boot.module.demo.dal.dataobject.board.BoardDO;
import com.strong.boot.module.demo.convert.board.BoardConvert;
import com.strong.boot.module.demo.service.board.BoardService;

@Tag(name = "管理后台 - 格局版 demo")
@RestController
@RequestMapping("/demo/board")
@Validated
public class BoardController {

    @Resource
    private BoardService boardService;

    @PostMapping("/create")
    @Operation(summary = "创建格局版 demo")
    @PreAuthorize("@ss.hasPermission('demo:board:create')")
    public CommonResult<Long> createBoard(@Valid @RequestBody BoardCreateReqVO createReqVO) {
        return success(boardService.createBoard(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新格局版 demo")
    @PreAuthorize("@ss.hasPermission('demo:board:update')")
    public CommonResult<Boolean> updateBoard(@Valid @RequestBody BoardUpdateReqVO updateReqVO) {
        boardService.updateBoard(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除格局版 demo")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('demo:board:delete')")
    public CommonResult<Boolean> deleteBoard(@RequestParam("id") Long id) {
        boardService.deleteBoard(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得格局版 demo")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('demo:board:query')")
    public CommonResult<BoardRespVO> getBoard(@RequestParam("id") Long id) {
        BoardDO board = boardService.getBoard(id);
        return success(BoardConvert.INSTANCE.convert(board));
    }

    @GetMapping("/list")
    @Operation(summary = "获得格局版 demo列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('demo:board:query')")
    public CommonResult<List<BoardRespVO>> getBoardList(@RequestParam("ids") Collection<Long> ids) {
        List<BoardDO> list = boardService.getBoardList(ids);
        return success(BoardConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得格局版 demo分页")
    @PreAuthorize("@ss.hasPermission('demo:board:query')")
    public CommonResult<PageResult<BoardRespVO>> getBoardPage(@Valid BoardPageReqVO pageVO) {
        PageResult<BoardDO> pageResult = boardService.getBoardPage(pageVO);
        return success(BoardConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出格局版 demo Excel")
    @PreAuthorize("@ss.hasPermission('demo:board:export')")
    @OperateLog(type = EXPORT)
    public void exportBoardExcel(@Valid BoardExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<BoardDO> list = boardService.getBoardList(exportReqVO);
        // 导出 Excel
        List<BoardExcelVO> datas = BoardConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "格局版 demo.xls", "数据", BoardExcelVO.class, datas);
    }

}
