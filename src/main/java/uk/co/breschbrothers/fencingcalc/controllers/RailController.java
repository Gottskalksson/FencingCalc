package uk.co.breschbrothers.fencingcalc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import uk.co.breschbrothers.fencingcalc.entity.Rail;
import uk.co.breschbrothers.fencingcalc.repositories.RailRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/admin/rail", produces = "text/plain;charset=utf-8")
public class RailController {
    private final RailRepository railRepository;

    @Autowired
    public RailController(RailRepository railRepository) {
        this.railRepository = railRepository;
    }

    @GetMapping("/add")
    public String addRail(Model model) {
        model.addAttribute("rail", new Rail());
        return "rail-form";
    }

    @PostMapping("/add")
    public String validateRail (@ModelAttribute @Valid Rail rail, BindingResult result) {


        if (!(result.hasErrors())) {
            rail.setPricePerPiece();
            railRepository.save(rail);

            return "redirect:/admin/rail/list";
        } else {
            return "rail-form";
        }
    }

    @RequestMapping("/edit/{id}")
    public String editRail(@PathVariable long id, Model model) {
        Optional<Rail> rail = railRepository.findById(id);
        model.addAttribute("rail", rail.orElse(null));
        return "rail-form";
    }

    @GetMapping("/list")
    public String listRails(Model model) {
        List<Rail> railList = railRepository.findAll();
        model.addAttribute("railList", railList);
        return "rail-list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteRail(@PathVariable long id) {
        Optional<Rail> rail = railRepository.findById(id);
        railRepository.delete(rail.orElse(null));
        return "redirect:/admin/rail/list";
    }

}
