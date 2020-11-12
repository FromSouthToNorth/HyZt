package vip.hyzt.blogSystem.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 博客与标签关联对象 sys_blog_tag
 * 
 * @author hyzt
 * @date 2020-11-12
 */
public class SysBlogTag {

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
