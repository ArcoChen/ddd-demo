package org.ddd.demo.order.client.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.ddd.demo.common.baseEnum.BaseEnum;

/**
 * @author huangjiachang
 */

@Getter
@AllArgsConstructor
public enum OrderStatusEnum implements BaseEnum {
    VALID(1, "有效"),
    CANCEL(2, "已取消");

    @EnumValue
    private final Integer value;
    private final String code;

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public String getDesc() {
        return null;
    }
}
