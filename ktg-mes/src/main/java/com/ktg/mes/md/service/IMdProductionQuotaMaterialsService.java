package com.ktg.mes.md.service;

import java.io.IOException;
import java.util.List;
import com.ktg.mes.md.domain.MdProductionQuotaMaterials;
import org.springframework.web.multipart.MultipartFile;

/**
 * 产品定额物料详情Service接口
 * 
 * @author yinjinlu
 * @date 2024-12-06
 */
public interface IMdProductionQuotaMaterialsService 
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
     * 批量删除产品定额物料详情
     * 
     * @param materialIds 需要删除的产品定额物料详情主键集合
     * @return 结果
     */
    public int deleteMdProductionQuotaMaterialsByMaterialIds(Long[] materialIds);

    /**
     * 删除产品定额物料详情信息
     * 
     * @param materialId 产品定额物料详情主键
     * @return 结果
     */
    public int deleteMdProductionQuotaMaterialsByMaterialId(Long materialId);

    /**
     * 導入定額物料
     * @param file
     * @param quotaId
     * @return
     */
    public int processExcelAndGenerateSql(MultipartFile file, String quotaId)  throws IOException;

    /**
     * 清除指定产品定额原始文件所生成的定额物料信息（根据多个文件ID批量操作）
     *
     * @param fileId 需要删除的数据主键集合
     * @return 结果，可用于判断软删除操作是否成功（根据实际情况决定是否需要返回值及具体含义）
     */
    public int clearMdProductionQuotaFilesMaterialsByFileIds(Long fileId);
}
