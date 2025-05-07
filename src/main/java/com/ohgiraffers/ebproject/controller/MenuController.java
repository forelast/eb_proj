package com.ohgiraffers.ebproject.controller;

import com.ohgiraffers.ebproject.dto.MenuDTO;
import com.ohgiraffers.ebproject.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("health")
    public String healthCheck() {
        return "eb_project is online and healthy! dev/feature/test 테스트";
    }

    @GetMapping("menus/{menuCode}")
    public MenuDTO findMenuByMenuCode(@PathVariable("menuCode") int menuCode) {
        return menuService.findMenuByMenuCode(menuCode);
    }
}

