package com.ktg.mes.md.mapper;

import java.util.List;
import com.ktg.mes.md.domain.MdProductionQuotaFiles;

/**
 * 产品定额原始文件Mapper接口
 * 
 * @author yinjinlu
 * @date 2024-12-13
 */
public interface MdProductionQuotaFilesMapper 
{
    /**
     * 查询产品定额原始文件
     * 
     * @param fileId 产品定额原始文件主键
     * @return 产品定额原始文件
     */
    public MdProductionQuotaFiles selectMdProductionQuotaFilesByFileId(Long fileId);

    /**
     * 查询产品定额原始文件列表
     * 
     * @param mdProductionQuotaFiles 产品定额原始文件
     * @return 产品定额原始文件集合
     */
    public List<MdProductionQuotaFiles> selectMdProductionQuotaFilesList(MdProductionQuotaFiles mdProductionQuotaFiles);

    /**
     * 新增产品定额原始文件
     * 
     * @param mdProductionQuotaFiles 产品定额原始文件
     * @return 结果
     */
    public int insertMdProductionQuotaFiles(MdProductionQuotaFiles mdProductionQuotaFiles);

    /**
     * 修改产品定额原始文件
     * 
     * @param mdProductionQuotaFiles 产品定额原始文件
     * @return 结果
     */
    public int updateMdProductionQuotaFiles(MdProductionQuotaFiles mdProductionQuotaFiles);

    /**
     * 删除产品定额原始文件
     * 
     * @param fileId 产品定额原始文件主键
     * @return 结果
     */
    public int deleteMdProductionQuotaFilesByFileId(Long fileId);

    /**
     * 批量删除产品定额原始文件
     * 
     * @param fileIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMdProductionQuotaFilesByFileIds(Long[] fileIds);
    /**
     * 软删除产品定额原始文件（根据单个文件ID）
     *
     * @param fileId 产品定额原始文件主键
     * @return 受影响的行数，用于判断软删除操作是否成功（可根据实际情况决定是否需要返回值）
     */
    public int softDeleteMdProductionQuotaFilesByFileId(Long fileId);

    /**
     * 软删除产品定额原始文件（根据多个文件ID批量操作）
     *
     * @param fileIds 需要软删除的数据主键集合
     * @return 受影响的行数，用于判断软删除操作是否成功（可根据实际情况决定是否需要返回值）
     */
    public int softDeleteMdProductionQuotaFilesByFileIds(Long[] fileIds);


}
