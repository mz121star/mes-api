package com.ktg.mes.wm.controller.mobile;

import cn.hutool.core.date.DateUtil;
import com.ktg.common.annotation.Log;
import com.ktg.common.constant.UserConstants;
import com.ktg.common.core.controller.BaseController;
import com.ktg.common.core.domain.AjaxResult;
import com.ktg.common.core.page.TableDataInfo;
import com.ktg.common.enums.BusinessType;
import com.ktg.common.utils.StringUtils;
import com.ktg.common.utils.poi.ExcelUtil;
import com.ktg.mes.wm.domain.WmSn;
import com.ktg.mes.wm.service.IWmSnService;
import com.ktg.mes.wm.utils.WmBarCodeUtil;
import com.ktg.system.strategy.AutoCodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Api("SN码")
@RestController
@RequestMapping("/mobile/wm/sn")
public class WmSnMobController extends BaseController {
    @Autowired
    private IWmSnService wmSnService;

    @Autowired
    private AutoCodeUtil autoCodeUtil;

    @Autowired
    private WmBarCodeUtil wmBarCodeUtil;

    /**
     * 查询SN码列表
     */
    @GetMapping("/list")
    public TableDataInfo list(WmSn wmSn)
    {
        startPage();
        List<WmSn> list = wmSnService.selectWmSnList(wmSn);
        return getDataTable(list);
    }

    /**
     * 查询SN码列表
     */
    @GetMapping("/listSn")
    public TableDataInfo listSn(WmSn wmSn)
    {
        startPage();
        List<WmSn> list = wmSnService.selectSnList(wmSn);
        return getDataTable(list);
    }

    @ApiOperation("根据生产工单和工作站查询所有SN流转记录")
    @GetMapping("/getStationList")
    public AjaxResult getStationList(WmSn sn){
        if(!StringUtils.isNotNull(sn.getWorkorderId())){
            return AjaxResult.error("请输入生产工单ID参数");
        }

        if(!StringUtils.isNotNull(sn.getWorkstationId())){
            return AjaxResult.error("请输入工作站ID参数");
        }

        List<WmSn> snList = wmSnService.getStationList(sn);
        return AjaxResult.success(snList);
    }




    /**
     * 导出SN码列表
     */
    @PreAuthorize("@ss.hasPermi('mes:wm:sn:export')")
    @Log(title = "SN码", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmSn wmSn)
    {
        List<WmSn> list = wmSnService.selectWmSnList(wmSn);
        ExcelUtil<WmSn> util = new ExcelUtil<WmSn>(WmSn.class);
        util.exportExcel(response, list, "SN码数据");
    }

    /**
     * 获取SN码详细信息
     */
    @PreAuthorize("@ss.hasPermi('mes:wm:sn:query')")
    @GetMapping(value = "/{snId}")
    public AjaxResult getInfo(@PathVariable("snId") Long snId)
    {
        return AjaxResult.success(wmSnService.selectWmSnBySnId(snId));
    }

    /**
     * 新增SN码
     */
    @PreAuthorize("@ss.hasPermi('mes:wm:sn:add')")
    @Log(title = "SN码", businessType = BusinessType.INSERT)
    @Transactional
    @PostMapping
    public AjaxResult add(@RequestBody WmSn wmSn)
    {
        Date genDate = DateUtil.date();
        wmSn.setGenDate(genDate);
        String SNCode= null;
        if(wmSn.getSnNum()>0){
            for(int i=0;i<wmSn.getSnNum();i++){
                SNCode = autoCodeUtil.genSerialCode(UserConstants.SN_CODE,wmSn.getItemCode());
                wmSn.setSnCode(SNCode);
                wmSnService.insertWmSn(wmSn);
                wmBarCodeUtil.generateBarCode(UserConstants.BARCODE_TYPE_SN,wmSn.getSnId(),wmSn.getSnCode(),"");
            }
        }
        return AjaxResult.success(wmSn);
    }

    /**
     * 修改SN码
     */
    @PreAuthorize("@ss.hasPermi('mes:wm:sn:edit')")
    @Log(title = "SN码", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmSn wmSn)
    {
        return toAjax(wmSnService.updateWmSn(wmSn));
    }

    /**
     * 删除SN码
     */
    @PreAuthorize("@ss.hasPermi('mes:wm:sn:remove')")
    @Log(title = "SN码", businessType = BusinessType.DELETE)
    @DeleteMapping("/{snIds}")
    public AjaxResult remove(@PathVariable String snIds)
    {
        return toAjax(wmSnService.deleteWmSnBySnIds(snIds));
    }
}
