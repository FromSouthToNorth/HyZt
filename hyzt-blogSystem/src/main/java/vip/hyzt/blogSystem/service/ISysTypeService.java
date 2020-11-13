package vip.hyzt.blogSystem.service;

import java.util.List;
import vip.hyzt.blogSystem.domain.SysType;

/**
 * 博客类型Service接口
 * 
 * @author hyzt
 * @date 2020-11-12
 */
public interface ISysTypeService {
    
    /**
     * 查询博客类型
     * 
     * @param typeId 博客类型ID
     * @return 博客类型联
     */
    public SysType selectTypeById(Long typeId);

    /**
     * 查询博客类型列表
     * 
     * @param type 博客类型
     * @return 博客类型联集合
     */
    public List<SysType> selectTypeList(SysType type);

    /**
     * 新增博客类型
     * 
     * @param type 博客类型
     * @return 结果
     */
    public int insertType(SysType type);

    /**
     * 修改博客类型
     * 
     * @param type 博客类型
     * @return 结果
     */
    public int updateType(SysType type);

    /**
     * 批量删除博客类型
     * 
     * @param typeIds 需要删除的博客类型ID
     * @return 结果
     */
    public int deleteTypeByIds(Long[] typeIds);

    /**
     * 删除博客类型信息
     * 
     * @param typeId 博客类型ID
     * @return 结果
     */
    public int deleteTypeById(Long typeId);

    /**
     * 校验类型名称是否唯一
     *
     * @param type 类型信息
     * @return 结果
     */
    public String checkTypeNameUnique(SysType type);

    /**
     * 是否存在类型子节点
     *
     * @param typeId 类型ID
     * @return 结果
     */
    public boolean hasChildByTypeId(Long typeId);

    /**
     * 查询类型是否存在博客
     *
     * @param typeId 类型ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkTypeExistBlog(Long typeId);
}
