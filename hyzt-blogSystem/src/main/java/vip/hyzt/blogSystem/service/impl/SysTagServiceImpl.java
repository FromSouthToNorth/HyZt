package vip.hyzt.blogSystem.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.hyzt.blogSystem.mapper.SysTagMapper;
import vip.hyzt.blogSystem.domain.SysTag;
import vip.hyzt.blogSystem.service.ISysTagService;

/**
 * 博客标签Service业务层处理
 * 
 * @author hyzt
 * @date 2020-11-12
 */
@Service
public class SysTagServiceImpl implements ISysTagService {

    @Autowired
    private SysTagMapper tagMapper;

    /**
     * 查询博客标签
     * 
     * @param tagId 博客标签ID
     * @return 博客标签
     */
    @Override
    public SysTag selectTagById(Long tagId)
    {
        return tagMapper.selectSysTagById(tagId);
    }

    /**
     * 查询博客标签列表
     * 
     * @param tag 博客标签
     * @return 博客标签
     */
    @Override
    public List<SysTag> selectTagList(SysTag tag)
    {
        return tagMapper.selectSysTagList(tag);
    }

    /**
     * 新增博客标签
     * 
     * @param tag 博客标签
     * @return 结果
     */
    @Override
    public int insertTag(SysTag tag)
    {
        return tagMapper.insertSysTag(tag);
    }

    /**
     * 修改博客标签
     * 
     * @param tag 博客标签
     * @return 结果
     */
    @Override
    public int updateTag(SysTag tag)
    {
        return tagMapper.updateSysTag(tag);
    }

    /**
     * 批量删除博客标签
     * 
     * @param tagIds 需要删除的博客标签ID
     * @return 结果
     */
    @Override
    public int deleteTagByIds(Long[] tagIds)
    {
        return tagMapper.deleteSysTagByIds(tagIds);
    }

    /**
     * 删除博客标签信息
     * 
     * @param tagId 博客标签ID
     * @return 结果
     */
    @Override
    public int deleteTagById(Long tagId)
    {
        return tagMapper.deleteSysTagById(tagId);
    }

    /**
     * 校验标签名称是否唯一
     *
     * @param tag 标签信息
     * @return 结果
     */
    @Override
    public String checkTagNameUnique(SysTag tag)
    {
        return null;
    }

    /**
     * 查询标签是否存在博客
     *
     * @param tagId 标签ID
     * @return 结果
     */
    @Override
    public boolean checkTagExistBlog(Long tagId)
    {
        return false;
    }
}
