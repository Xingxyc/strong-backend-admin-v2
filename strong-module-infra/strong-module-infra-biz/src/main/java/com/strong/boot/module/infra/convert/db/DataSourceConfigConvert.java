package com.strong.boot.module.infra.convert.db;

import java.util.*;

import com.strong.boot.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.strong.boot.module.infra.controller.admin.db.vo.*;
import com.strong.boot.module.infra.dal.dataobject.db.DataSourceConfigDO;

/**
 * 数据源配置 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface DataSourceConfigConvert {

    DataSourceConfigConvert INSTANCE = Mappers.getMapper(DataSourceConfigConvert.class);

    DataSourceConfigDO convert(DataSourceConfigCreateReqVO bean);

    DataSourceConfigDO convert(DataSourceConfigUpdateReqVO bean);

    DataSourceConfigRespVO convert(DataSourceConfigDO bean);

    List<DataSourceConfigRespVO> convertList(List<DataSourceConfigDO> list);

}
