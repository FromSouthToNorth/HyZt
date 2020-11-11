package vip.hyzt.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import vip.hyzt.common.annotation.Excel;
import vip.hyzt.common.core.domain.BaseEntity;

/**
 * 博客对象 sys_blog
 * 
 * @author hyzt
 */
public class SysBlog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 博客id */
    private Long blogId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 博客标题 */
    @Excel(name = "博客标题")
    private String blogTitle;

    /** 博客描述 */
    @Excel(name = "博客描述")
    private String description;

    /** 博客内容 */
    @Excel(name = "博客内容")
    private String blogContent;

    /** 博客首图 */
    @Excel(name = "博客首图")
    private String firstPicture;

    /** 博客标记（0表示原创，1表示转载） */
    @Excel(name = "博客标记", readConverterExp = "0=表示原创，1表示转载")
    private String flag;

    /** 博客浏览数 */
    @Excel(name = "博客浏览数")
    private Long viewsNumber;

    /** 博客点赞数 */
    @Excel(name = "博客点赞数")
    private Long likeNumber;

    /** 是否开启赞赏（0表示关闭，1表示开启） */
    @Excel(name = "是否开启赞赏", readConverterExp = "0=表示关闭，1表示开启")
    private String appreciateFunction;

    /** 是否开启评论功能（0表示关闭，1表示关闭） */
    @Excel(name = "是否开启评论功能", readConverterExp = "0=表示关闭，1表示关闭")
    private String commentFunction;

    /** 是否发布（0表示否，1表示是） */
    @Excel(name = "是否发布", readConverterExp = "0=表示否，1表示是")
    private String published;

    /** 类型id */
    @Excel(name = "类型id")
    private Long typeId;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setBlogId(Long blogId) 
    {
        this.blogId = blogId;
    }

    public Long getBlogId() 
    {
        return blogId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setBlogTitle(String blogTitle) 
    {
        this.blogTitle = blogTitle;
    }

    public String getBlogTitle() 
    {
        return blogTitle;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setBlogContent(String blogContent) 
    {
        this.blogContent = blogContent;
    }

    public String getBlogContent() 
    {
        return blogContent;
    }
    public void setFirstPicture(String firstPicture) 
    {
        this.firstPicture = firstPicture;
    }

    public String getFirstPicture() 
    {
        return firstPicture;
    }
    public void setFlag(String flag) 
    {
        this.flag = flag;
    }

    public String getFlag() 
    {
        return flag;
    }
    public void setViewsNumber(Long viewsNumber) 
    {
        this.viewsNumber = viewsNumber;
    }

    public Long getViewsNumber() 
    {
        return viewsNumber;
    }
    public void setLikeNumber(Long likeNumber) 
    {
        this.likeNumber = likeNumber;
    }

    public Long getLikeNumber() 
    {
        return likeNumber;
    }
    public void setAppreciateFunction(String appreciateFunction) 
    {
        this.appreciateFunction = appreciateFunction;
    }

    public String getAppreciateFunction() 
    {
        return appreciateFunction;
    }
    public void setCommentFunction(String commentFunction) 
    {
        this.commentFunction = commentFunction;
    }

    public String getCommentFunction() 
    {
        return commentFunction;
    }
    public void setPublished(String published) 
    {
        this.published = published;
    }

    public String getPublished() 
    {
        return published;
    }
    public void setTypeId(Long typeId) 
    {
        this.typeId = typeId;
    }

    public Long getTypeId() 
    {
        return typeId;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("blogId", getBlogId())
            .append("userId", getUserId())
            .append("blogTitle", getBlogTitle())
            .append("description", getDescription())
            .append("blogContent", getBlogContent())
            .append("firstPicture", getFirstPicture())
            .append("flag", getFlag())
            .append("viewsNumber", getViewsNumber())
            .append("likeNumber", getLikeNumber())
            .append("appreciateFunction", getAppreciateFunction())
            .append("commentFunction", getCommentFunction())
            .append("published", getPublished())
            .append("typeId", getTypeId())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
