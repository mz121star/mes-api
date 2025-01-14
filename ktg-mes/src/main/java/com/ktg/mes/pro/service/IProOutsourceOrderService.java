package com.ktg.mes.pro.service;

import java.util.List;
import com.ktg.mes.pro.domain.ProOutsourceOrder;

/**
 * 外协工单Service接口
 * 
 * @author yinjinlu
 * @date 2024-03-29
 */
public interface IProOutsourceOrderService 
{
    /**
     * 查询外协工单
     * 
     * @param workorderId 外协工单主键
     * @return 外协工单
     */
    public ProOutsourceOrder selectProOutsourceOrderByWorkorderId(Long workorderId);

    /**
     * 查询外协工单列表
     * 
     * @param proOutsourceOrder 外协工单
     * @return 外协工单集合
     */
    public List<ProOutsourceOrder> selectProOutsourceOrderList(ProOutsourceOrder proOutsourceOrder);

    /**
     * 新增外协工单
     * 
     * @param proOutsourceOrder 外协工单
     * @return 结果
     */
    public int insertProOutsourceOrder(ProOutsourceOrder proOutsourceOrder);

    /**
     * 修改外协工单
     * 
     * @param proOutsourceOrder 外协工单
     * @return 结果
     */
    public int updateProOutsourceOrder(ProOutsourceOrder proOutsourceOrder);

    /**
     * 批量删除外协工单
     * 
     * @param workorderIds 需要删除的外协工单主键集合
     * @return 结果
     */
    public int deleteProOutsourceOrderByWorkorderIds(Long[] workorderIds);

    /**
     * 删除外协工单信息
     * 
     * @param workorderId 外协工单主键
     * @return 结果
     */
    public int deleteProOutsourceOrderByWorkorderId(Long workorderId);
}
