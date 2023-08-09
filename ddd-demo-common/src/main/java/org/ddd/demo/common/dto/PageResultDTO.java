package org.ddd.demo.common.dto;

import org.ddd.demo.common.base.PageQuery;
import org.ddd.demo.common.resultCode.CommonResultCode;
import org.ddd.demo.common.resultCode.ResultCode;

import java.io.Serializable;

/**
 * @author huangjiachang
 * @date 2023/8/9
 */
public class PageResultDTO<T> extends ResultDTO<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer pageSize;
    private Integer pageNo;
    private Long totalCount = 0L;
    private Long cursor;

    public PageResultDTO() {
        this.setCode(CommonResultCode.SUCCESS.getCode());
    }

    public PageResultDTO(PageQuery pageQuery) {
        if (pageQuery != null) {
            this.pageNo = pageQuery.getPageNo();
            this.pageSize = pageQuery.getPageSize();
        }

        this.setCode(CommonResultCode.SUCCESS.getCode());
    }

    public PageResultDTO(PageResultDTO pageResultDTO) {
        if (pageResultDTO != null) {
            this.pageNo = pageResultDTO.getPageNo();
            this.pageSize = pageResultDTO.getPageSize();
            this.totalCount = pageResultDTO.getTotalCount();
        }

        this.setCode(CommonResultCode.SUCCESS.getCode());
    }

    public static <T> PageResultDTO<T> success(T value) {
        PageResultDTO<T> r = new PageResultDTO();
        r.setData(value);
        return r;
    }

    public static <T> PageResultDTO<T> fail(ResultCode resultCode) {
        PageResultDTO<T> r = new PageResultDTO();
        r.setCode(resultCode.getCode());
        r.setMsg(resultCode.getMsg());
        return r;
    }

    public static <T> PageResultDTO<T> fail() {
        PageResultDTO<T> r = new PageResultDTO();
        r.setCode(CommonResultCode.SYSTEM_ERROR.getCode());
        r.setMsg(CommonResultCode.SYSTEM_ERROR.getMsg());
        return r;
    }

    public static <T> PageResultDTO<T> fail(String msg) {
        PageResultDTO<T> r = new PageResultDTO();
        r.setCode(CommonResultCode.SYSTEM_ERROR.getCode());
        r.setMsg(msg);
        return r;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getCursor() {
        return this.cursor;
    }

    public void setCursor(Long cursor) {
        this.cursor = cursor;
    }

    @Override
    public String toString() {
        return "PageResultDTO{pageSize=" + this.pageSize + ", pageNo=" + this.pageNo + ", totalCount=" + this.totalCount + '}';
    }
}
