package uk.co.breschbrothers.fencingcalc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import uk.co.breschbrothers.fencingcalc.entity.Another;
import uk.co.breschbrothers.fencingcalc.repositories.AnotherRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/admin/another", produces = "text/plain;charset=utf-8")
public class AnotherController {

    private final AnotherRepository anotherRepository;

    @Autowired
    public AnotherController(AnotherRepository anotherRepository) {
        this.anotherRepository = anotherRepository;
    }

    @GetMapping("/add")
    public String addExtra(Model model) {
        model.addAttribute("another", new Another());
        return "another-form";
    }

    @PostMapping("/add")
    public String validateExtra (@ModelAttribute @Valid Another another, BindingResult result) {

        if (!result.hasErrors()) {
            anotherRepository.save(another);
            return "redirect:/admin/another/list";

        } else {
            return "another-form";
        }
    }

    @RequestMapping("/edit/{id}")
    public String editExtra(@PathVariable long id, Model model) {
        Optional<Another> another = anotherRepository.findById(id);
        model.addAttribute("another", another.orElse(null));
        return "another-form";
    }

    @GetMapping("/list")
    public String listExtras(Model model) {
        List<Another> anotherList = anotherRepository.findAll();
        model.addAttribute("anotherList", anotherList);
        return "another-list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteRail(@PathVariable long id) {
        Optional<Another> another = anotherRepository.findById(id);
        anotherRepository.delete(another.orElse(null));
        return "redirect:/admin/another/list";
    }
}
