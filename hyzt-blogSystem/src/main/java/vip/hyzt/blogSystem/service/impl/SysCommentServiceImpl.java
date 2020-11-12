package vip.hyzt.blogSystem.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.hyzt.blogSystem.mapper.SysCommentMapper;
import vip.hyzt.blogSystem.domain.SysComment;
import vip.hyzt.blogSystem.service.ISysCommentService;

/**
 * 博客评论Service业务层处理
 * 
 * @author hyzt
 * @date 2020-11-12
 */
@Service
public class SysCommentServiceImpl implements ISysCommentService 
{
    @Autowired
    private SysCommentMapper sysCommentMapper;

    /**
     * 查询博客评论
     * 
     * @param commentId 博客评论ID
     * @return 博客评论
     */
    @Override
    public SysComment selectSysCommentById(Long commentId)
    {
        return sysCommentMapper.selectSysCommentById(commentId);
    }

    /**
     * 查询博客评论列表
     * 
     * @param sysComment 博客评论
     * @return 博客评论
     */
    @Override
    public List<SysComment> selectSysCommentList(SysComment sysComment)
    {
        return sysCommentMapper.selectSysCommentList(sysComment);
    }

    /**
     * 新增博客评论
     * 
     * @param sysComment 博客评论
     * @return 结果
     */
    @Override
    public int insertSysComment(SysComment sysComment)
    {
        return sysCommentMapper.insertSysComment(sysComment);
    }

    /**
     * 修改博客评论
     * 
     * @param sysComment 博客评论
     * @return 结果
     */
    @Override
    public int updateSysComment(SysComment sysComment)
    {
        return sysCommentMapper.updateSysComment(sysComment);
    }

    /**
     * 批量删除博客评论
     * 
     * @param commentIds 需要删除的博客评论ID
     * @return 结果
     */
    @Override
    public int deleteSysCommentByIds(Long[] commentIds)
    {
        return sysCommentMapper.deleteSysCommentByIds(commentIds);
    }

    /**
     * 删除博客评论信息
     * 
     * @param commentId 博客评论ID
     * @return 结果
     */
    @Override
    public int deleteSysCommentById(Long commentId)
    {
        return sysCommentMapper.deleteSysCommentById(commentId);
    }
}
