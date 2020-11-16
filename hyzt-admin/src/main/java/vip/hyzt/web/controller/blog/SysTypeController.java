package vip.hyzt.web.controller.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.hyzt.blogSystem.domain.SysType;
import vip.hyzt.blogSystem.service.ISysTypeService;
import vip.hyzt.common.core.domain.AjaxResult;
import java.util.List;

/**
 * 博客类型 操作处理
 */
@RestController
@RequestMapping("/system/type")
public class SysTypeController {

    @Autowired
    private ISysTypeService typeService;

    /**
     * 查询全部博客列表信息
     */
    @PreAuthorize("@ss.hasAnyPermi('system:type:list')")
    @GetMapping("/alltype")
    public AjaxResult allType() {
        List<SysType> list = typeService.selectTypeList(new SysType());
        return AjaxResult.success(list);
    }
}
