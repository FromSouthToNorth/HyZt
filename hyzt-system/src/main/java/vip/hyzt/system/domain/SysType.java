package vip.hyzt.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import vip.hyzt.common.annotation.Excel;
import vip.hyzt.common.core.domain.BaseEntity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 博客类型联对象 sys_type
 */
public class SysType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 类型id */
    private Long typeId;

    /** 类型名称 */
    @NotBlank(message = "类型名称")
    @Size(min = 0, max = 30, message = "类型名称长度不能超过30个字符")
    @Excel(name = "类型名称")
    private String name;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("typeId", getTypeId())
            .append("name", getName())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
