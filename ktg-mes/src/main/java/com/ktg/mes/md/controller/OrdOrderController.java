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
import com.ktg.mes.md.domain.OrdOrder;
import com.ktg.mes.md.service.IOrdOrderService;
import com.ktg.common.utils.poi.ExcelUtil;
import com.ktg.common.core.page.TableDataInfo;

/**
 * 订单Controller
 * 
 * @author yinjinlu
 * @date 2024-11-24
 */
@RestController
@RequestMapping("/md/order")
public class OrdOrderController extends BaseController
{
    @Autowired
    private IOrdOrderService ordOrderService;

    /**
     * 查询订单列表
     */
    @PreAuthorize("@ss.hasPermi('md:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(OrdOrder ordOrder)
    {
        startPage();
        List<OrdOrder> list = ordOrderService.selectOrdOrderList(ordOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单列表
     */
    @PreAuthorize("@ss.hasPermi('md:order:export')")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OrdOrder ordOrder)
    {
        List<OrdOrder> list = ordOrderService.selectOrdOrderList(ordOrder);
        ExcelUtil<OrdOrder> util = new ExcelUtil<OrdOrder>(OrdOrder.class);
        util.exportExcel(response, list, "订单数据");
    }

    /**
     * 获取订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('md:order:query')")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId)
    {
        return AjaxResult.success(ordOrderService.selectOrdOrderByOrderId(orderId));
    }

    /**
     * 新增订单
     */
    @PreAuthorize("@ss.hasPermi('md:order:add')")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrdOrder ordOrder)
    {
        return toAjax(ordOrderService.insertOrdOrder(ordOrder));
    }

    /**
     * 修改订单
     */
    @PreAuthorize("@ss.hasPermi('md:order:edit')")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrdOrder ordOrder)
    {
        return toAjax(ordOrderService.updateOrdOrder(ordOrder));
    }

    /**
     * 删除订单
     */
    @PreAuthorize("@ss.hasPermi('md:order:remove')")
    @Log(title = "订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds)
    {
        return toAjax(ordOrderService.deleteOrdOrderByOrderIds(orderIds));
    }
}
