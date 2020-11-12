package vip.hyzt.blogSystem.mapper;

import java.util.List;
import vip.hyzt.blogSystem.domain.SysComment;

/**
 * 博客评论Mapper接口
 * 
 * @author hyzt
 * @date 2020-11-12
 */
public interface SysCommentMapper 
{
    /**
     * 查询博客评论
     * 
     * @param commentId 博客评论ID
     * @return 博客评论
     */
    public SysComment selectSysCommentById(Long commentId);

    /**
     * 查询博客评论列表
     * 
     * @param sysComment 博客评论
     * @return 博客评论集合
     */
    public List<SysComment> selectSysCommentList(SysComment sysComment);

    /**
     * 新增博客评论
     * 
     * @param sysComment 博客评论
     * @return 结果
     */
    public int insertSysComment(SysComment sysComment);

    /**
     * 修改博客评论
     * 
     * @param sysComment 博客评论
     * @return 结果
     */
    public int updateSysComment(SysComment sysComment);

    /**
     * 删除博客评论
     * 
     * @param commentId 博客评论ID
     * @return 结果
     */
    public int deleteSysCommentById(Long commentId);

    /**
     * 批量删除博客评论
     * 
     * @param commentIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysCommentByIds(Long[] commentIds);
}
