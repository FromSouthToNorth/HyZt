package vip.hyzt.blogSystem.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.hyzt.blogSystem.mapper.SysBlogMapper;
import vip.hyzt.blogSystem.domain.SysBlog;
import vip.hyzt.blogSystem.service.ISysBlogService;
import vip.hyzt.common.annotation.DataScope;

/**
 * 博客Service业务层处理
 * 
 * @author hyzt
 * @date 2020-11-12
 */
@Service
public class SysBlogServiceImpl implements ISysBlogService 
{
    @Autowired
    private SysBlogMapper blogMapper;

    /**
     * 查询博客
     * 
     * @param blogId 博客ID
     * @return 博客
     */
    @Override
    public SysBlog selectBlogById(Long blogId)
    {
        return blogMapper.selectSysBlogById(blogId);
    }

    /**
     * 根据条件分页查询博客列表
     * 
     * @param blog 博客
     * @return 博客
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<SysBlog> selectBlogList(SysBlog blog)
    {
        return blogMapper.selectSysBlogList(blog);
    }

    /**
     * 新增博客
     * 
     * @param blog 博客
     * @return 结果
     */
    @Override
    public int insertBlog(SysBlog blog)
    {
        return blogMapper.insertSysBlog(blog);
    }

    /**
     * 修改博客
     * 
     * @param blog 博客
     * @return 结果
     */
    @Override
    public int updateBlog(SysBlog blog)
    {
        return blogMapper.updateSysBlog(blog);
    }

    /**
     * 批量删除博客
     * 
     * @param blogIds 需要删除的博客ID
     * @return 结果
     */
    @Override
    public int deleteBlogByIds(Long[] blogIds)
    {
        return blogMapper.deleteSysBlogByIds(blogIds);
    }

    /**
     * 删除博客信息
     * 
     * @param blogId 博客ID
     * @return 结果
     */
    @Override
    public int deleteBlogById(Long blogId)
    {
        return blogMapper.deleteSysBlogById(blogId);
    }

    /**
     * 校验博客标题是否唯一
     *
     * @param blogTitle 博客标题
     * @return 结果
     */
    @Override
    public String checkTitleUnique(String blogTitle)
    {
        return null;
    }
}
