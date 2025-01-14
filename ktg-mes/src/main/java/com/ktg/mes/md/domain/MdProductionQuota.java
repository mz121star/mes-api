package com.ktg.mes.md.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ktg.common.annotation.Excel;
import com.ktg.common.core.domain.BaseEntity;

/**
 * 产品定额对象 md_production_quota
 *
 * @author yinjinlu
 * @date 2024-12-06
 */
public class MdProductionQuota extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 定额ID */
    private Long quotaId;

    /** 定额名称 */
    @Excel(name = "定额名称")
    private String quotaName;

    /** 定额编号 */
    @Excel(name = "定额编号")
    private String quotaNumber;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNumber;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 项目代码 */
    @Excel(name = "项目代码")
    private String projectCode;

    /** 项目编号 */
    @Excel(name = "项目编号")
    private String projectNumber;

    /** 现版冻结日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "现版冻结日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date currentVersionFreezeDate;

    /** 图纸接收日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "图纸接收日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date drawingReceiptDate;

    /** 文件编号 */
    @Excel(name = "文件编号")
    private String fileNumber;

    /** 定额编制人员 */
    @Excel(name = "定额编制人员")
    private String quotaPreparer;

    /** 编制日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "编制日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date preparationDate;

    /** 最后修改 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后修改", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastModification;

    /** 产品定额物料详情信息 */
    private List<MdProductionQuotaMaterials> mdProductionQuotaMaterialsList;

    private List<MdProductionQuotaFiles> mdProductionQuotaFilesList;

    public void setQuotaId(Long quotaId)
    {
        this.quotaId = quotaId;
    }

    public Long getQuotaId()
    {
        return quotaId;
    }
    public void setQuotaName(String quotaName)
    {
        this.quotaName = quotaName;
    }

    public String getQuotaName()
    {
        return quotaName;
    }
    public void setQuotaNumber(String quotaNumber)
    {
        this.quotaNumber = quotaNumber;
    }

    public String getQuotaNumber()
    {
        return quotaNumber;
    }
    public void setOrderNumber(String orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber()
    {
        return orderNumber;
    }
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getProjectName()
    {
        return projectName;
    }
    public void setProjectCode(String projectCode)
    {
        this.projectCode = projectCode;
    }

    public String getProjectCode()
    {
        return projectCode;
    }
    public void setProjectNumber(String projectNumber)
    {
        this.projectNumber = projectNumber;
    }

    public String getProjectNumber()
    {
        return projectNumber;
    }
    public void setCurrentVersionFreezeDate(Date currentVersionFreezeDate)
    {
        this.currentVersionFreezeDate = currentVersionFreezeDate;
    }

    public Date getCurrentVersionFreezeDate()
    {
        return currentVersionFreezeDate;
    }
    public void setDrawingReceiptDate(Date drawingReceiptDate)
    {
        this.drawingReceiptDate = drawingReceiptDate;
    }

    public Date getDrawingReceiptDate()
    {
        return drawingReceiptDate;
    }
    public void setFileNumber(String fileNumber)
    {
        this.fileNumber = fileNumber;
    }

    public String getFileNumber()
    {
        return fileNumber;
    }
    public void setQuotaPreparer(String quotaPreparer)
    {
        this.quotaPreparer = quotaPreparer;
    }

    public String getQuotaPreparer()
    {
        return quotaPreparer;
    }
    public void setPreparationDate(Date preparationDate)
    {
        this.preparationDate = preparationDate;
    }

    public Date getPreparationDate()
    {
        return preparationDate;
    }
    public void setLastModification(Date lastModification)
    {
        this.lastModification = lastModification;
    }

    public Date getLastModification()
    {
        return lastModification;
    }

    public List<MdProductionQuotaMaterials> getMdProductionQuotaMaterialsList()
    {
        return mdProductionQuotaMaterialsList;
    }



    public void setMdProductionQuotaMaterialsList(List<MdProductionQuotaMaterials> mdProductionQuotaMaterialsList)
    {
        this.mdProductionQuotaMaterialsList = mdProductionQuotaMaterialsList;
    }

    public List<MdProductionQuotaFiles> getMdProductionQuotaFilesList()
    {
        return  mdProductionQuotaFilesList;
    }

    public void setMdProductionQuotaFilesList(List<MdProductionQuotaFiles> mdProductionQuotaFilesList)
    {
        this.mdProductionQuotaFilesList =mdProductionQuotaFilesList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("quotaId", getQuotaId())
                .append("quotaName", getQuotaName())
                .append("quotaNumber", getQuotaNumber())
                .append("orderNumber", getOrderNumber())
                .append("projectName", getProjectName())
                .append("projectCode", getProjectCode())
                .append("projectNumber", getProjectNumber())
                .append("currentVersionFreezeDate", getCurrentVersionFreezeDate())
                .append("drawingReceiptDate", getDrawingReceiptDate())
                .append("fileNumber", getFileNumber())
                .append("quotaPreparer", getQuotaPreparer())
                .append("preparationDate", getPreparationDate())
                .append("lastModification", getLastModification())
                .append("mdProductionQuotaMaterialsList", getMdProductionQuotaMaterialsList())
                .append("mdProductionQuotaFilesList",getMdProductionQuotaFilesList())
                .toString();
    }
}
