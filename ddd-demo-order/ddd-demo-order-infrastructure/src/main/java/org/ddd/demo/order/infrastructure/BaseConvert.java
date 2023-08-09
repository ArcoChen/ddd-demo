package org.ddd.demo.order.infrastructure;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author huangjiachang
 */
public interface BaseConvert<DTO,DO> {

    /**
     * dto 转 do
     *
     * @param dto DTO
     * @return DO
     */
    DO dto2Do(DTO dto);

    /**
     * do 转 dto
     *
     * @param d DO
     * @return DTO
     */
    DTO do2Dto(DO d);

    /**
     * doList 转 dtoList
     *
     * @param doList List<DO>
     * @return List<DTO>
     */
    List<DTO> doList2DtoList(List<DO> doList);

    /**
     * dtoList 转 doList
     *
     * @param dtoList List<DTO>
     * @return List<DO>
     */
    List<DO> dtoList2DoList(List<DTO> dtoList);

    /**
     * 转分页
     *
     * @param doPageInfo doPageInfo
     * @return PageInfo<DTO>
     */
    PageInfo<DTO> toDtoList(PageInfo<DO> doPageInfo);
}
