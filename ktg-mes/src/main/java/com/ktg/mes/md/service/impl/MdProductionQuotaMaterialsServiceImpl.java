package com.ktg.mes.md.service.impl;

import cn.hutool.json.JSONObject;

import com.ktg.mes.md.domain.MdProductionQuotaFiles;
import com.ktg.mes.md.mapper.MdProductionQuotaFilesMapper;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ktg.mes.md.mapper.MdProductionQuotaMaterialsMapper;
import com.ktg.mes.md.domain.MdProductionQuotaMaterials;
import com.ktg.mes.md.service.IMdProductionQuotaMaterialsService;
import org.springframework.web.multipart.MultipartFile;


/**
 * 产品定额物料详情Service业务层处理
 * 
 * @author yinjinlu
 * @date 2024-12-06
 */
@Service
public class MdProductionQuotaMaterialsServiceImpl implements IMdProductionQuotaMaterialsService
{
    @Autowired
    private MdProductionQuotaMaterialsMapper mdProductionQuotaMaterialsMapper;
    @Autowired
    private MdProductionQuotaFilesMapper mdProductionQuotaFilesMapper;

    /**
     * 查询产品定额物料详情
     * 
     * @param materialId 产品定额物料详情主键
     * @return 产品定额物料详情
     */
    @Override
    public MdProductionQuotaMaterials selectMdProductionQuotaMaterialsByMaterialId(Long materialId)
    {
        return mdProductionQuotaMaterialsMapper.selectMdProductionQuotaMaterialsByMaterialId(materialId);
    }

    /**
     * 查询产品定额物料详情列表
     * 
     * @param mdProductionQuotaMaterials 产品定额物料详情
     * @return 产品定额物料详情
     */
    @Override
    public List<MdProductionQuotaMaterials> selectMdProductionQuotaMaterialsList(MdProductionQuotaMaterials mdProductionQuotaMaterials)
    {
        return mdProductionQuotaMaterialsMapper.selectMdProductionQuotaMaterialsList(mdProductionQuotaMaterials);
    }

    /**
     * 新增产品定额物料详情
     * 
     * @param mdProductionQuotaMaterials 产品定额物料详情
     * @return 结果
     */
    @Override
    public int insertMdProductionQuotaMaterials(MdProductionQuotaMaterials mdProductionQuotaMaterials)
    {
        return mdProductionQuotaMaterialsMapper.insertMdProductionQuotaMaterials(mdProductionQuotaMaterials);
    }

    /**
     * 修改产品定额物料详情
     * 
     * @param mdProductionQuotaMaterials 产品定额物料详情
     * @return 结果
     */
    @Override
    public int updateMdProductionQuotaMaterials(MdProductionQuotaMaterials mdProductionQuotaMaterials)
    {
        return mdProductionQuotaMaterialsMapper.updateMdProductionQuotaMaterials(mdProductionQuotaMaterials);
    }

    /**
     * 批量删除产品定额物料详情
     * 
     * @param materialIds 需要删除的产品定额物料详情主键
     * @return 结果
     */
    @Override
    public int deleteMdProductionQuotaMaterialsByMaterialIds(Long[] materialIds)
    {
        return mdProductionQuotaMaterialsMapper.deleteMdProductionQuotaMaterialsByMaterialIds(materialIds);
    }

    /**
     * 删除产品定额物料详情信息
     * 
     * @param materialId 产品定额物料详情主键
     * @return 结果
     */
    @Override
    public int deleteMdProductionQuotaMaterialsByMaterialId(Long materialId)
    {
        return mdProductionQuotaMaterialsMapper.deleteMdProductionQuotaMaterialsByMaterialId(materialId);
    }


    @Override
    public int processExcelAndGenerateSql(MultipartFile file, String quotaId) throws IOException {
        return 1;
    }

    /**
     * 清除指定产品定额原始文件所生成的定额物料信息（根据多个文件ID批量操作）
     *
     * @param fileId 需要删除的数据主键集合
     * @return 结果，可用于判断软删除操作是否成功（根据实际情况决定是否需要返回值及具体含义）
     */
    @Override
    public int clearMdProductionQuotaFilesMaterialsByFileIds(Long fileId) {
        return mdProductionQuotaMaterialsMapper.deleteMdProductionQuotaMaterialsByFilesId(fileId);
    }

}
