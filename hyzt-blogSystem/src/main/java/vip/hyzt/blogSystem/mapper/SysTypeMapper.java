package vip.hyzt.blogSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import vip.hyzt.blogSystem.domain.SysType;

/**
 * 博客类型联Mapper接口
 * 
 * @author hyzt
 * @date 2020-11-12
 */
public interface SysTypeMapper 
{
    /**
     * 查询博客类型联
     * 
     * @param typeId 博客类型联ID
     * @return 博客类型联
     */
    public SysType selectSysTypeById(Long typeId);

    /**
     * 查询博客类型联列表
     * 
     * @param sysType 博客类型联
     * @return 博客类型联集合
     */
    public List<SysType> selectSysTypeList(SysType sysType);

    /**
     * 新增博客类型联
     * 
     * @param sysType 博客类型联
     * @return 结果
     */
    public int insertSysType(SysType sysType);

    /**
     * 修改博客类型联
     * 
     * @param sysType 博客类型联
     * @return 结果
     */
    public int updateSysType(SysType sysType);

    /**
     * 删除博客类型联
     * 
     * @param typeId 博客类型联ID
     * @return 结果
     */
    public int deleteSysTypeById(Long typeId);

    /**
     * 批量删除博客类型联
     * 
     * @param typeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysTypeByIds(Long[] typeIds);

    /**
     * 校验类型名称是否唯一
     *
     * @param typeName 部门名称
     * @param parentId 父部门ID
     * @return 结果
     */
    public SysType checkTypeNameUnique(@Param("typeName") String typeName, @Param("parentId") Long parentId);

    /**
     * 根据ID查询所有子类型
     *
     * @param typeId 类型ID
     * @return 类型列表
     */
    public List<SysType> selectChildrenTypeById(Long typeId);

    /**
     * 是否存在子节点
     *
     * @param typeId 类型ID
     * @return 结果
     */
    public int hasChildByTypeId(Long typeId);

    /**
     * 查询类型是否存在博客
     *
     * @param typeId 类型ID
     * @return 结果
     */
    public int checkTypeExistBlog(Long typeId);

    /**
     * 修改子元素关系
     *
     * @param types 子元素
     * @return 结果
     */
    public int updateTypeChildren(@Param("types") List<SysType> types);
}
