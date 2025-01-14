package com.ktg.mes.md.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ktg.mes.md.mapper.OrdOrderMapper;
import com.ktg.mes.md.domain.OrdOrder;
import com.ktg.mes.md.service.IOrdOrderService;

/**
 * 订单Service业务层处理
 * 
 * @author yinjinlu
 * @date 2024-11-24
 */
@Service
public class OrdOrderServiceImpl implements IOrdOrderService 
{
    @Autowired
    private OrdOrderMapper ordOrderMapper;

    /**
     * 查询订单
     * 
     * @param orderId 订单主键
     * @return 订单
     */
    @Override
    public OrdOrder selectOrdOrderByOrderId(Long orderId)
    {
        return ordOrderMapper.selectOrdOrderByOrderId(orderId);
    }

    /**
     * 查询订单列表
     * 
     * @param ordOrder 订单
     * @return 订单
     */
    @Override
    public List<OrdOrder> selectOrdOrderList(OrdOrder ordOrder)
    {
        return ordOrderMapper.selectOrdOrderList(ordOrder);
    }

    /**
     * 新增订单
     * 
     * @param ordOrder 订单
     * @return 结果
     */
    @Override
    public int insertOrdOrder(OrdOrder ordOrder)
    {
        return ordOrderMapper.insertOrdOrder(ordOrder);
    }

    /**
     * 修改订单
     * 
     * @param ordOrder 订单
     * @return 结果
     */
    @Override
    public int updateOrdOrder(OrdOrder ordOrder)
    {
        return ordOrderMapper.updateOrdOrder(ordOrder);
    }

    /**
     * 批量删除订单
     * 
     * @param orderIds 需要删除的订单主键
     * @return 结果
     */
    @Override
    public int deleteOrdOrderByOrderIds(Long[] orderIds)
    {
        return ordOrderMapper.deleteOrdOrderByOrderIds(orderIds);
    }

    /**
     * 删除订单信息
     * 
     * @param orderId 订单主键
     * @return 结果
     */
    @Override
    public int deleteOrdOrderByOrderId(Long orderId)
    {
        return ordOrderMapper.deleteOrdOrderByOrderId(orderId);
    }
}
