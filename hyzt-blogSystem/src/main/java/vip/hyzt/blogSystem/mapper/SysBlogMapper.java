package vip.hyzt.blogSystem.mapper;

import java.util.List;
import vip.hyzt.blogSystem.domain.SysBlog;

/**
 * 博客Mapper接口
 * 
 * @author hyzt
 * @date 2020-11-12
 */
public interface SysBlogMapper 
{
    /**
     * 查询博客
     * 
     * @param blogId 博客ID
     * @return 博客
     */
    public SysBlog selectSysBlogById(Long blogId);

    /**
     * 查询博客列表
     * 
     * @param sysBlog 博客
     * @return 博客集合
     */
    public List<SysBlog> selectSysBlogList(SysBlog sysBlog);

    /**
     * 新增博客
     * 
     * @param sysBlog 博客
     * @return 结果
     */
    public int insertSysBlog(SysBlog sysBlog);

    /**
     * 修改博客
     * 
     * @param sysBlog 博客
     * @return 结果
     */
    public int updateSysBlog(SysBlog sysBlog);

    /**
     * 删除博客
     * 
     * @param blogId 博客ID
     * @return 结果
     */
    public int deleteSysBlogById(Long blogId);

    /**
     * 批量删除博客
     * 
     * @param blogIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysBlogByIds(Long[] blogIds);

    /**
     * 校验博客标题是否唯一
     *
     * @param blogTitle 博客标题
     * @return 结果
     */
    public SysBlog checkTitleUnique(String blogTitle);
}
