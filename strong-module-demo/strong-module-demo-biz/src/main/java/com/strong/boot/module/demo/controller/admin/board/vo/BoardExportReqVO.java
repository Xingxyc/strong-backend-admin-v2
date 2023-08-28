package com.strong.boot.module.demo.controller.admin.board.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import com.strong.boot.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static com.strong.boot.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 格局版 demo Excel 导出 Request VO，参数和 BoardPageReqVO 是一致的")
@Data
public class BoardExportReqVO {

    @Schema(description = "版号", example = "芋艿")
    private String name;

    @Schema(description = "状态", example = "1")
    private Byte status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
