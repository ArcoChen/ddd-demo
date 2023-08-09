package org.ddd.demo.common.base;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author huangjiachang
 * @date 2023/8/9
 */
public class SortingField extends DTO {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("排序字段")
    private String column;
    @ApiModelProperty("是否升序, 默认升序")
    private boolean asc = true;

    public String getColumn() {
        return this.column;
    }

    public boolean isAsc() {
        return this.asc;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SortingField)) {
            return false;
        } else {
            SortingField other = (SortingField) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$column = this.getColumn();
                Object other$column = other.getColumn();
                if (this$column == null) {
                    if (other$column == null) {
                        return this.isAsc() == other.isAsc();
                    }
                } else if (this$column.equals(other$column)) {
                    return this.isAsc() == other.isAsc();
                }

                return false;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof SortingField;
    }

    @Override
    public int hashCode() {
        int result = 1;
        Object $column = this.getColumn();
        result = result * 59 + ($column == null ? 43 : $column.hashCode());
        result = result * 59 + (this.isAsc() ? 79 : 97);
        return result;
    }

    @Override
    public String toString() {
        return "SortingField(column=" + this.getColumn() + ", asc=" + this.isAsc() + ")";
    }

    public SortingField() {
    }

    public SortingField(String column, boolean asc) {
        this.column = column;
        this.asc = asc;
    }
}
