package vip.hyzt.blogSystem.service;

import java.util.List;
import vip.hyzt.blogSystem.domain.SysBlogTag;

/**
 * 博客与标签关联Service接口
 * 
 * @author hyzt
 * @date 2020-11-12
 */
public interface ISysBlogTagService {

    /**
     * 批量删除博客与标签关联
     *
     * @param blogIds 需要删除的博客与标签关联ID
     * @return 结果
     */
    public int deleteSysBlogTagByIds(Long[] blogIds);

    /**
     * 删除博客与标签关联信息
     * 
     * @param blogId 博客与标签关联ID
     * @return 结果
     */
    public int deleteSysBlogTagById(Long blogId);
}
