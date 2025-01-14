package com.ktg.mes.md.mapper;

import java.util.List;
import com.ktg.mes.md.domain.MdProductionQuotaMaterials;

/**
 * 产品定额物料详情Mapper接口
 * 
 * @author yinjinlu
 * @date 2024-12-06
 */
public interface MdProductionQuotaMaterialsMapper 
{
    /**
     * 查询产品定额物料详情
     * 
     * @param materialId 产品定额物料详情主键
     * @return 产品定额物料详情
     */
    public MdProductionQuotaMaterials selectMdProductionQuotaMaterialsByMaterialId(Long materialId);

    /**
     * 查询产品定额物料详情列表
     * 
     * @param mdProductionQuotaMaterials 产品定额物料详情
     * @return 产品定额物料详情集合
     */
    public List<MdProductionQuotaMaterials> selectMdProductionQuotaMaterialsList(MdProductionQuotaMaterials mdProductionQuotaMaterials);

    /**
     * 新增产品定额物料详情
     * 
     * @param mdProductionQuotaMaterials 产品定额物料详情
     * @return 结果
     */
    public int insertMdProductionQuotaMaterials(MdProductionQuotaMaterials mdProductionQuotaMaterials);

    /**
     * 修改产品定额物料详情
     * 
     * @param mdProductionQuotaMaterials 产品定额物料详情
     * @return 结果
     */
    public int updateMdProductionQuotaMaterials(MdProductionQuotaMaterials mdProductionQuotaMaterials);

    /**
     * 删除产品定额物料详情
     * 
     * @param materialId 产品定额物料详情主键
     * @return 结果
     */
    public int deleteMdProductionQuotaMaterialsByMaterialId(Long materialId);

    /**
     * 批量删除产品定额物料详情
     * 
     * @param materialIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMdProductionQuotaMaterialsByMaterialIds(Long[] materialIds);


    /**
     * 批量删除产品定额物料详情通过定额文件ID
     *
     * @param fileId 需要删除的数据定额文件编号集合
     * @return 结果
     */
    public int deleteMdProductionQuotaMaterialsByFilesId(Long fileId);
}
