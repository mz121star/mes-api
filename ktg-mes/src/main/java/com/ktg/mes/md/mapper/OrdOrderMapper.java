package com.ktg.mes.md.mapper;

import java.util.List;
import com.ktg.mes.md.domain.OrdOrder;

/**
 * 订单Mapper接口
 *
 * @author yinjinlu
 * @date 2024-11-26
 */
public interface OrdOrderMapper
{
    /**
     * 查询订单
     *
     * @param orderId 订单主键
     * @return 订单
     */
    public OrdOrder selectOrdOrderByOrderId(Long orderId);

    /**
     * 查询订单列表
     *
     * @param ordOrder 订单
     * @return 订单集合
     */
    public List<OrdOrder> selectOrdOrderList(OrdOrder ordOrder);

    /**
     * 新增订单
     *
     * @param ordOrder 订单
     * @return 结果
     */
    public int insertOrdOrder(OrdOrder ordOrder);

    /**
     * 修改订单
     *
     * @param ordOrder 订单
     * @return 结果
     */
    public int updateOrdOrder(OrdOrder ordOrder);

    /**
     * 删除订单
     *
     * @param orderId 订单主键
     * @return 结果
     */
    public int deleteOrdOrderByOrderId(Long orderId);

    /**
     * 批量删除订单
     *
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrdOrderByOrderIds(Long[] orderIds);
}
