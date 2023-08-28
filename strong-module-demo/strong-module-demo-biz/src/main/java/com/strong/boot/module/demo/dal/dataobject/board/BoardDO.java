package com.strong.boot.module.demo.dal.dataobject.board;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import com.strong.boot.framework.mybatis.core.dataobject.BaseDO;

/**
 * 格局版 demo DO
 *
 * @author xingyichuan
 */
@TableName("demo_board")
@KeySequence("demo_board_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 版号
     */
    private String name;
    /**
     * 状态
     */
    private Byte status;

}
