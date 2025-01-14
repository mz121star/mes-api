package com.ktg.mes.md.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ktg.mes.md.domain.MdProductionQuota;
import com.ktg.mes.md.service.IMdProductionQuotaService;
import com.ktg.common.utils.poi.ExcelUtil;
import com.ktg.common.core.page.TableDataInfo;

/**
 * 产品定额Controller
 *
 * @author yinjinlu
 * @date 2024-12-06
 */
@RestController
@RequestMapping("mes/md/quota")
public class MdProductionQuotaController extends BaseController
{
    @Autowired
    private IMdProductionQuotaService mdProductionQuotaService;

    /**
     * 查询产品定额列表
     */
    @PreAuthorize("@ss.hasPermi('mes:md:quota:list')")
    @GetMapping("/list")
    public TableDataInfo list(MdProductionQuota mdProductionQuota)
    {
        startPage();
        List<MdProductionQuota> list = mdProductionQuotaService.selectMdProductionQuotaList(mdProductionQuota);
        return getDataTable(list);
    }

    /**
     * 导出产品定额列表
     */
    @PreAuthorize("@ss.hasPermi('mes:md:quota:export')")
    @Log(title = "产品定额", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdProductionQuota mdProductionQuota)
    {
        List<MdProductionQuota> list = mdProductionQuotaService.selectMdProductionQuotaList(mdProductionQuota);
        ExcelUtil<MdProductionQuota> util = new ExcelUtil<MdProductionQuota>(MdProductionQuota.class);
        util.exportExcel(response, list, "产品定额数据");
    }

    /**
     * 获取产品定额详细信息
     */
    @PreAuthorize("@ss.hasPermi('mes:md:quota:query')")
    @GetMapping(value = "/{quotaId}")
    public AjaxResult getInfo(@PathVariable("quotaId") Long quotaId)
    {
        return AjaxResult.success(mdProductionQuotaService.selectMdProductionQuotaByQuotaId(quotaId));
    }

    /**
     * 新增产品定额
     */
    @PreAuthorize("@ss.hasPermi('mes:md:quota:add')")
    @Log(title = "产品定额", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdProductionQuota mdProductionQuota)
    {
        return toAjax(mdProductionQuotaService.insertMdProductionQuota(mdProductionQuota));
    }

    /**
     * 修改产品定额
     */
    @PreAuthorize("@ss.hasPermi('mes:md:quota:edit')")
    @Log(title = "产品定额", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdProductionQuota mdProductionQuota)
    {
        return toAjax(mdProductionQuotaService.updateMdProductionQuota(mdProductionQuota));
    }

    /**
     * 删除产品定额
     */
    @PreAuthorize("@ss.hasPermi('mes:md:quota:remove')")
    @Log(title = "产品定额", businessType = BusinessType.DELETE)
    @DeleteMapping("/{quotaIds}")
    public AjaxResult remove(@PathVariable Long[] quotaIds)
    {
       return  AjaxResult.error("产品定额目前不支持删除操作！");
        //return toAjax(mdProductionQuotaService.deleteMdProductionQuotaByQuotaIds(quotaIds));
    }
}
