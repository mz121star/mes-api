package com.ktg.mes.md.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ktg.common.annotation.Excel;
import com.ktg.common.core.domain.BaseEntity;

/**
 * 产品定额原始文件对象 md_production_quota_files
 *
 * @author yinjinlu
 * @date 2024-12-14
 */
public class MdProductionQuotaFiles extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**  */
    private Long fileId;

    /**  */
    @Excel(name = "")
    private Long quotaId;

    /** $column.columnComment */
    @Excel(name = "")
    private String quotaName;

    /**  */
    @Excel(name = "")
    private String filePath;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date uploadDate;

    /**  */
    @Excel(name = "")
    private String versionNumber;

    /** $column.columnComment */
    @Excel(name = "")
    private String description;

    /** $column.columnComment */
    @Excel(name = "")
    private Long ordernum;

    /**  */
    // 新增软删除字段isDelete，类型为布尔型，默认值为false表示未删除
    @Excel(name = "")
    private int  isDelete;

    @Excel(name = "数据是否处理入库")
    private Integer isProcessed;

    @Excel(name = "是否激活")
    private int  isActivated;

    /** 文件处理的高级设置 */
    @Excel(name = "文件处理的高级设置")
    private String fileAdvSetting;


    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setQuotaId(Long quotaId) {
        this.quotaId = quotaId;
    }

    public Long getQuotaId() {
        return quotaId;
    }

    public void setQuotaName(String quotaName) {
        this.quotaName = quotaName;
    }

    public String getQuotaName() {
        return quotaName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setOrdernum(Long ordernum) {
        this.ordernum = ordernum;
    }

    public Long getOrdernum() {
        return ordernum;
    }

    // 添加isDelete的getter方法
    public int isDelete() {
        return isDelete;
    }

    // 添加isDelete的setter方法
    public void setDelete(int delete) {
        isDelete = delete;
    }

    public int getIsActivated(){
        return isActivated;
    }

    public  void  setIsActivated(int activated){
        isActivated=activated;
    }
    public void setIsProcessed(Integer isProcessed)
    {
        this.isProcessed = isProcessed;
    }

    public Integer getIsProcessed()
    {
        return isProcessed;
    }
    public void setFileAdvSetting(String fileAdvSetting)
    {
        this.fileAdvSetting = fileAdvSetting;
    }

    public String getFileAdvSetting()
    {
        return fileAdvSetting;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("fileId", getFileId())
                .append("quotaId", getQuotaId())
                .append("quotaName", getQuotaName())
                .append("filePath", getFilePath())
                .append("uploadDate", getUploadDate())
                .append("versionNumber", getVersionNumber())
                .append("description", getDescription())
                .append("ordernum", getOrdernum())
                .append("isProcessed", getIsProcessed())
                .append("isActivated",getIsActivated())
                .append("fileAdvSetting", getFileAdvSetting())
                .append("isDelete", isDelete) // 在toString方法中添加对isDelete字段的输出

                .toString();
    }
}