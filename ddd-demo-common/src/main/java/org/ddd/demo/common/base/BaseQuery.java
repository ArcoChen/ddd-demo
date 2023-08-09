package org.ddd.demo.common.base;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author huangjiachang
 * @date 2023/8/9
 */
public class BaseQuery {
    private static final long serialVersionUID = 1L;
    private Long id;
    @ApiModelProperty("排序")
    private List<SortingField> sortingFields;

    public BaseQuery() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SortingField> getSortingFields() {
        return this.sortingFields;
    }

    public void setSortingFields(List<SortingField> sortingFields) {
        this.sortingFields = sortingFields;
    }
}
