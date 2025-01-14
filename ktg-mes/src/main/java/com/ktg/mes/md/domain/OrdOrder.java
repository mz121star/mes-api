package com.ktg.mes.md.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ktg.common.annotation.Excel;
import com.ktg.common.core.domain.BaseEntity;

/**
 * 订单对象 ord_order
 *
 * @author yinjinlu
 * @date 2024-11-26
 */
public class OrdOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long orderId;

    /** 客户图号 */
    @Excel(name = "客户图号")
    private String graphId;

    /** 交付工厂 */
    @Excel(name = "交付工厂")
    private String deliveryFactory;

    /** 客户物料编码 */
    @Excel(name = "客户物料编码")
    private String customerMaterialCode;

    /** 产品族 */
    @Excel(name = "产品族")
    private String productFamily;

    /** 交付数量/批次 */
    @Excel(name = "交付数量/批次")
    private String deliveryQuantityBatch;

    /** 计划/实际到货点 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划/实际到货点", width = 30, dateFormat = "yyyy-MM-dd")
    private Date plannedActualArrivalPoint;

    /** 是否已到货 */
    @Excel(name = "是否已到货")
    private Integer arrived;

    /** 计划/实际发货点 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划/实际发货点", width = 30, dateFormat = "yyyy-MM-dd")
    private Date plannedActualDeparturePoint;

    /** 是否已发货 */
    @Excel(name = "是否已发货")
    private Integer shipped;

    /** 是否有配件 */
    @Excel(name = "是否有配件")
    private Integer hasAccessories;

    /** 采购订单号码 */
    @Excel(name = "采购订单号码")
    private String purchaseOrderNumber;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 订单状态 生产 未生产等准备中PREPARING备料中：PREPARING_MATERIALS待生产：TO_BE_PRODUCED生产中：IN_PRODUCTION已完成COMPLETED已发货：SHIPPED已到货：ARRIVED */
    @Excel(name = "订单状态 生产 未生产等准备中PREPARING备料中：PREPARING_MATERIALS待生产：TO_BE_PRODUCED生产中：IN_PRODUCTION已完成COMPLETED已发货：SHIPPED已到货：ARRIVED")
    private String status;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 产品编号 */
    @Excel(name = "产品编号")
    private String productCode;

    /** 产品ID */
    @Excel(name = "产品ID")
    private Long productId;

    /** 客户ID */
    @Excel(name = "客户ID")
    private Long clientId;

    /** 客户编码 */
    @Excel(name = "客户编码")
    private String clientCode;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String clientName;

    /** 订单类型 */
    @Excel(name = "订单类型")
    private String orderType;

    /** 订单数量 */
    @Excel(name = "订单数量")
    private Long orderNum;

    /** 通知时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "通知时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date noticeDate;

    /** 订单需求时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "订单需求时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date requiredDate;

    /** 内部订单号 */
    @Excel(name = "内部订单号")
    private String mainCode;

    /** 定额发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "定额发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date quotaReleaseDate;

    /** 复合图纸发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "复合图纸发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date compositeDrawingDate;

    /** 粘接图纸发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "粘接图纸发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bondingDrawingDate;

    /** 定额id */
    @Excel(name = "定额id")
    private Long quotaId;

    /** 定额名称 */
    @Excel(name = "定额名称")
    private String quotaName;

    /** 定额编号 */
    @Excel(name = "定额编号")
    private String quotaNumber;

    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public Long getOrderId()
    {
        return orderId;
    }
    public void setGraphId(String graphId)
    {
        this.graphId = graphId;
    }

    public String getGraphId()
    {
        return graphId;
    }
    public void setDeliveryFactory(String deliveryFactory)
    {
        this.deliveryFactory = deliveryFactory;
    }

    public String getDeliveryFactory()
    {
        return deliveryFactory;
    }
    public void setCustomerMaterialCode(String customerMaterialCode)
    {
        this.customerMaterialCode = customerMaterialCode;
    }

    public String getCustomerMaterialCode()
    {
        return customerMaterialCode;
    }
    public void setProductFamily(String productFamily)
    {
        this.productFamily = productFamily;
    }

    public String getProductFamily()
    {
        return productFamily;
    }
    public void setDeliveryQuantityBatch(String deliveryQuantityBatch)
    {
        this.deliveryQuantityBatch = deliveryQuantityBatch;
    }

    public String getDeliveryQuantityBatch()
    {
        return deliveryQuantityBatch;
    }
    public void setPlannedActualArrivalPoint(Date plannedActualArrivalPoint)
    {
        this.plannedActualArrivalPoint = plannedActualArrivalPoint;
    }

    public Date getPlannedActualArrivalPoint()
    {
        return plannedActualArrivalPoint;
    }
    public void setArrived(Integer arrived)
    {
        this.arrived = arrived;
    }

    public Integer getArrived()
    {
        return arrived;
    }
    public void setPlannedActualDeparturePoint(Date plannedActualDeparturePoint)
    {
        this.plannedActualDeparturePoint = plannedActualDeparturePoint;
    }

    public Date getPlannedActualDeparturePoint()
    {
        return plannedActualDeparturePoint;
    }
    public void setShipped(Integer shipped)
    {
        this.shipped = shipped;
    }

    public Integer getShipped()
    {
        return shipped;
    }
    public void setHasAccessories(Integer hasAccessories)
    {
        this.hasAccessories = hasAccessories;
    }

    public Integer getHasAccessories()
    {
        return hasAccessories;
    }
    public void setPurchaseOrderNumber(String purchaseOrderNumber)
    {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getPurchaseOrderNumber()
    {
        return purchaseOrderNumber;
    }
    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public String getRemarks()
    {
        return remarks;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getProductName()
    {
        return productName;
    }
    public void setProductCode(String productCode)
    {
        this.productCode = productCode;
    }

    public String getProductCode()
    {
        return productCode;
    }
    public void setProductId(Long productId)
    {
        this.productId = productId;
    }

    public Long getProductId()
    {
        return productId;
    }
    public void setClientId(Long clientId)
    {
        this.clientId = clientId;
    }

    public Long getClientId()
    {
        return clientId;
    }
    public void setClientCode(String clientCode)
    {
        this.clientCode = clientCode;
    }

    public String getClientCode()
    {
        return clientCode;
    }
    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }

    public String getClientName()
    {
        return clientName;
    }
    public void setOrderType(String orderType)
    {
        this.orderType = orderType;
    }

    public String getOrderType()
    {
        return orderType;
    }
    public void setOrderNum(Long orderNum)
    {
        this.orderNum = orderNum;
    }

    public Long getOrderNum()
    {
        return orderNum;
    }
    public void setNoticeDate(Date noticeDate)
    {
        this.noticeDate = noticeDate;
    }

    public Date getNoticeDate()
    {
        return noticeDate;
    }
    public void setRequiredDate(Date requiredDate)
    {
        this.requiredDate = requiredDate;
    }

    public Date getRequiredDate()
    {
        return requiredDate;
    }
    public void setMainCode(String mainCode)
    {
        this.mainCode = mainCode;
    }

    public String getMainCode()
    {
        return mainCode;
    }
    public void setQuotaReleaseDate(Date quotaReleaseDate)
    {
        this.quotaReleaseDate = quotaReleaseDate;
    }

    public Date getQuotaReleaseDate()
    {
        return quotaReleaseDate;
    }
    public void setCompositeDrawingDate(Date compositeDrawingDate)
    {
        this.compositeDrawingDate = compositeDrawingDate;
    }

    public Date getCompositeDrawingDate()
    {
        return compositeDrawingDate;
    }
    public void setBondingDrawingDate(Date bondingDrawingDate)
    {
        this.bondingDrawingDate = bondingDrawingDate;
    }

    public Date getBondingDrawingDate()
    {
        return bondingDrawingDate;
    }


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
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("orderId", getOrderId())
                .append("graphId", getGraphId())
                .append("deliveryFactory", getDeliveryFactory())
                .append("customerMaterialCode", getCustomerMaterialCode())
                .append("productFamily", getProductFamily())
                .append("deliveryQuantityBatch", getDeliveryQuantityBatch())
                .append("plannedActualArrivalPoint", getPlannedActualArrivalPoint())
                .append("arrived", getArrived())
                .append("plannedActualDeparturePoint", getPlannedActualDeparturePoint())
                .append("shipped", getShipped())
                .append("hasAccessories", getHasAccessories())
                .append("purchaseOrderNumber", getPurchaseOrderNumber())
                .append("remarks", getRemarks())
                .append("status", getStatus())
                .append("productName", getProductName())
                .append("productCode", getProductCode())
                .append("productId", getProductId())
                .append("clientId", getClientId())
                .append("clientCode", getClientCode())
                .append("clientName", getClientName())
                .append("orderType", getOrderType())
                .append("orderNum", getOrderNum())
                .append("noticeDate", getNoticeDate())
                .append("requiredDate", getRequiredDate())
                .append("mainCode", getMainCode())
                .append("quotaReleaseDate", getQuotaReleaseDate())
                .append("compositeDrawingDate", getCompositeDrawingDate())
                .append("bondingDrawingDate", getBondingDrawingDate())
                .append("quotaId", getQuotaId())
                .append("quotaName", getQuotaName())
                .append("quotaNumber", getQuotaNumber())
                .toString();
    }
}
