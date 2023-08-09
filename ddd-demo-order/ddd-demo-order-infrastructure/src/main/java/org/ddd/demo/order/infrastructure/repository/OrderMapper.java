package org.ddd.demo.order.infrastructure.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ddd.demo.order.infrastructure.OrderDO;

/**
 * 订单聚合Mapper接口
 *
 * @author huangjiachang
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderDO> {

}
