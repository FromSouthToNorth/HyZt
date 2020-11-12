package vip.hyzt.web.controller.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.hyzt.blogSystem.domain.SysBlog;
import vip.hyzt.blogSystem.service.ISysBlogService;
import vip.hyzt.common.core.controller.BaseController;
import vip.hyzt.common.core.page.TableDataInfo;
import java.util.List;

@RestController
@RequestMapping("/system/blog")
public class SysBlogController extends BaseController {

    @Autowired
    private ISysBlogService blogService;

    @PreAuthorize("@ss.hasPermi('system:blog:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysBlog blog) {
        startPage();
        List<SysBlog> list = blogService.selectBlogList(blog);
        return getDataTable(list);
    }
}
