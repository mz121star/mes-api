package com.ktg.mes.md.service;

import java.util.List;
import com.ktg.mes.md.domain.MdProductionQuotaFiles;

/**
 * 产品定额原始文件Service接口
 * 
 * @author yinjinlu
 * @date 2024-12-13
 */
public interface IMdProductionQuotaFilesService 
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
     * 批量删除产品定额原始文件
     * 
     * @param fileIds 需要删除的产品定额原始文件主键集合
     * @return 结果
     */
    public int deleteMdProductionQuotaFilesByFileIds(Long[] fileIds);

    /**
     * 删除产品定额原始文件信息
     * 
     * @param fileId 产品定额原始文件主键
     * @return 结果
     */
    public int deleteMdProductionQuotaFilesByFileId(Long fileId);

    /**
     * 软删除产品定额原始文件（根据单个文件ID）
     *
     * @param fileId 产品定额原始文件主键
     * @return 结果，可用于判断软删除操作是否成功（根据实际情况决定是否需要返回值及具体含义）
     */
    public int softDeleteMdProductionQuotaFilesByFileId(Long fileId);

    /**
     * 软删除产品定额原始文件（根据多个文件ID批量操作）
     *
     * @param fileIds 需要软删除的数据主键集合
     * @return 结果，可用于判断软删除操作是否成功（根据实际情况决定是否需要返回值及具体含义）
     */
    public int softDeleteMdProductionQuotaFilesByFileIds(Long[] fileIds);


    /**
     * 把已生成的产品定额原始文件清空（根据多个文件ID批量操作）
     *
     * @param fileId 需要软删除的数据主键集合
     * @return 结果，可用于判断软删除操作是否成功（根据实际情况决定是否需要返回值及具体含义）
     */
    public  int clearMdProductionQuotaFilesByFileId(Long fileId);


}
