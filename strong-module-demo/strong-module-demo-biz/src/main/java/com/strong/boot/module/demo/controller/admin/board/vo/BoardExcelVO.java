package com.strong.boot.module.demo.controller.admin.board.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 格局版 demo Excel VO
 *
 * @author xingyichuan
 */
@Data
public class BoardExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("版号")
    private String name;

    @ExcelProperty("状态")
    private Byte status;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
