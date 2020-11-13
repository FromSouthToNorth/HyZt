package vip.hyzt.blogSystem.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.hyzt.blogSystem.mapper.SysTypeMapper;
import vip.hyzt.blogSystem.domain.SysType;
import vip.hyzt.blogSystem.service.ISysTypeService;

/**
 * 博客类型Service业务层处理
 * 
 * @author hyzt
 * @date 2020-11-12
 */
@Service
public class SysTypeServiceImpl implements ISysTypeService {

    @Autowired
    private SysTypeMapper sysTypeMapper;

    /**
     * 查询博客类型
     * 
     * @param typeId 博客类型ID
     * @return 博客类型联
     */
    @Override
    public SysType selectTypeById(Long typeId)
    {
        return sysTypeMapper.selectSysTypeById(typeId);
    }

    /**
     * 查询博客类型联列表
     * 
     * @param type 博客类型
     * @return 博客类型联
     */
    @Override
    public List<SysType> selectTypeList(SysType type)
    {
        return sysTypeMapper.selectSysTypeList(type);
    }

    /**
     * 新增博客类型
     * 
     * @param type 博客类型
     * @return 结果
     */
    @Override
    public int insertType(SysType type)
    {
        return sysTypeMapper.insertSysType(type);
    }

    /**
     * 修改博客类型
     * 
     * @param type 博客类型
     * @return 结果
     */
    @Override
    public int updateType(SysType type)
    {
        return sysTypeMapper.updateSysType(type);
    }

    /**
     * 批量删除博客类型
     * 
     * @param typeIds 需要删除的博客类型ID
     * @return 结果
     */
    @Override
    public int deleteTypeByIds(Long[] typeIds)
    {
        return sysTypeMapper.deleteSysTypeByIds(typeIds);
    }

    /**
     * 删除博客类型信息
     * 
     * @param typeId 博客类型ID
     * @return 结果
     */
    @Override
    public int deleteTypeById(Long typeId)
    {
        return sysTypeMapper.deleteSysTypeById(typeId);
    }

    /**
     * 校验类型名称是否唯一
     *
     * @param type 类型信息
     * @return 结果
     */
    @Override
    public String checkTypeNameUnique(SysType type)
    {
        return null;
    }

    @Override
    public boolean hasChildByTypeId(Long typeId) {
        return false;
    }

    @Override
    public boolean checkTypeExistBlog(Long typeId) {
        return false;
    }
}
