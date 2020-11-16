package vip.hyzt.web.controller.blog;

import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import oshi.driver.mac.net.NetStat;
import vip.hyzt.blogSystem.domain.SysBlog;
import vip.hyzt.blogSystem.service.ISysBlogService;
import vip.hyzt.common.annotation.Log;
import vip.hyzt.common.constant.UserConstants;
import vip.hyzt.common.core.controller.BaseController;
import vip.hyzt.common.core.domain.AjaxResult;
import vip.hyzt.common.core.page.TableDataInfo;
import vip.hyzt.common.enums.BusinessType;
import vip.hyzt.common.utils.SecurityUtils;
import java.util.List;

/**
 * 博客 操作处理
 */
@RestController
@RequestMapping("/system/blog")
public class SysBlogController extends BaseController {

    @Autowired
    private ISysBlogService blogService;

    /**
     * 博客列表数据
     */
    @PreAuthorize("@ss.hasPermi('system:blog:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysBlog blog) {
        startPage();
        List<SysBlog> list = blogService.selectBlogList(blog);
        return getDataTable(list);
    }

    /**
     * 添加博客信息
     */
    @Log(title = "博客管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('system:blog:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysBlog blog) {
        if (blogService.checkTitleUnique(blog).equals(UserConstants.NOT_UNIQUE)) {
            return AjaxResult.error("博客标题已存在 ‘" + blog.getBlogTitle() + "’ 请重新输入，新的标题");
        }
        blog.setUserId(SecurityUtils.getUserId());
        return toAjax(blogService.insertBlog(blog));
    }

    /**
     * 博客编号查询博客信息
     */
    @PreAuthorize("@ss.hasAnyPermi('system:blog:query')")
    @GetMapping(value = { "/", "/{blogId}" })
    public AjaxResult getInfo(@PathVariable(value = "blogId") Long blogId) {
        SysBlog blog = blogService.selectBlogById(blogId);
        return AjaxResult.success(blog);
    }

    /**
     * 修改博客
     */
    @PreAuthorize("@ss.hasAnyPermi('system:blog:edit')")
    @Log(title = "博客管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysBlog blog) {
        if (blogService.checkTitleUnique(blog).equals(UserConstants.NOT_UNIQUE)) {
            return AjaxResult.error("博客标题已存在 ’" + blog.getBlogTitle() + "’ 请重新输入，新的标题");
        }
        blog.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(blogService.updateBlog(blog));
    }

    /**
     * 删除博客
     */
    @PreAuthorize("@ss.hasAnyPermi('system:blog:remove')")
    @Log(title = "博客管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{blogIds}")
    public AjaxResult remove(@PathVariable Long[] blogIds) {
        return toAjax(blogService.deleteBlogByIds(blogIds));
    }
}
