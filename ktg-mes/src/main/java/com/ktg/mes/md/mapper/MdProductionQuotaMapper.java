package com.ktg.mes.md.mapper;

import java.util.List;
import com.ktg.mes.md.domain.MdProductionQuota;
import com.ktg.mes.md.domain.MdProductionQuotaFiles;
import com.ktg.mes.md.domain.MdProductionQuotaMaterials;

/**
 * 产品定额Mapper接口
 *
 * @author yinjinlu
 * @date 2024-12-06
 */
public interface MdProductionQuotaMapper
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
     * 删除产品定额
     *
     * @param quotaId 产品定额主键
     * @return 结果
     */
    public int deleteMdProductionQuotaByQuotaId(Long quotaId);

    /**
     * 批量删除产品定额
     *
     * @param quotaIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMdProductionQuotaByQuotaIds(Long[] quotaIds);

    /**
     * 批量删除产品定额物料详情
     *
     * @param quotaIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMdProductionQuotaMaterialsByQuotaIds(Long[] quotaIds);

    /**
     * 批量新增产品定额物料详情
     *
     * @param mdProductionQuotaMaterialsList 产品定额物料详情列表
     * @return 结果
     */
    public int batchMdProductionQuotaMaterials(List<MdProductionQuotaMaterials> mdProductionQuotaMaterialsList);


    /**
     * 通过产品定额主键删除产品定额物料详情信息
     *
     * @param quotaId 产品定额ID
     * @return 结果
     */
    public int deleteMdProductionQuotaMaterialsByQuotaId(Long quotaId);

    /**
     * 批量删除产品定额原始文件
     *
     * @param quotaIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMdProductionQuotaFilesByQuotaIds(Long[] quotaIds);

    /**
     * 批量新增产品定额原始文件
     *
     * @param mdProductionQuotaFilesList 产品定额原始文件列表
     * @return 结果
     */
    public int batchMdProductionQuotaFiles(List<MdProductionQuotaFiles> mdProductionQuotaFilesList);


    /**
     * 通过产品定额主键删除产品定额原始文件信息
     *
     * @param quotaId 产品定额ID
     * @return 结果
     */
    public int deleteMdProductionQuotaFilesByQuotaId(Long quotaId);
}
