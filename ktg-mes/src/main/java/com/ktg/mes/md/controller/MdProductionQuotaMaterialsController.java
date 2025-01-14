package com.ktg.mes.md.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

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
import com.ktg.mes.md.domain.MdProductionQuotaMaterials;
import com.ktg.mes.md.service.IMdProductionQuotaMaterialsService;
import com.ktg.common.utils.poi.ExcelUtil;
import com.ktg.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 产品定额物料详情Controller
 * 
 * @author yinjinlu
 * @date 2024-12-06
 */
@RestController
@RequestMapping("mes/md/materials")
public class MdProductionQuotaMaterialsController extends BaseController
{
    @Autowired
    private IMdProductionQuotaMaterialsService mdProductionQuotaMaterialsService;

    /**
     * 查询产品定额物料详情列表
     */
    @PreAuthorize("@ss.hasPermi('mes:md:materials:list')")
    @GetMapping("/list")
    public TableDataInfo list(MdProductionQuotaMaterials mdProductionQuotaMaterials)
    {
        startPage();
        List<MdProductionQuotaMaterials> list = mdProductionQuotaMaterialsService.selectMdProductionQuotaMaterialsList(mdProductionQuotaMaterials);
        return getDataTable(list);
    }

    /**
     * 导出产品定额物料详情列表
     */
    @PreAuthorize("@ss.hasPermi('mes:md:materials:export')")
    @Log(title = "产品定额物料详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdProductionQuotaMaterials mdProductionQuotaMaterials)
    {
        List<MdProductionQuotaMaterials> list = mdProductionQuotaMaterialsService.selectMdProductionQuotaMaterialsList(mdProductionQuotaMaterials);
        ExcelUtil<MdProductionQuotaMaterials> util = new ExcelUtil<MdProductionQuotaMaterials>(MdProductionQuotaMaterials.class);
        util.exportExcel(response, list, "产品定额物料详情数据");
    }

    /**
     * 获取产品定额物料详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('mes:md:materials:query')")
    @GetMapping(value = "/{materialId}")
    public AjaxResult getInfo(@PathVariable("materialId") Long materialId)
    {
        return AjaxResult.success(mdProductionQuotaMaterialsService.selectMdProductionQuotaMaterialsByMaterialId(materialId));
    }

    /**
     * 新增产品定额物料详情
     */
    @PreAuthorize("@ss.hasPermi('mes:md:materials:add')")
    @Log(title = "产品定额物料详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdProductionQuotaMaterials mdProductionQuotaMaterials)
    {
        return toAjax(mdProductionQuotaMaterialsService.insertMdProductionQuotaMaterials(mdProductionQuotaMaterials));
    }

    /**
     * 修改产品定额物料详情
     */
    @PreAuthorize("@ss.hasPermi('mes:md:materials:edit')")
    @Log(title = "产品定额物料详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdProductionQuotaMaterials mdProductionQuotaMaterials)
    {
        return toAjax(mdProductionQuotaMaterialsService.updateMdProductionQuotaMaterials(mdProductionQuotaMaterials));
    }

    /**
     * 删除产品定额物料详情
     */
    @PreAuthorize("@ss.hasPermi('mes:md:materials:remove')")
    @Log(title = "产品定额物料详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{materialIds}")
    public AjaxResult remove(@PathVariable Long[] materialIds)
    {
        return toAjax(mdProductionQuotaMaterialsService.deleteMdProductionQuotaMaterialsByMaterialIds(materialIds));
    }

//    /**
//     * 从模板导入定额
//     * @param file
//     * @param updateSupport
//     * @return
//     * @throws Exception
//     */
//    @Log(title = "产品定额物料导入", businessType = BusinessType.IMPORT)
//    @PreAuthorize("@ss.hasPermi('mes:md:materials:import')")
//    @PostMapping("/importData")
//    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
//    {
//        ExcelUtil<MdItem> util = new ExcelUtil<MdItem>(MdItem.class);
//        List<MdItem> mdItemList = util.importExcel(file.getInputStream());
//        String operName = getUsername();
//        String message = mdItemService.importItem(mdItemList, updateSupport, operName);
//        return AjaxResult.success(message);
//    }
    @Log(title = "产品定额物料导入", businessType = BusinessType.IMPORT)
   @PreAuthorize("@ss.hasPermi('mes:md:materials:import')")
    @PostMapping("/importData")
    public AjaxResult importData( MultipartFile file,  String quotaId) {
        try {
            mdProductionQuotaMaterialsService.processExcelAndGenerateSql(file,quotaId);

            return  AjaxResult.success("Excel文件处理成功，SQL语句已生成。");
        }  catch (IOException e) {
            e.printStackTrace();
           return  AjaxResult.error("Excel文件处理失败，请检查文件或相关配置。");
        }
    }
}
