package vip.hyzt.web.controller.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.hyzt.blogSystem.domain.SysTag;
import vip.hyzt.blogSystem.service.ISysTagService;
import vip.hyzt.common.core.domain.AjaxResult;
import java.util.List;

@RestController
@RequestMapping("/system/tag")
public class SysTagController {

    @Autowired
    private ISysTagService tagService;

    @PreAuthorize("@ss.hasAnyPermi('system:tag:list')")
    @GetMapping("/alltag")
    public AjaxResult allTag() {
        List<SysTag> list = tagService.selectTagList(new SysTag());
        return AjaxResult.success(list);
    }
}
