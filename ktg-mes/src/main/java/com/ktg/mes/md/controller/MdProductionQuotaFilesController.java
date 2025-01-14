package com.ktg.mes.md.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ktg.common.utils.barcode.BarcodeUtil;
import com.ktg.common.utils.file.FileUploadUtils;
import com.ktg.common.utils.file.FileUtils;
import com.ktg.mes.md.domain.MdItem;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ktg.common.annotation.Log;
import com.ktg.common.core.controller.BaseController;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.common.enums.BusinessType;
import com.ktg.mes.md.domain.MdProductionQuotaFiles;
import com.ktg.mes.md.service.IMdProductionQuotaFilesService;
import com.ktg.common.utils.poi.ExcelUtil;
import com.ktg.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 产品定额原始文件Controller
 * 
 * @author yinjinlu
 * @date 2024-12-13
 */
@RestController
@RequestMapping("mes/md/files")
public class MdProductionQuotaFilesController extends BaseController
{
    @Autowired
    private IMdProductionQuotaFilesService mdProductionQuotaFilesService;

    /**
     * 查询产品定额原始文件列表
     */
    @PreAuthorize("@ss.hasPermi('mes:md:files:list')")
    @GetMapping("/list")
    public TableDataInfo list(MdProductionQuotaFiles mdProductionQuotaFiles)
    {
        startPage();
        List<MdProductionQuotaFiles> list = mdProductionQuotaFilesService.selectMdProductionQuotaFilesList(mdProductionQuotaFiles);
        return getDataTable(list);
    }

    /**
     * 导出产品定额原始文件列表
     */
    @PreAuthorize("@ss.hasPermi('mes:md:files:export')")
    @Log(title = "产品定额原始文件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdProductionQuotaFiles mdProductionQuotaFiles)
    {
        List<MdProductionQuotaFiles> list = mdProductionQuotaFilesService.selectMdProductionQuotaFilesList(mdProductionQuotaFiles);
        ExcelUtil<MdProductionQuotaFiles> util = new ExcelUtil<MdProductionQuotaFiles>(MdProductionQuotaFiles.class);
        util.exportExcel(response, list, "产品定额原始文件数据");
    }


    /**
     * 从模板导入定额文件
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @Log(title = "产品定额原始文件导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('mes:md:files:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        String fileName = null;
        try {
            fileName = FileUploadUtils.uploadMinio(file);
            return AjaxResult.success(fileName);
        } catch (IOException e) {
            //e.printStackTrace();
            return AjaxResult.error(e.getMessage());
            //return null;
        }finally{

        }




    }


    /**
     * 获取产品定额原始文件详细信息
     */
    @PreAuthorize("@ss.hasPermi('mes:md:files:query')")
    @GetMapping(value = "/{fileId}")
    public AjaxResult getInfo(@PathVariable("fileId") Long fileId)
    {
        return AjaxResult.success(mdProductionQuotaFilesService.selectMdProductionQuotaFilesByFileId(fileId));
    }

    /**
     * 新增产品定额原始文件
     */
    @PreAuthorize("@ss.hasPermi('mes:md:files:add')")
    @Log(title = "产品定额原始文件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdProductionQuotaFiles mdProductionQuotaFiles)
    {
        return toAjax(mdProductionQuotaFilesService.insertMdProductionQuotaFiles(mdProductionQuotaFiles));
    }

    /**
     * 修改产品定额原始文件
     */
    @PreAuthorize("@ss.hasPermi('mes:md:files:edit')")
    @Log(title = "产品定额原始文件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdProductionQuotaFiles mdProductionQuotaFiles)
    {
        return toAjax(mdProductionQuotaFilesService.updateMdProductionQuotaFiles(mdProductionQuotaFiles));
    }

    /**
     * 把已生成的产品定额原始文件清空
     */
    @PreAuthorize("@ss.hasPermi('mes:md:files:edit')")
    @Log(title = "产品定额原始文件", businessType = BusinessType.DELETE)
    @DeleteMapping("/clear/{fileId}")
    public AjaxResult clear(@PathVariable Long fileId)
    {
        return toAjax(mdProductionQuotaFilesService.clearMdProductionQuotaFilesByFileId(fileId));
    }

    /**
     * 删除产品定额原始文件
     */
    @PreAuthorize("@ss.hasPermi('mes:md:files:remove')")
    @Log(title = "产品定额原始文件", businessType = BusinessType.DELETE)
	@DeleteMapping("/delete/{fileIds}")
    public AjaxResult remove(@PathVariable Long[] fileIds)
    {
        return toAjax(mdProductionQuotaFilesService.softDeleteMdProductionQuotaFilesByFileIds(fileIds));
    }
}
