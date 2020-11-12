package vip.hyzt.blogSystem.mapper;

import java.util.List;
import vip.hyzt.blogSystem.domain.SysBlogTag;

/**
 * 博客与标签关联Mapper接口
 * 
 * @author hyzt
 * @date 2020-11-12
 */
public interface SysBlogTagMapper {

    /**
     * 通过博客ID删除博客与标签关联
     * 
     * @param blogId 博客ID
     * @return 结果
     */
    public int deleteSysBlogTagById(Long blogId);

    /**
     * 通过岗位ID查询标签使用数量
     *
     * @param tagId 标签ID
     * @return  结果
     */
    public int countBlogTagById(Long tagId);

    /**
     * 批量删除博客与标签关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysBlogTag(Long[] ids);

    /**
     * 批量新增博客标签信息
     *
     * @param blogTagList 博客标签列表
     * @return 结果
     */
    public int batchBlogTag(List<SysBlogTag> blogTagList);
}
