package com.ktg.mes.pro.service.impl;

import java.util.List;
import com.ktg.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ktg.mes.pro.mapper.ProOutsourceOrderMapper;
import com.ktg.mes.pro.domain.ProOutsourceOrder;
import com.ktg.mes.pro.service.IProOutsourceOrderService;

/**
 * 外协工单Service业务层处理
 * 
 * @author yinjinlu
 * @date 2024-03-29
 */
@Service
public class ProOutsourceOrderServiceImpl implements IProOutsourceOrderService 
{
    @Autowired
    private ProOutsourceOrderMapper proOutsourceOrderMapper;

    /**
     * 查询外协工单
     * 
     * @param workorderId 外协工单主键
     * @return 外协工单
     */
    @Override
    public ProOutsourceOrder selectProOutsourceOrderByWorkorderId(Long workorderId)
    {
        return proOutsourceOrderMapper.selectProOutsourceOrderByWorkorderId(workorderId);
    }

    /**
     * 查询外协工单列表
     * 
     * @param proOutsourceOrder 外协工单
     * @return 外协工单
     */
    @Override
    public List<ProOutsourceOrder> selectProOutsourceOrderList(ProOutsourceOrder proOutsourceOrder)
    {
        return proOutsourceOrderMapper.selectProOutsourceOrderList(proOutsourceOrder);
    }

    /**
     * 新增外协工单
     * 
     * @param proOutsourceOrder 外协工单
     * @return 结果
     */
    @Override
    public int insertProOutsourceOrder(ProOutsourceOrder proOutsourceOrder)
    {
        proOutsourceOrder.setCreateTime(DateUtils.getNowDate());
        return proOutsourceOrderMapper.insertProOutsourceOrder(proOutsourceOrder);
    }

    /**
     * 修改外协工单
     * 
     * @param proOutsourceOrder 外协工单
     * @return 结果
     */
    @Override
    public int updateProOutsourceOrder(ProOutsourceOrder proOutsourceOrder)
    {
        proOutsourceOrder.setUpdateTime(DateUtils.getNowDate());
        return proOutsourceOrderMapper.updateProOutsourceOrder(proOutsourceOrder);
    }

    /**
     * 批量删除外协工单
     * 
     * @param workorderIds 需要删除的外协工单主键
     * @return 结果
     */
    @Override
    public int deleteProOutsourceOrderByWorkorderIds(Long[] workorderIds)
    {
        return proOutsourceOrderMapper.deleteProOutsourceOrderByWorkorderIds(workorderIds);
    }

    /**
     * 删除外协工单信息
     * 
     * @param workorderId 外协工单主键
     * @return 结果
     */
    @Override
    public int deleteProOutsourceOrderByWorkorderId(Long workorderId)
    {
        return proOutsourceOrderMapper.deleteProOutsourceOrderByWorkorderId(workorderId);
    }
}
