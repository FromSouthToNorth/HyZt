package vip.hyzt.blogSystem.service;

import java.util.List;
import vip.hyzt.blogSystem.domain.SysBlog;

/**
 * 博客Service接口
 * 
 * @author hyzt
 * @date 2020-11-12
 */
public interface ISysBlogService {

    /**
     * 查询博客
     * 
     * @param blogId 博客ID
     * @return 博客
     */
    public SysBlog selectBlogById(Long blogId);

    /**
     * 查询博客列表
     * 
     * @param blog 博客
     * @return 博客集合
     */
    public List<SysBlog> selectBlogList(SysBlog blog);

    /**
     * 新增博客
     * 
     * @param blog 博客
     * @return 结果
     */
    public int insertBlog(SysBlog blog);

    /**
     * 修改博客
     * 
     * @param blog 博客
     * @return 结果
     */
    public int updateBlog(SysBlog blog);

    /**
     * 批量删除博客
     * 
     * @param blogIds 需要删除的博客ID
     * @return 结果
     */
    public int deleteBlogByIds(Long[] blogIds);

    /**
     * 删除博客信息
     * 
     * @param blogId 博客ID
     * @return 结果
     */
    public int deleteBlogById(Long blogId);

    /**
     * 校验博客标题是否唯一
     *
     * @param blogTitle 博客标题
     * @return 结果
     */
    public String checkTitleUnique(String blogTitle);
}
