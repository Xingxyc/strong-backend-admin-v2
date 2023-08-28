package com.strong.boot.module.demo.controller.admin.board.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 格局版 demo更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BoardUpdateReqVO extends BoardBaseVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "31813")
    @NotNull(message = "编号不能为空")
    private Long id;

}
