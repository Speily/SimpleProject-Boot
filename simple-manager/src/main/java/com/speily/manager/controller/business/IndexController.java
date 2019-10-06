package com.speily.manager.controller.business;

import com.speily.entity.Menu;
import com.speily.entity.User;
import com.speily.common.ProjectConfig;
import com.speily.manager.controller.BaseController;
import com.speily.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 首页 业务处理
 *
 * @author spl
 */
@Controller
public class IndexController extends BaseController {
    @Autowired
    private IMenuService menuService;

    @Autowired
    private ProjectConfig projectConfig;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap) {
        // 取身份信息
        User user = getSysUser();
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", projectConfig.getCopyrightYear());
        mmap.put("demoEnabled", projectConfig.isDemoEnabled());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap) {
        mmap.put("version", projectConfig.getVersion());
        return "main";
    }
}
