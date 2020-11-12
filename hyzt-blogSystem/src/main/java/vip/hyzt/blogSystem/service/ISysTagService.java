package vip.hyzt.blogSystem.service;

import java.util.List;
import vip.hyzt.blogSystem.domain.SysTag;

/**
 * 博客标签Service接口
 * 
 * @author hyzt
 * @date 2020-11-12
 */
public interface ISysTagService 
{
    /**
     * 查询博客标签
     * 
     * @param tagId 博客标签ID
     * @return 博客标签
     */
    public SysTag selectTagById(Long tagId);

    /**
     * 查询博客标签列表
     * 
     * @param tag 博客标签
     * @return 博客标签集合
     */
    public List<SysTag> selectTagList(SysTag tag);

    /**
     * 新增博客标签
     * 
     * @param tag 博客标签
     * @return 结果
     */
    public int insertTag(SysTag tag);

    /**
     * 修改博客标签
     * 
     * @param tag 博客标签
     * @return 结果
     */
    public int updateTag(SysTag tag);

    /**
     * 批量删除博客标签
     * 
     * @param tagIds 需要删除的博客标签ID
     * @return 结果
     */
    public int deleteTagByIds(Long[] tagIds);

    /**
     * 删除博客标签信息
     * 
     * @param tagId 博客标签ID
     * @return 结果
     */
    public int deleteTagById(Long tagId);

    /**
     * 校验标签名称是否唯一
     *
     * @param tag 标签信息
     * @return 结果
     */
    public String checkTagNameUnique(SysTag tag);

    /**
     * 查询标签是否存在博客
     *
     * @param tagId 标签ID
     * @return 结果
     */
    public boolean checkTagExistBlog(Long tagId);
}
