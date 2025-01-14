package com.ktg.mes.md.controller;

import com.ktg.common.utils.poi.ExcelUtil;
import com.ktg.mes.aspect.BarcodeGen;
import com.ktg.mes.md.domain.MdUnitMeasure;
import com.ktg.mes.md.domain.MdVendor;
import com.ktg.mes.md.service.IMdItemService;
import com.ktg.common.annotation.Log;
import com.ktg.common.constant.UserConstants;
import com.ktg.common.core.controller.BaseController;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.common.core.domain.entity.ItemType;
import com.ktg.common.core.page.TableDataInfo;
import com.ktg.common.enums.BusinessType;
import com.ktg.common.utils.StringUtils;
import com.ktg.mes.md.domain.MdItem;
import com.ktg.mes.md.service.IItemTypeService;
import com.ktg.mes.md.service.IMdUnitMeasureService;
import com.ktg.mes.wm.utils.WmBarCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/mes/md/mditem")
public class MdItemController extends BaseController {

    @Autowired
    private IMdItemService mdItemService;

    @Autowired
    private IItemTypeService iItemTypeService;

    @Autowired
    private IMdUnitMeasureService mdUnitMeasureService;

    @Autowired
    private WmBarCodeUtil barcodeUtil;

    /**
     * 列表查询
     * @param mdItem
     * @return
     */
    @GetMapping("/list")
    public TableDataInfo list(MdItem mdItem){
        startPage();
        List<MdItem> list = mdItemService.selectMdItemList(mdItem);
        return getDataTable(list);
    }

    /**
     * 导出物料列表
     */
    @PreAuthorize("@ss.hasPermi('mes:md:mditem:export')")
    @Log(title = "物料管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdItem mdItem)
    {
        List<MdItem> list = mdItemService.getExeportList(mdItem);
        ExcelUtil<MdItem> util = new ExcelUtil<MdItem>(MdItem.class);
        util.exportExcel(response, list, "物料产品数据");
    }

    /**
     * 下载导入模板
     * @param response
     */
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<MdItem> util = new ExcelUtil<MdItem>(MdItem.class);
        util.importTemplateExcel(response, "物料产品数据");
    }


    /**
     * 从模板导入供应商数据
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @Log(title = "物料管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('mes:md:mditem:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<MdItem> util = new ExcelUtil<MdItem>(MdItem.class);
        List<MdItem> mdItemList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = mdItemService.importItem(mdItemList, updateSupport, operName);
        return AjaxResult.success(message);
    }




    /**
     * 主键查询
     * @param itemId
     * @return
     */
    @PreAuthorize("@ss.hasPermi('mes:md:mditem:query')")
    @GetMapping(value = "/{itemId}")
    public AjaxResult getInfo(@PathVariable Long itemId){
        return AjaxResult.success(mdItemService.selectMdItemById(itemId));
    }

    /**
     * 新增
     * @param mdItem
     * @return
     */
    @PreAuthorize("@ss.hasPermi('mes:md:mditem:add')")
    @Log(title = "物料管理",businessType = BusinessType.INSERT)
    @BarcodeGen(barcodeType = UserConstants.BARCODE_TYPE_ITEM)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody MdItem mdItem){
        if(UserConstants.NOT_UNIQUE.equals(mdItemService.checkItemCodeUnique(mdItem))){
            return AjaxResult.error("新增物料"+mdItem.getItemCode()+"失败，物料编码已存在");
        }
        if(UserConstants.NOT_UNIQUE.equals(mdItemService.checkItemNameUnique(mdItem))){
            return AjaxResult.error("新增物料"+mdItem.getItemCode()+"失败，物料名称已存在");
        }

        ItemType type =iItemTypeService.selectItemTypeById(mdItem.getItemTypeId());
        if(StringUtils.isNotNull(type)){
            mdItem.setItemTypeCode(type.getItemTypeCode());
            mdItem.setItemTypeName(type.getItemTypeName());
            mdItem.setItemOrProduct(type.getItemOrProduct());
        }

        MdUnitMeasure measure = mdUnitMeasureService.selectMdUnitByCode(mdItem.getUnitOfMeasure());
        if(StringUtils.isNotNull(measure)){
            mdItem.setUnitName(measure.getMeasureName());
        }
        mdItem.setCreateBy(getUsername());
        mdItemService.insertMdItem(mdItem);
        barcodeUtil.generateBarCode(UserConstants.BARCODE_TYPE_ITEM,mdItem.getItemId(),mdItem.getItemCode(), mdItem.getItemName());
        return AjaxResult.success(mdItem.getItemId());
    }

    /**
     * 更新
     * @param mdItem
     * @return
     */
    @PreAuthorize("@ss.hasPermi('mes:md:mditem:edit')")
    @Log(title = "物料管理",businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody MdItem mdItem){
        if(UserConstants.NOT_UNIQUE.equals(mdItemService.checkItemCodeUnique(mdItem))){
            return AjaxResult.error("新增物料"+mdItem.getItemCode()+"失败，物料编码已存在");
        }
        if(UserConstants.NOT_UNIQUE.equals(mdItemService.checkItemNameUnique(mdItem))){
            return AjaxResult.error("新增物料"+mdItem.getItemCode()+"失败，物料名称已存在");
        }
        ItemType type =iItemTypeService.selectItemTypeById(mdItem.getItemTypeId());
        if(StringUtils.isNotNull(type)){
            mdItem.setItemTypeCode(type.getItemTypeCode());
            mdItem.setItemTypeName(type.getItemTypeName());
            mdItem.setItemOrProduct(type.getItemOrProduct());
        }
        if(StringUtils.isNotNull(mdItem.getSafeStockFlag())&& "N".equals(mdItem.getSafeStockFlag())){
            mdItem.setMinStock(0D);
            mdItem.setMaxStock(0D);
        }
        MdUnitMeasure measure = mdUnitMeasureService.selectMdUnitByCode(mdItem.getUnitOfMeasure());
        if(StringUtils.isNotNull(measure)){
            mdItem.setUnitName(measure.getMeasureName());
        }

        mdItem.setUpdateBy(getUsername());
        return toAjax(mdItemService.updateMdItem(mdItem));
    }

    @PreAuthorize("@ss.hasPermi('mes:md:mditem:remove')")
    @Log(title = "物料管理",businessType = BusinessType.DELETE)
    @DeleteMapping("/{itemIds}")
    public AjaxResult remove(@PathVariable Long[] itemIds){
        return toAjax(mdItemService.deleteByItemIds(itemIds));
    }
}
