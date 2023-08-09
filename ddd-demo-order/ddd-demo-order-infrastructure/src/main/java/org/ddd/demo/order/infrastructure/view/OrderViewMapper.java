package org.ddd.demo.order.infrastructure.view;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ddd.demo.order.infrastructure.OrderDO;

/**
 * @author huangjiachang
 */
@Mapper
public interface OrderViewMapper extends BaseMapper<OrderDO> {
}
