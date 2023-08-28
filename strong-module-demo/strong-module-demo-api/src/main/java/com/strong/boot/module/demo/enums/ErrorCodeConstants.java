package com.strong.boot.module.demo.enums;

import com.strong.boot.framework.common.exception.ErrorCode;

/**
 * ClassName: ErrorCodeConstants
 * Package: com.strong.boot.module.demo.enums
 * Description:
 *
 * @Author xingyichuan
 * @Create 2023/8/27 22:46
 */
public interface ErrorCodeConstants {

    // ========== 格局版 demo 1010000000 ==========
    ErrorCode BOARD_NOT_EXISTS = new ErrorCode(1010000001, "格局版 demo不存在");
}
