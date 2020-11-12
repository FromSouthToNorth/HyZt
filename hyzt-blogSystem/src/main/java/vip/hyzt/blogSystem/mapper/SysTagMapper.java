package vip.hyzt.blogSystem.mapper;

import java.util.List;
import vip.hyzt.blogSystem.domain.SysTag;

/**
 * 博客标签Mapper接口
 * 
 * @author hyzt
 * @date 2020-11-12
 */
public interface SysTagMapper 
{
    /**
     * 查询博客标签
     * 
     * @param tagId 博客标签ID
     * @return 博客标签
     */
    public SysTag selectSysTagById(Long tagId);

    /**
     * 查询博客标签列表
     * 
     * @param sysTag 博客标签
     * @return 博客标签集合
     */
    public List<SysTag> selectSysTagList(SysTag sysTag);

    /**
     * 新增博客标签
     * 
     * @param sysTag 博客标签
     * @return 结果
     */
    public int insertSysTag(SysTag sysTag);

    /**
     * 修改博客标签
     * 
     * @param sysTag 博客标签
     * @return 结果
     */
    public int updateSysTag(SysTag sysTag);

    /**
     * 删除博客标签
     * 
     * @param tagId 博客标签ID
     * @return 结果
     */
    public int deleteSysTagById(Long tagId);

    /**
     * 批量删除博客标签
     * 
     * @param tagIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysTagByIds(Long[] tagIds);

    /**
     * 校验标签名称是否唯一
     *
     * @param tagName 标签名称
     * @return 结果
     */
    public SysTag checkTagNameUnique(String tagName);

    /**
     * 查询标签是否存在博客
     *
     * @param tagId 标签ID
     * @return 结果
     */
    public int checkTagExistBlog(Long tagId);
}
