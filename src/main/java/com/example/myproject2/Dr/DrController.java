package com.example.myproject2.Dr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DrController {
    @Autowired
    private DrService drService;

    @GetMapping("/drs")
    public String showDrList(Model model) {
        List<Dr> listDrs = drService.listAll();
        model.addAttribute("listDrs", listDrs);
        return "drs";
    }

    @GetMapping("/drs/new")
    public String showNewForm(Model model) {
        model.addAttribute("dr", new Dr());
        model.addAttribute("PageTitle", "Add new User");
        return "dr_form";
    }

    @PostMapping("/drs/save")
    public String saveDr(Dr dr, RedirectAttributes redirectAttributes) {
        drService.save(dr);
        redirectAttributes.addFlashAttribute("message", "The User has been saved successfully.");
        return "redirect:/drs";
    }

    @GetMapping("/drs/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Dr dr = drService.get(id);
            model.addAttribute("dr", dr);
            model.addAttribute("PageTitle", "Edit Dr ( " + id + " )");
            return "dr_form";
        } catch (DrNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/drs";
        }
    }
    @GetMapping("/drs/delete/{id}")
    public String deleteDr(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            drService.delete(id);
            redirectAttributes.addFlashAttribute("message", "the Dr " + id + " has been deleted.");
        } catch (DrNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/drs";
    }
}
