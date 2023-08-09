package org.ddd.demo.common.convert;

/**
 * @author huangjiachang
 */
public interface BaseCmdConvert<DTO, CMD> {
    /**
     * DTO 转 CMD
     *
     * @param d d
     * @return CMD
     */
    CMD dto2Cmd(DTO d);



}
