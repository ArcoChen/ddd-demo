package org.ddd.demo.common.base;

import io.swagger.annotations.ApiModelProperty;
import org.ddd.demo.common.constant.PageConstant;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author huangjiachang
 * @date 2023/8/9
 */
public class PageQuery extends BaseQuery {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(
            value = "每页数量(不能为空)",
            example = "10"
    )
    private @NotNull(
            message = "每页数量不能为空"
    )
    @Max(
            value = 200L,
            message = "每页最大为200"
    ) Integer pageSize;
    @ApiModelProperty(
            value = "页码(不能为空)",
            example = "1"
    )
    private @NotNull(
            message = "分页参数不能为空"
    ) Integer pageNo;
    @ApiModelProperty("是否查询总条数")
    private Boolean searchCount;
    private Integer offset;

    public PageQuery() {
    }

    public Integer getPageSize() {
        return this.pageSize != null && this.pageSize >= 1 ? this.pageSize : PageConstant.DEFAULT_PAGE_SIZE;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return null != this.pageNo && this.pageNo >= 1 ? this.pageNo : PageConstant.DEFAULT_PAGE_NO;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Boolean getSearchCount() {
        return this.searchCount;
    }

    public void setSearchCount(Boolean searchCount) {
        this.searchCount = searchCount;
    }

    public Integer getOffset() {
        return this.pageNo != null && this.pageSize != null ? this.pageNo == 0 ? 0 : (this.pageNo - 1) * this.pageSize : 0;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
