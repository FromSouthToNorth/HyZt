package vip.hyzt.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import vip.hyzt.common.core.domain.BaseEntity;

/**
 * 博客与标签关联对象 sys_blog_tag
 */
public class SysBlogTag extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 博客id */
    private Long blogId;

    /** 标签id */
    private Long tagId;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("blogId", getBlogId())
            .append("tagId", getTagId())
            .toString();
    }
}
