package com.repair.car.controller;

import com.repair.car.converters.RepairConverter;
import com.repair.car.domain.Repair;
import com.repair.car.model.RepairCreateForm;
import com.repair.car.model.RepairSearchForm;
import com.repair.car.services.RepairService;
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
public class RepairController {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(RepairController.class);
    private static final String REPAIR_CREATE_FORM = "repairCreateForm";
    private static final String REPAIR_SEARCH_FORM = "repairSearchForm";
    private static final String REPAIR_TO_EDIT = "repairToEdit";
    private static final String REPAIR_LIST = "repairList";
    private static final String REPAIR_DETAILS = "repairDetails";

    @Autowired
    private RepairService repairService;

    @RequestMapping(value = "/admin/repairCreate", method = RequestMethod.GET)
    public String repairCreate(Model model) {

            model.addAttribute(REPAIR_CREATE_FORM, new RepairCreateForm());
        return "repairCreate";     //repairCreate.ftl
    }

   @RequestMapping(value = "/admin/repairCreate", method = RequestMethod.POST)
   public String repairCreate(Model model,
                                 @Valid @ModelAttribute(REPAIR_CREATE_FORM) RepairCreateForm repairCreateForm,
                                 BindingResult bindingResult,
                                 HttpSession session,
                                 RedirectAttributes redirectAttributes) {

       if (bindingResult.hasErrors()) {

           logger.error(String.format("%s Validation Errors present: ", bindingResult.getErrorCount()));
           model.addAttribute(REPAIR_CREATE_FORM, repairCreateForm);
           return "repairCreate";
       }

       try {
           repairService.repairCreate(repairCreateForm);
           redirectAttributes.addFlashAttribute("success", true);



       } catch (Exception exception) {
           redirectAttributes.addFlashAttribute("error", true);
           logger.error("Repair Creation failed: " + exception);

       }

       return "redirect:/admin/repairCreate";
   }

    @RequestMapping(value = "/admin/repairSearch", method = RequestMethod.GET)
    public String repairSearch(Model model) {

        model.addAttribute(REPAIR_SEARCH_FORM, new RepairSearchForm());
        model.addAttribute(REPAIR_LIST,repairService.findAllRepairs());

        return "repairSearch";
    }



    @RequestMapping(value = "/admin/repairSearch", method = RequestMethod.POST)
    public String repairSearch(Model model,
                               @ModelAttribute(REPAIR_SEARCH_FORM) RepairSearchForm repairSearchForm,
                               HttpSession session,
                               RedirectAttributes redirectAttributes) {

        List<RepairCreateForm> repairList = repairService.repairSearch(repairSearchForm.getSearchText());
        if (repairList.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "No Repairs found");
            System.err.println("empty");
        }
        model.addAttribute(REPAIR_LIST, repairList );
        return "repairSearch";
    }

    @RequestMapping(value = "/admin/repairSearch/{id}/show", method = RequestMethod.GET)
    public String repairShow(Model model, @PathVariable("id") Long repairId) {

        RepairCreateForm repairDetails = repairService.findByRepairId(repairId);
        model.addAttribute(REPAIR_DETAILS, repairDetails);

        return "repairShow";
    }


    @RequestMapping(value = "/admin/repairSearch/{id}/edit", method = RequestMethod.GET)
    public String repairEdit(Model model, @PathVariable("id") Long repairId) {


        RepairCreateForm repairToEdit = repairService.findByRepairId(repairId);
        System.err.println(repairToEdit.getRepairId());

        model.addAttribute(REPAIR_TO_EDIT, repairToEdit);
        System.err.println("edit");
        return "repairEdit";
    }


    @RequestMapping(value = "/admin/repairSearch/{id}/edit", method = RequestMethod.POST)
    public String repairEdit(Model model,
                             @Valid @ModelAttribute(REPAIR_TO_EDIT) RepairCreateForm repairToEdit,
                             BindingResult bindingResult,
                             HttpSession session,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            logger.error(String.format("%s Validation Errors present: ", bindingResult.getErrorCount()));
            model.addAttribute(REPAIR_TO_EDIT, repairToEdit);
            return "repairEdit";
        }

        try {

            repairService.repairEdit(repairToEdit);
            model.addAttribute("success", true);


        } catch (Exception exception) {

            model.addAttribute("error", true);
            logger.error("Repair Edit failed: " + exception);
        }
        return "repairEdit";

    }
    @RequestMapping(value = "/admin/repairSearch/{id}/delete", method = RequestMethod.POST)
    public String deleteRepair(@PathVariable("id") Long repairId) {
        repairService.deleteById(repairId);
        return "redirect:/admin/repairSearch";
    }
}
