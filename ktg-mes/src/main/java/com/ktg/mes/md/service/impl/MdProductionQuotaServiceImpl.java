package com.ktg.mes.md.service.impl;

import java.util.List;

import com.ktg.mes.md.domain.MdProductionQuotaFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ktg.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ktg.mes.md.domain.MdProductionQuotaMaterials;
import com.ktg.mes.md.mapper.MdProductionQuotaMapper;
import com.ktg.mes.md.domain.MdProductionQuota;
import com.ktg.mes.md.service.IMdProductionQuotaService;

/**
 * 产品定额Service业务层处理
 *
 * @author yinjinlu
 * @date 2024-12-06
 */
@Service
public class MdProductionQuotaServiceImpl implements IMdProductionQuotaService
{
    @Autowired
    private MdProductionQuotaMapper mdProductionQuotaMapper;

    /**
     * 查询产品定额
     *
     * @param quotaId 产品定额主键
     * @return 产品定额
     */
    @Override
    public MdProductionQuota selectMdProductionQuotaByQuotaId(Long quotaId)
    {
        return mdProductionQuotaMapper.selectMdProductionQuotaByQuotaId(quotaId);
    }

    /**
     * 查询产品定额列表
     *
     * @param mdProductionQuota 产品定额
     * @return 产品定额
     */
    @Override
    public List<MdProductionQuota> selectMdProductionQuotaList(MdProductionQuota mdProductionQuota)
    {
        return mdProductionQuotaMapper.selectMdProductionQuotaList(mdProductionQuota);
    }

    /**
     * 新增产品定额
     *
     * @param mdProductionQuota 产品定额
     * @return 结果
     */
    @Transactional
    @Override
    public int insertMdProductionQuota(MdProductionQuota mdProductionQuota)
    {
        int rows = mdProductionQuotaMapper.insertMdProductionQuota(mdProductionQuota);
        insertMdProductionQuotaMaterials(mdProductionQuota);
        return rows;
    }

    /**
     * 修改产品定额
     *
     * @param mdProductionQuota 产品定额
     * @return 结果
     */
    @Transactional
    @Override
    public int updateMdProductionQuota(MdProductionQuota mdProductionQuota)
    {
        mdProductionQuotaMapper.deleteMdProductionQuotaMaterialsByQuotaId(mdProductionQuota.getQuotaId());
        insertMdProductionQuotaMaterials(mdProductionQuota);
        return mdProductionQuotaMapper.updateMdProductionQuota(mdProductionQuota);
    }

    /**
     * 批量删除产品定额
     *
     * @param quotaIds 需要删除的产品定额主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMdProductionQuotaByQuotaIds(Long[] quotaIds)
    {
        mdProductionQuotaMapper.deleteMdProductionQuotaMaterialsByQuotaIds(quotaIds);
        return mdProductionQuotaMapper.deleteMdProductionQuotaByQuotaIds(quotaIds);
    }

    /**
     * 删除产品定额信息
     *
     * @param quotaId 产品定额主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMdProductionQuotaByQuotaId(Long quotaId)
    {
        mdProductionQuotaMapper.deleteMdProductionQuotaMaterialsByQuotaId(quotaId);
        return mdProductionQuotaMapper.deleteMdProductionQuotaByQuotaId(quotaId);
    }

    /**
     * 新增产品定额物料详情信息
     *
     * @param mdProductionQuota 产品定额对象
     */
    public void insertMdProductionQuotaMaterials(MdProductionQuota mdProductionQuota)
    {
        List<MdProductionQuotaMaterials> mdProductionQuotaMaterialsList = mdProductionQuota.getMdProductionQuotaMaterialsList();
        Long quotaId = mdProductionQuota.getQuotaId();
        if (StringUtils.isNotNull(mdProductionQuotaMaterialsList))
        {
            List<MdProductionQuotaMaterials> list = new ArrayList<MdProductionQuotaMaterials>();
            for (MdProductionQuotaMaterials mdProductionQuotaMaterials : mdProductionQuotaMaterialsList)
            {
                mdProductionQuotaMaterials.setQuotaId(quotaId);
                list.add(mdProductionQuotaMaterials);
            }
            if (!list.isEmpty())
            {
                mdProductionQuotaMapper.batchMdProductionQuotaMaterials(list);
            }
        }
    }

    /**
     * 新增产品定额原始文件信息
     *
     * @param mdProductionQuota 产品定额对象
     */
    public void insertMdProductionQuotaFiles(MdProductionQuota mdProductionQuota)
    {
        List<MdProductionQuotaFiles> mdProductionQuotaFilesList = mdProductionQuota.getMdProductionQuotaFilesList();
        Long quotaId = mdProductionQuota.getQuotaId();
        if (StringUtils.isNotNull(mdProductionQuotaFilesList))
        {
            List<MdProductionQuotaFiles> list = new ArrayList<MdProductionQuotaFiles>();
            for (MdProductionQuotaFiles mdProductionQuotaFiles : mdProductionQuotaFilesList)
            {
                mdProductionQuotaFiles.setQuotaId(quotaId);
                list.add(mdProductionQuotaFiles);
            }
            if (!list.isEmpty())
            {
                mdProductionQuotaMapper.batchMdProductionQuotaFiles(list);
            }
        }
    }
}
