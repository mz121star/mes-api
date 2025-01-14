package com.ktg.mes.md.service;

import java.util.List;
import com.ktg.mes.md.domain.MdProductionQuota;

/**
 * 产品定额Service接口
 *
 * @author yinjinlu
 * @date 2024-12-06
 */
public interface IMdProductionQuotaService
{
    /**
     * 查询产品定额
     *
     * @param quotaId 产品定额主键
     * @return 产品定额
     */
    public MdProductionQuota selectMdProductionQuotaByQuotaId(Long quotaId);

    /**
     * 查询产品定额列表
     *
     * @param mdProductionQuota 产品定额
     * @return 产品定额集合
     */
    public List<MdProductionQuota> selectMdProductionQuotaList(MdProductionQuota mdProductionQuota);

    /**
     * 新增产品定额
     *
     * @param mdProductionQuota 产品定额
     * @return 结果
     */
    public int insertMdProductionQuota(MdProductionQuota mdProductionQuota);

    /**
     * 修改产品定额
     *
     * @param mdProductionQuota 产品定额
     * @return 结果
     */
    public int updateMdProductionQuota(MdProductionQuota mdProductionQuota);

    /**
     * 批量删除产品定额
     *
     * @param quotaIds 需要删除的产品定额主键集合
     * @return 结果
     */
    public int deleteMdProductionQuotaByQuotaIds(Long[] quotaIds);

    /**
     * 删除产品定额信息
     *
     * @param quotaId 产品定额主键
     * @return 结果
     */
    public int deleteMdProductionQuotaByQuotaId(Long quotaId);
}
