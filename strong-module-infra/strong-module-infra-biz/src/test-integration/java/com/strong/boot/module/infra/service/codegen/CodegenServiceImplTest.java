package com.strong.boot.module.infra.service.codegen;

import com.strong.boot.module.infra.test.BaseDbUnitTest;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

class CodegenServiceImplTest extends BaseDbUnitTest {

    @Resource
    private CodegenServiceImpl codegenService;

    @Test
    public void tetCreateCodegenTable() {
        codegenService.createCodegen(0L, "infra_test_demo");
//        infraCodegenService.createCodegenTable("infra_codegen_table");
//        infraCodegenService.createCodegen("infra_codegen_column");
    }

}
