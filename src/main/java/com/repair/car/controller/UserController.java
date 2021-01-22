package com.repair.car.controller;

import com.repair.car.model.AdminForm;
import com.repair.car.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    private static final String REPAIR_LIST = "repairList";

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(Model model,Principal principal) {

        List<AdminForm> repairList = adminService.userSearch(principal.getName());
        model.addAttribute(REPAIR_LIST, repairList );

        return "user";
    }

}

