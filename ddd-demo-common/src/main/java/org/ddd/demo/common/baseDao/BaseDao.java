package org.ddd.demo.common.baseDao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.ddd.demo.common.exception.DemoException;
import org.ddd.demo.common.resultCode.CommonResultCode;

import java.io.Serializable;

/**
 * @author huangjiachang
 */
public interface BaseDao<DO extends BaseDO> extends IService<DO> {

    /**
     * 获取queryWrapper
     *
     * @param o DO
     * @return QueryWrapper<T>
     */
    default QueryWrapper<DO> getQueryWrapper(DO o) {
        return new QueryWrapper<>(o);
    }

    /**
     * 获取单行数据 只会查一个
     *
     * @param o DO
     * @return T
     */
    default DO selectOne(DO o) {
        QueryWrapper<DO> wrapper = getQueryWrapper(o);
        wrapper.last("LIMIT 1");
        wrapper.lambda().orderByDesc(DO::getId);
        return getBaseMapper().selectOne(wrapper);
    }

    /**
     * 获取信息 通过ID
     *
     * @param id id
     * @return T
     */
    @Override
    default DO getById(Serializable id) {
        DO o = this.getBaseMapper().selectById(id);
        if (o == null) {
            throw new DemoException(CommonResultCode.DATA_NOT_EXISTS);
        }
        return o;
    }

    /**
     * 修改方法 通过ID
     *
     * @param o do
     * @return boolean
     */
    @Override
    default boolean updateById(DO o) {
        boolean success = SqlHelper.retBool(this.getBaseMapper().updateById(o));
        if (success) {
            return true;
        } else {
            throw new DemoException(CommonResultCode.DATA_OPERATION_ERROR);
        }
    }


    /**
     * 判定数据是否存在  只查ID 且只有一行
     *
     * @param o DO
     * @return boolean
     */
    default boolean exists(DO o) {
        QueryWrapper<DO> wrapper = getQueryWrapper(o);
        return doExists(wrapper);
    }

    /**
     * 判定数据是否存在  只查ID 且只有一行
     *
     * @param wrapper wrapper
     * @return boolean
     */
    default boolean doExists(QueryWrapper<DO> wrapper) {
        wrapper.lambda().select(DO::getId);
        wrapper.lambda().last("LIMIT 1");
        DO o = getBaseMapper().selectOne(wrapper);
        return o != null;
    }
}
