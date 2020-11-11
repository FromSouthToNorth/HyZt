package vip.hyzt.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import vip.hyzt.common.annotation.Excel;
import vip.hyzt.common.core.domain.BaseEntity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * 博客评论对象 sys_comment
 */
public class SysComment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 评论id */
    private Long commentId;

    /** 父评论id */
    @Excel(name = "父评论id")
    private Long parentId;

    /** 评论人名称 */
    @NotBlank(message = "评论人名称不能为空")
    @Size(min = 0, max = 30, message = "评论人名称长度不能超过30个字符")
    @Excel(name = "评论人名称")
    private String nickname;

    /** 评论人邮箱 */
    @NotBlank(message = "评论人邮箱不能为空")
    @Size(min = 0, max = 30, message = "评论人邮箱长度不能超过20个字符")
    @Excel(name = "评论人邮箱")
    private String email;

    /** 评论内容 */
    @NotBlank(message = "评论内容不能为空")
    @Excel(name = "评论内容")
    private String content;

    /** 评论人头像 */
    @Excel(name = "评论人头像")
    private String avatar;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 子评论 */
    private List<SysComment> children = new ArrayList<>();

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public List<SysComment> getChildren() {
        return children;
    }

    public void setChildren(List<SysComment> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("commentId", getCommentId())
            .append("parentId", getParentId())
            .append("nickname", getNickname())
            .append("email", getEmail())
            .append("content", getContent())
            .append("avatar", getAvatar())
            .append("delFlag", getDelFlag())
            .append("createTime", getCreateTime())
            .toString();
    }
}
