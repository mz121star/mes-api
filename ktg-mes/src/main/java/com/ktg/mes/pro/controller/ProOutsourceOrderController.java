package com.ktg.mes.pro.controller;

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
import com.ktg.mes.pro.domain.ProOutsourceOrder;
import com.ktg.mes.pro.service.IProOutsourceOrderService;
import com.ktg.common.utils.poi.ExcelUtil;
import com.ktg.common.core.page.TableDataInfo;

/**
 * 外协工单Controller
 * 
 * @author yinjinlu
 * @date 2024-03-29
 */
@RestController
@RequestMapping("/pro/outsourceorder")
public class ProOutsourceOrderController extends BaseController
{
    @Autowired
    private IProOutsourceOrderService proOutsourceOrderService;

    /**
     * 查询外协工单列表
     */
    @PreAuthorize("@ss.hasPermi('pro:outsourceorder:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProOutsourceOrder proOutsourceOrder)
    {
        startPage();
        List<ProOutsourceOrder> list = proOutsourceOrderService.selectProOutsourceOrderList(proOutsourceOrder);
        return getDataTable(list);
    }

    /**
     * 导出外协工单列表
     */
    @PreAuthorize("@ss.hasPermi('pro:outsourceorder:export')")
    @Log(title = "外协工单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProOutsourceOrder proOutsourceOrder)
    {
        List<ProOutsourceOrder> list = proOutsourceOrderService.selectProOutsourceOrderList(proOutsourceOrder);
        ExcelUtil<ProOutsourceOrder> util = new ExcelUtil<ProOutsourceOrder>(ProOutsourceOrder.class);
        util.exportExcel(response, list, "外协工单数据");
    }

    /**
     * 获取外协工单详细信息
     */
    @PreAuthorize("@ss.hasPermi('pro:outsourceorder:query')")
    @GetMapping(value = "/{workorderId}")
    public AjaxResult getInfo(@PathVariable("workorderId") Long workorderId)
    {
        return AjaxResult.success(proOutsourceOrderService.selectProOutsourceOrderByWorkorderId(workorderId));
    }

    /**
     * 新增外协工单
     */
    @PreAuthorize("@ss.hasPermi('pro:outsourceorder:add')")
    @Log(title = "外协工单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProOutsourceOrder proOutsourceOrder)
    {
        return toAjax(proOutsourceOrderService.insertProOutsourceOrder(proOutsourceOrder));
    }

    /**
     * 修改外协工单
     */
    @PreAuthorize("@ss.hasPermi('pro:outsourceorder:edit')")
    @Log(title = "外协工单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProOutsourceOrder proOutsourceOrder)
    {
        return toAjax(proOutsourceOrderService.updateProOutsourceOrder(proOutsourceOrder));
    }

    /**
     * 删除外协工单
     */
    @PreAuthorize("@ss.hasPermi('pro:outsourceorder:remove')")
    @Log(title = "外协工单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{workorderIds}")
    public AjaxResult remove(@PathVariable Long[] workorderIds)
    {
        return toAjax(proOutsourceOrderService.deleteProOutsourceOrderByWorkorderIds(workorderIds));
    }
}
