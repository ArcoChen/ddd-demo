package org.ddd.demo.common.baseDao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.ddd.demo.common.exception.DemoException;
import org.ddd.demo.common.resultCode.CommonResultCode;

import java.util.Collection;
import java.util.List;

/**
 * @author huangjiachang
 */
public abstract class AbstractDao<M extends BaseMapper<DO>, DO extends BaseDO> extends
    ServiceImpl<M, DO> implements BaseDao<DO> {

    protected void initDefaultFiled(DO entity) {
    }

    public DO getById(Long id) {
        QueryWrapper<DO> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(DO::getId, id);
        wrapper.last("LIMIT 1");
        wrapper.lambda().orderByDesc(DO::getId);
        DO o = getBaseMapper().selectOne(wrapper);
        if (o != null) {
            return o;
        }
        throw new DemoException(CommonResultCode.DATA_NOT_EXISTS);
    }

    public List<DO> getByIds(List<Long> ids) {
        QueryWrapper<DO> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(DO::getId, ids);
        wrapper.lambda().orderByDesc((DO::getId));
        List<DO> o = getBaseMapper().selectList(wrapper);
        if (o.size() == ids.size()) {
            return o;
        }
        throw new DemoException(CommonResultCode.DATA_NOT_EXISTS);
    }

    @Override
    public boolean save(DO o) {
        initDefaultFiled(o);
        return super.save(o);
    }

    @Override
    public boolean saveBatch(Collection<DO> doList) {
        doList.forEach(this::initDefaultFiled);
        return super.saveBatch(doList);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<DO> doList) {
        doList.stream().filter(l -> l.getId() == null).forEach(this::initDefaultFiled);
        return super.saveOrUpdateBatch(doList);
    }
}
