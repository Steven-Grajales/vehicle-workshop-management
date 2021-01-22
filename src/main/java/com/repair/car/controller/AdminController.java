package com.repair.car.controller;


import com.repair.car.model.AdminForm;
import com.repair.car.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {

    private static final String REPAIR_LIST = "repairList";

    @Autowired
    private AdminService adminService;

    @RequestMapping(value="/admin", method= RequestMethod.GET)
    public String adminPage(Model model){

        List<AdminForm> repairList = adminService.adminSearch();
        model.addAttribute(REPAIR_LIST, repairList );

        return "admin";
    }

}
