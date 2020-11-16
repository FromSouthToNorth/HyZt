package vip.hyzt.blogSystem.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.hyzt.blogSystem.domain.SysBlogTag;
import vip.hyzt.blogSystem.mapper.SysBlogMapper;
import vip.hyzt.blogSystem.domain.SysBlog;
import vip.hyzt.blogSystem.mapper.SysBlogTagMapper;
import vip.hyzt.blogSystem.service.ISysBlogService;
import vip.hyzt.common.annotation.DataScope;
import vip.hyzt.common.constant.UserConstants;
import vip.hyzt.common.utils.StringUtils;

/**
 * 博客Service业务层处理
 * 
 * @author hyzt
 * @date 2020-11-12
 */
@Service
public class SysBlogServiceImpl implements ISysBlogService {

    @Autowired
    private SysBlogMapper blogMapper;

    @Autowired
    private SysBlogTagMapper blogTagMapper;

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
     * 新增保存博客信息
     * 
     * @param blog 博客信息
     * @return 结果
     */
    @Override
    public int insertBlog(SysBlog blog)
    {
        int rows = blogMapper.insertSysBlog(blog);
        // 新增博客标签关联
        insertBlogTag(blog);
        return rows;
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
     * @param blog 博客信息
     * @return 结果
     */
    @Override
    public String checkTitleUnique(SysBlog blog)
    {
        blog.setBlogId(StringUtils.isNull(blog.getBlogId()) ? -1L : blog.getBlogId());
        SysBlog checkTitleBlog = blogMapper.checkTitleUnique(blog.getBlogTitle());
        if (StringUtils.isNotNull(checkTitleBlog) && !blog.getBlogId().equals(checkTitleBlog.getBlogId())) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 新增博客标签信息
     *
     * @param blog 博客对象
     */
    public void insertBlogTag(SysBlog blog) {
        Long[] tagIds = blog.getTagIds();
        if (StringUtils.isNotNull(tagIds)) {
            // 新增博客与标签管理
            List<SysBlogTag> list = new ArrayList<>();
            for (Long tagId : tagIds) {
                SysBlogTag bt = new SysBlogTag();
                bt.setBlogId(blog.getBlogId());
                bt.setTagId(tagId);
                list.add(bt);
            }
            if (list.size() > 0) {
                blogTagMapper.batchBlogTag(list);
            }
        }
    }
}
