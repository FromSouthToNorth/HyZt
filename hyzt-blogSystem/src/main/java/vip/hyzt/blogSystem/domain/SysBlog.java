package vip.hyzt.blogSystem.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import vip.hyzt.common.annotation.Excel;
import vip.hyzt.common.core.domain.BaseEntity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 博客对象 sys_blog
 * 
 * @author hyzt
 * @date 2020-11-12
 */
public class SysBlog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 博客id */
    private Long blogId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 博客标题 */
    @NotBlank(message = "博客标题不能为空")
    @Size(min = 0, max = 50, message = "博客标题长度不能超过50个字符")
    @Excel(name = "博客标题")
    private String blogTitle;

    /** 博客描述 */
    @NotBlank(message = "博客描述不能为空")
    @Size(min = 0, max = 260, message = "博客描述长度不能超过260个字符")
    @Excel(name = "博客描述")
    private String description;

    /** 博客内容 */
    @NotBlank(message = "博客内容不能为空")
    @Excel(name = "博客内容")
    private String blogContent;

    /** 博客首图 */
    @NotBlank(message = "博客首图不能为空")
    @Size(min = 0, max = 100, message = "博客首图长度不能超过100个字符")
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

    /** 是否开启评论功能（0表示关闭，1表示开启） */
    @Excel(name = "是否开启评论功能", readConverterExp = "0=表示关闭，1表示开启")
    private String commentFunction;

    /** 是否发布（0表示否，1表示是） */
    @Excel(name = "是否发布", readConverterExp = "0=表示否，1表示是")
    private String published;

    /** 类型id */
    @Excel(name = "类型id")
    private Long typeId;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 博客类型 */
    private SysType type;

    /** 博客标签 */
    private List<SysTag> tags;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Long getViewsNumber() {
        return viewsNumber;
    }

    public void setViewsNumber(Long viewsNumber) {
        this.viewsNumber = viewsNumber;
    }

    public Long getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Long likeNumber) {
        this.likeNumber = likeNumber;
    }

    public String getAppreciateFunction() {
        return appreciateFunction;
    }

    public void setAppreciateFunction(String appreciateFunction) {
        this.appreciateFunction = appreciateFunction;
    }

    public String getCommentFunction() {
        return commentFunction;
    }

    public void setCommentFunction(String commentFunction) {
        this.commentFunction = commentFunction;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public SysType getType() {
        return type;
    }

    public void setType(SysType type) {
        this.type = type;
    }

    public List<SysTag> getTags() {
        return tags;
    }

    public void setTags(List<SysTag> tags) {
        this.tags = tags;
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
            .append("type", getType())
            .append("tags", getTags())
            .toString();
    }
}
