package com.speily.manager.controller.business;

import com.speily.entity.CmsArticle;
import com.speily.common.aspectj.annotation.Log;
import com.speily.common.aspectj.lang.enums.BusinessType;
import com.speily.common.utils.ExcelUtil;
import com.speily.manager.web.page.TableDataInfo;
import com.speily.common.result.AjaxResult;
import com.speily.manager.controller.BaseController;
import com.speily.service.ICmsArticleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章Controller
 *
 * @author spl
 * @date 2019-10-03
 */
@Controller
@RequestMapping("/cms/article")
public class CmsArticleController extends BaseController {
    private String prefix = "cms/article";

    @Autowired
    private ICmsArticleService cmsArticleService;

    @RequiresPermissions("cms:article:view")
    @GetMapping()
    public String article() {
        return prefix + "/article";
    }

    /**
     * 查询文章列表
     */
    @RequiresPermissions("cms:article:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CmsArticle cmsArticle) {
        startPage();
        List<CmsArticle> list = cmsArticleService.selectCmsArticleList(cmsArticle);
        return getDataTable(list);
    }

    /**
     * 导出文章列表
     */
    @RequiresPermissions("cms:article:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CmsArticle cmsArticle) {
        List<CmsArticle> list = cmsArticleService.selectCmsArticleList(cmsArticle);
        ExcelUtil<CmsArticle> util = new ExcelUtil<CmsArticle>(CmsArticle.class);
        return util.exportExcel(list, "article");
    }

    /**
     * 新增文章
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存文章
     */
    @RequiresPermissions("cms:article:add")
    @Log(title = "文章", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CmsArticle cmsArticle) {
        return toAjax(cmsArticleService.insertCmsArticle(cmsArticle));
    }

    /**
     * 修改文章
     */
    @GetMapping("/edit/{articleId}")
    public String edit(@PathVariable("articleId") Long articleId, ModelMap mmap) {
        CmsArticle cmsArticle = cmsArticleService.selectCmsArticleById(articleId);
        mmap.put("cmsArticle", cmsArticle);
        return prefix + "/edit";
    }

    /**
     * 修改保存文章
     */
    @RequiresPermissions("cms:article:edit")
    @Log(title = "文章", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CmsArticle cmsArticle) {
        return toAjax(cmsArticleService.updateCmsArticle(cmsArticle));
    }

    /**
     * 删除文章
     */
    @RequiresPermissions("cms:article:remove")
    @Log(title = "文章", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(cmsArticleService.deleteCmsArticleByIds(ids));
    }
}
