package com.ktg.mes.md.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ktg.common.annotation.Excel;
import com.ktg.common.core.domain.BaseEntity;

/**
 * 产品定额物料详情对象 md_production_quota_materials
 * 
 * @author yinjinlu
 * @date 2024-12-06
 */
public class MdProductionQuotaMaterials extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 定额ID */
    @Excel(name = "定额ID")
    private Long quotaId;

    /** 定额总版本号 */
    @Excel(name = "定额总版本号")
    private Long version;

    /** 物料ID */
    private Long materialId;

    /** 物料类型，用于标识物料所属的类型分类，如型材、板材等 */
    @Excel(name = "物料类型，用于标识物料所属的类型分类，如型材、板材等")
    private String materialType;

    /** 图号1，可能是物料相关的第一个图号标识 */
    @Excel(name = "图号1，可能是物料相关的第一个图号标识")
    private String drawingNumber1;

    /** 图号2，可能是物料相关的第二个图号标识 */
    @Excel(name = "图号2，可能是物料相关的第二个图号标识")
    private String drawingNumber2;

    /** 物料唯一名称，用于唯一确定一种物料 */
    @Excel(name = "物料唯一名称，用于唯一确定一种物料")
    private String materialUniqueName;

    /** 物料名称，对物料的具体名称描述 */
    @Excel(name = "物料名称，对物料的具体名称描述")
    private String materialName;

    /** 规格特征，描述物料的规格相关特性 */
    @Excel(name = "规格特征，描述物料的规格相关特性")
    private String specificationFeatures;

    /** 单台用量，单个产品所使用该物料的数量 */
    @Excel(name = "单台用量，单个产品所使用该物料的数量")
    private String singleQuantity;

    /** 单位，物料数量的计量单元 */
    @Excel(name = "单位，物料数量的计量单元")
    private String unit;

    /** 单件重量，单个物料的重量 */
    @Excel(name = "单件重量，单个物料的重量")
    private BigDecimal singleWeight;

    /** 材质，物料的制作材料 */
    @Excel(name = "材质，物料的制作材料")
    private String material;

    /** 特征-订料尺寸/规格（mm），物料订料时的尺寸或规格信息（单位为毫米） */
    @Excel(name = "特征-订料尺寸/规格", readConverterExp = "m=m")
    private String featureOrderMaterialSize;

    /** 特征-订料数量，订料时的数量相关特征 */
    @Excel(name = "特征-订料数量，订料时的数量相关特征")
    private String featureOrderQuantity;

    /** 特征-单位，与订料数量相关的单位特征 */
    @Excel(name = "特征-单位，与订料数量相关的单位特征")
    private String featureUnit;

    /** 特征-单支断料，单支物料断料相关特征 */
    @Excel(name = "特征-单支断料，单支物料断料相关特征")
    private String featureSingleCut;

    /** 特征-订料（米），订料长度（单位为米）相关特征 */
    @Excel(name = "特征-订料", readConverterExp = "米=")
    private BigDecimal featureOrderMeter;

    /** 特征-断料（毫米），断料长度（单位为毫米）相关特征 */
    @Excel(name = "特征-断料", readConverterExp = "毫=米")
    private BigDecimal featureCutMeter;

    /** 特征-单台用量，可能与单台用量相关的其他特征 */
    @Excel(name = "特征-单台用量，可能与单台用量相关的其他特征")
    private String featureSingleQuantity;

    /** 表面处理要求，物料表面处理的相关要求 */
    @Excel(name = "表面处理要求，物料表面处理的相关要求")
    private String surfaceTreatmentRequirement;

    /** 定额版本，物料定额所对应的版本信息 */
    @Excel(name = "定额版本，物料定额所对应的版本信息")
    private String quotaVersion;

    /** 图纸版本，物料相关图纸的版本信息 */
    @Excel(name = "图纸版本，物料相关图纸的版本信息")
    private String drawingVersion;

    public void setQuotaId(Long quotaId) 
    {
        this.quotaId = quotaId;
    }

    public Long getQuotaId() 
    {
        return quotaId;
    }
    public void setVersion(Long version) 
    {
        this.version = version;
    }

    public Long getVersion() 
    {
        return version;
    }
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setMaterialType(String materialType) 
    {
        this.materialType = materialType;
    }

    public String getMaterialType() 
    {
        return materialType;
    }
    public void setDrawingNumber1(String drawingNumber1) 
    {
        this.drawingNumber1 = drawingNumber1;
    }

    public String getDrawingNumber1() 
    {
        return drawingNumber1;
    }
    public void setDrawingNumber2(String drawingNumber2) 
    {
        this.drawingNumber2 = drawingNumber2;
    }

    public String getDrawingNumber2() 
    {
        return drawingNumber2;
    }
    public void setMaterialUniqueName(String materialUniqueName) 
    {
        this.materialUniqueName = materialUniqueName;
    }

    public String getMaterialUniqueName() 
    {
        return materialUniqueName;
    }
    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
    }
    public void setSpecificationFeatures(String specificationFeatures) 
    {
        this.specificationFeatures = specificationFeatures;
    }

    public String getSpecificationFeatures() 
    {
        return specificationFeatures;
    }
    public void setSingleQuantity(String singleQuantity) 
    {
        this.singleQuantity = singleQuantity;
    }

    public String getSingleQuantity() 
    {
        return singleQuantity;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setSingleWeight(BigDecimal singleWeight) 
    {
        this.singleWeight = singleWeight;
    }

    public BigDecimal getSingleWeight() 
    {
        return singleWeight;
    }
    public void setMaterial(String material) 
    {
        this.material = material;
    }

    public String getMaterial() 
    {
        return material;
    }
    public void setFeatureOrderMaterialSize(String featureOrderMaterialSize) 
    {
        this.featureOrderMaterialSize = featureOrderMaterialSize;
    }

    public String getFeatureOrderMaterialSize() 
    {
        return featureOrderMaterialSize;
    }
    public void setFeatureOrderQuantity(String featureOrderQuantity) 
    {
        this.featureOrderQuantity = featureOrderQuantity;
    }

    public String getFeatureOrderQuantity() 
    {
        return featureOrderQuantity;
    }
    public void setFeatureUnit(String featureUnit) 
    {
        this.featureUnit = featureUnit;
    }

    public String getFeatureUnit() 
    {
        return featureUnit;
    }
    public void setFeatureSingleCut(String featureSingleCut) 
    {
        this.featureSingleCut = featureSingleCut;
    }

    public String getFeatureSingleCut() 
    {
        return featureSingleCut;
    }
    public void setFeatureOrderMeter(BigDecimal featureOrderMeter) 
    {
        this.featureOrderMeter = featureOrderMeter;
    }

    public BigDecimal getFeatureOrderMeter() 
    {
        return featureOrderMeter;
    }
    public void setFeatureCutMeter(BigDecimal featureCutMeter) 
    {
        this.featureCutMeter = featureCutMeter;
    }

    public BigDecimal getFeatureCutMeter() 
    {
        return featureCutMeter;
    }
    public void setFeatureSingleQuantity(String featureSingleQuantity) 
    {
        this.featureSingleQuantity = featureSingleQuantity;
    }

    public String getFeatureSingleQuantity() 
    {
        return featureSingleQuantity;
    }
    public void setSurfaceTreatmentRequirement(String surfaceTreatmentRequirement) 
    {
        this.surfaceTreatmentRequirement = surfaceTreatmentRequirement;
    }

    public String getSurfaceTreatmentRequirement() 
    {
        return surfaceTreatmentRequirement;
    }
    public void setQuotaVersion(String quotaVersion) 
    {
        this.quotaVersion = quotaVersion;
    }

    public String getQuotaVersion() 
    {
        return quotaVersion;
    }
    public void setDrawingVersion(String drawingVersion) 
    {
        this.drawingVersion = drawingVersion;
    }

    public String getDrawingVersion() 
    {
        return drawingVersion;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("quotaId", getQuotaId())
            .append("version", getVersion())
            .append("materialId", getMaterialId())
            .append("materialType", getMaterialType())
            .append("drawingNumber1", getDrawingNumber1())
            .append("drawingNumber2", getDrawingNumber2())
            .append("materialUniqueName", getMaterialUniqueName())
            .append("materialName", getMaterialName())
            .append("specificationFeatures", getSpecificationFeatures())
            .append("singleQuantity", getSingleQuantity())
            .append("unit", getUnit())
            .append("singleWeight", getSingleWeight())
            .append("material", getMaterial())
            .append("featureOrderMaterialSize", getFeatureOrderMaterialSize())
            .append("featureOrderQuantity", getFeatureOrderQuantity())
            .append("featureUnit", getFeatureUnit())
            .append("featureSingleCut", getFeatureSingleCut())
            .append("featureOrderMeter", getFeatureOrderMeter())
            .append("featureCutMeter", getFeatureCutMeter())
            .append("featureSingleQuantity", getFeatureSingleQuantity())
            .append("surfaceTreatmentRequirement", getSurfaceTreatmentRequirement())
            .append("remark", getRemark())
            .append("quotaVersion", getQuotaVersion())
            .append("drawingVersion", getDrawingVersion())
            .toString();
    }
}
