package vip.hyzt.blogSystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.hyzt.blogSystem.mapper.SysBlogTagMapper;
import vip.hyzt.blogSystem.service.ISysBlogTagService;

/**
 * 博客与标签关联Service业务层处理
 * 
 * @author hyzt
 * @date 2020-11-12
 */
@Service
public class SysBlogTagServiceImpl implements ISysBlogTagService 
{
    @Autowired
    private SysBlogTagMapper blogTagMapper;

    @Override
    public int deleteSysBlogTagByIds(Long[] blogIds)
    {
        return blogTagMapper.deleteSysBlogTag(blogIds);
    }

    /**
     * 删除博客与标签关联信息
     * 
     * @param blogId 博客与标签关联ID
     * @return 结果
     */
    @Override
    public int deleteSysBlogTagById(Long blogId)
    {
        return blogTagMapper.deleteSysBlogTagById(blogId);
    }
}
