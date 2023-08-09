package org.ddd.demo.common.convert;

import java.util.List;

/**
 * @author huangjiachang
 */
public interface BaseDomainConvert<DO, PO> {
    /**
     * DO 转 PO
     *
     * @param d d
     * @return PO
     */
    PO do2Po(DO d);

    List<PO> dos2Pos(List<DO> dos);

    /**
     * po 转 DO
     *
     * @param po po
     * @return DO
     */
    DO po2Do(PO po);

    List<DO> pos2dos(List<PO> pos);





}
