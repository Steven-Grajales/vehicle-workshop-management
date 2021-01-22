package com.repair.car.controller;

import com.repair.car.domain.User;
import com.repair.car.model.UserRegistrationForm;
import com.repair.car.model.UserSearchForm;
import com.repair.car.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
public class OwnerController {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(OwnerController.class);
    private static final String REGISTER_FORM = "UserRegistrationForm";
    private static final String SEARCH_FORM = "UserSearchForm";
    private static final String USERLIST = "users";
    private static final String USER_DETAILS = "userDetails";

    @Autowired
    private UserService userService;

    //Register Mappings
    @RequestMapping(value = "/admin/userRegister", method = RequestMethod.GET)
    public String userRegister(Model model) {
        model.addAttribute(REGISTER_FORM, new UserRegistrationForm());
        return "userRegister";
    }

    @RequestMapping(value = "/admin/userRegister", method = RequestMethod.POST)
    public String userRegister(Model model, @Valid @ModelAttribute(REGISTER_FORM)
                                   UserRegistrationForm userRegistrationForm,
                           BindingResult bindingResult, HttpSession session,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            logger.error(String.format("%s Validation Errors present: ", bindingResult.getErrorCount()));
            //model.addAttribute(REGISTER_FORM, UserRegistrationForm);
            return "userRegister";
        }

        try {
            userService.register(userRegistrationForm);
            redirectAttributes.addFlashAttribute("success", true);

        } catch (Exception exception) {
            redirectAttributes.addFlashAttribute("error", true);
            logger.error("User registration failed: " + exception);
            return "redirect:/admin/userRegister";
        }

        redirectAttributes.addFlashAttribute("message", "You have sucessfully completed registration");
        return "redirect:/admin/userRegister";
    }

    //search Mappings
    @RequestMapping(value = "/admin/userSearch", method = RequestMethod.GET)
    public String userSearch(Model model) {

        model.addAttribute(SEARCH_FORM, new UserSearchForm());
        model.addAttribute(USERLIST,userService.findAllUsers());
        return "userSearch";
    }

    @RequestMapping(value = "/admin/userSearch", method = RequestMethod.POST)
    public String userSearch(Model model, @Valid @ModelAttribute(SEARCH_FORM) UserSearchForm userSearchForm) {

        List<User> userList = userService.findByEmailOrAfm(userSearchForm.getSearchText());
        model.addAttribute(USERLIST, userList);
        return "userSearch";
    }

    @RequestMapping(value = "/admin/userSearch/{afm}/show", method = RequestMethod.GET)
    public String userShow(Model model, @PathVariable("afm") String afm) {

        UserRegistrationForm userDetails = userService.findByAfm(afm);
        model.addAttribute(USER_DETAILS, userDetails);

        return "userShow";
    }

    //update Mappings
    @RequestMapping(value="/admin/userUpdate/{afm}", method= RequestMethod.GET)
    public String userUpdate(@PathVariable String afm,Model model){

        UserRegistrationForm userRegistrationForm = userService.findByAfm(afm);
        model.addAttribute(REGISTER_FORM, userRegistrationForm);
        return "userUpdate";
    }

    @RequestMapping(value="/admin/userUpdate/{afm}", method= RequestMethod.POST)
    public String userUpdate(Model model,@PathVariable String afm,@Valid @ModelAttribute(REGISTER_FORM)
            UserRegistrationForm userRegistrationForm,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){


        if (bindingResult.hasErrors()) {

            logger.error(String.format("%s Validation Errors present: ", bindingResult.getErrorCount()));
            model.addAttribute(REGISTER_FORM, userRegistrationForm);
            return "userUpdate";
        }

        try {
            userService.save(userRegistrationForm);
            model.addAttribute("success", "User edited Successfully.");
        } catch (Exception exception) {
            model.addAttribute("error", exception.getMessage());
            logger.error("User registration failed: " + exception);
        }
        return "userUpdate";
    }

    //Dellete Mapping
    @RequestMapping(value="/admin/userDelete/{afm}", method = RequestMethod.POST)
    public String userDelete(@PathVariable String afm,
                             RedirectAttributes redirectAttributes){
        try {
            userService.delete(afm);
        } catch (Exception exception) {
            redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
        }
        return "redirect:/admin/userSearch";
    }
}