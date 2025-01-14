package com.ktg.mes.md.service.impl;

import java.util.List;
import com.ktg.common.utils.DateUtils;
import com.ktg.mes.md.mapper.MdProductionQuotaMaterialsMapper;
import com.ktg.system.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ktg.mes.md.mapper.MdProductionQuotaFilesMapper;
import com.ktg.mes.md.domain.MdProductionQuotaFiles;
import com.ktg.mes.md.service.IMdProductionQuotaFilesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 产品定额原始文件Service业务层处理
 * 
 * @author yinjinlu
 * @date 2024-12-13
 */
@Service
public class MdProductionQuotaFilesServiceImpl implements IMdProductionQuotaFilesService 
{
    private static final Logger logger = LoggerFactory.getLogger(MdProductionQuotaFilesServiceImpl.class);
    @Autowired
    private MdProductionQuotaFilesMapper mdProductionQuotaFilesMapper;

    @Autowired
    private MdProductionQuotaMaterialsMapper mdProductionQuotaMaterialsMapper;
    /**
     * 查询产品定额原始文件
     * 
     * @param fileId 产品定额原始文件主键
     * @return 产品定额原始文件
     */
    @Override
    public MdProductionQuotaFiles selectMdProductionQuotaFilesByFileId(Long fileId)
    {
        return mdProductionQuotaFilesMapper.selectMdProductionQuotaFilesByFileId(fileId);
    }

    /**
     * 查询产品定额原始文件列表
     * 
     * @param mdProductionQuotaFiles 产品定额原始文件
     * @return 产品定额原始文件
     */
    @Override
    public List<MdProductionQuotaFiles> selectMdProductionQuotaFilesList(MdProductionQuotaFiles mdProductionQuotaFiles)
    {
        return mdProductionQuotaFilesMapper.selectMdProductionQuotaFilesList(mdProductionQuotaFiles);
    }

    /**
     * 新增产品定额原始文件
     * 
     * @param mdProductionQuotaFiles 产品定额原始文件
     * @return 结果
     */
    @Override
    public int insertMdProductionQuotaFiles(MdProductionQuotaFiles mdProductionQuotaFiles)
    {
        mdProductionQuotaFiles.setCreateTime(DateUtils.getNowDate());
        return mdProductionQuotaFilesMapper.insertMdProductionQuotaFiles(mdProductionQuotaFiles);
    }

    /**
     * 修改产品定额原始文件
     * 
     * @param mdProductionQuotaFiles 产品定额原始文件
     * @return 结果
     */
    @Override
    public int updateMdProductionQuotaFiles(MdProductionQuotaFiles mdProductionQuotaFiles)
    {
        mdProductionQuotaFiles.setUpdateTime(DateUtils.getNowDate());
        return mdProductionQuotaFilesMapper.updateMdProductionQuotaFiles(mdProductionQuotaFiles);
    }

    /**
     * 批量删除产品定额原始文件
     * 
     * @param fileIds 需要删除的产品定额原始文件主键
     * @return 结果
     */
    @Override
    public int deleteMdProductionQuotaFilesByFileIds(Long[] fileIds)
    {
        return mdProductionQuotaFilesMapper.deleteMdProductionQuotaFilesByFileIds(fileIds);
    }

    /**
     * 删除产品定额原始文件信息
     * 
     * @param fileId 产品定额原始文件主键
     * @return 结果
     */
    @Override
    public int deleteMdProductionQuotaFilesByFileId(Long fileId)
    {
        return mdProductionQuotaFilesMapper.deleteMdProductionQuotaFilesByFileId(fileId);
    }

    @Override
    public int softDeleteMdProductionQuotaFilesByFileId(Long fileId) {

        try {
            // 调用更新方法，若返回值不为1则抛出异常
            int delResult =  mdProductionQuotaFilesMapper.softDeleteMdProductionQuotaFilesByFileId(fileId);
            if (delResult!= 1) {
                throw new RuntimeException("更新操作未成功，预期返回值为1，实际返回值为: " + delResult);
            }
            // 如果更新成功，继续执行删除操作并返回删除操作的结果
            return   mdProductionQuotaMaterialsMapper.deleteMdProductionQuotaMaterialsByFilesId(fileId);

        } catch (Exception e) {
            // 可以在这里记录日志，方便排查问题，例如使用日志框架输出错误信息
            logger.error("执行clearMdProductionQuotaFilesByFileId方法出错", e);
            // 根据业务需求返回合适的值表示失败，这里返回0表示失败
            return 0;
        }
    }

    @Override
    public int softDeleteMdProductionQuotaFilesByFileIds(Long[] fileIds) {

        int totalDeleted = 0;
        try {
            for (Long fileId : fileIds) {
                // 逐个调用软删除单个文件记录的方法
                int delResult = softDeleteMdProductionQuotaFilesByFileId(fileId);
                if (delResult !=0) {
                    mdProductionQuotaMaterialsMapper.deleteMdProductionQuotaMaterialsByFilesId(fileId);
                    totalDeleted++;
                } else {
                    logger.error("软删除文件记录失败，文件ID: {}", fileId);
                }
            }
            if (totalDeleted < fileIds.length) {
                logger.error("批量软删除操作未完全成功，预期删除 {} 条记录，实际成功删除 {} 条记录", fileIds.length, totalDeleted);
                throw new RuntimeException("批量软删除操作未完全成功，部分记录删除失败");
            }
            // 如果所有软删除文件记录操作都成功，接着批量删除关联的材料记录，并返回删除操作的结果
            return totalDeleted;
        } catch (Exception e) {
            logger.error("执行softDeleteMdProductionQuotaFilesByFileIds方法出错", e);
            // 根据业务需求返回合适的值表示失败，这里返回0表示失败
            return 0;
        }
    }

    /**
     * 把已生成的产品定额原始文件清空（根据多个文件ID批量操作）
     *
     * @param fileId 需要软删除的数据主键集合
     * @return 结果，可用于判断软删除操作是否成功（根据实际情况决定是否需要返回值及具体含义）
     */
    @Override
    public int clearMdProductionQuotaFilesByFileId(Long fileId) {
        MdProductionQuotaFiles mdProductionQuotaFile = new MdProductionQuotaFiles();
        mdProductionQuotaFile.setFileId(fileId);
        mdProductionQuotaFile.setIsProcessed(0);
        try {
            // 调用更新方法，若返回值不为1则抛出异常
            int updateResult = mdProductionQuotaFilesMapper.updateMdProductionQuotaFiles(mdProductionQuotaFile);
            if (updateResult!= 1) {
                throw new RuntimeException("更新操作未成功，预期返回值为1，实际返回值为: " + updateResult);
            }
            // 如果更新成功，继续执行删除操作并返回删除操作的结果
            return mdProductionQuotaMaterialsMapper.deleteMdProductionQuotaMaterialsByFilesId(fileId);
        } catch (Exception e) {
            // 可以在这里记录日志，方便排查问题，例如使用日志框架输出错误信息
            logger.error("执行clearMdProductionQuotaFilesByFileId方法出错", e);
            // 根据业务需求返回合适的值表示失败，这里返回0表示失败
            return 0;
        }
    }
}
