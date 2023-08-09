package org.ddd.demo.common.baseEnum;

import java.util.Objects;

/**
 * @author huangjiachang
 */
public interface BaseEnum {
    Object getValue();

    String getDesc();

    default boolean equalsValue(Object value) {
        return Objects.equals(this.getValue(), value);
    }

    default boolean equals(BaseEnum baseEnum) {
        return baseEnum != null && Objects.equals(this.getValue(), baseEnum.getValue()) && Objects.equals(this.getDesc(), baseEnum.getDesc());
    }
}
