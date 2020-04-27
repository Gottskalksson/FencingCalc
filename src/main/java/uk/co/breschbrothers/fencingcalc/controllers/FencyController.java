package uk.co.breschbrothers.fencingcalc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import uk.co.breschbrothers.fencingcalc.entity.Fency;
import uk.co.breschbrothers.fencingcalc.entity.Post;
import uk.co.breschbrothers.fencingcalc.repositories.FencyRepository;
import uk.co.breschbrothers.fencingcalc.repositories.PostRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(value = "/admin/fency", produces = "text/plain;charset=utf-8")
public class FencyController {

    private final FencyRepository fencyRepository;
    private final PostRepository postRepository;

    @Autowired
    public FencyController(FencyRepository fencyRepository, PostRepository postRepository) {
        this.fencyRepository = fencyRepository;
        this.postRepository = postRepository;
    }

    @GetMapping("/add")
    public String addFency(Model model) {
        model.addAttribute("fency", new Fency());
        return "fency-form";
    }

    @PostMapping("/add")
    public String validateFency (@ModelAttribute @Valid Fency fency, BindingResult result) {

        if (!result.hasErrors()) {
            fency.setPricePerPiece();
            fencyRepository.save(fency);
            return "redirect:/admin/fency/list";
        } else {
            return "fency-form";
        }
    }

    @RequestMapping("/edit/{id}")
    public String editFency(@PathVariable long id, Model model) {
        Optional<Fency> fencyOptional = fencyRepository.findById(id);
        model.addAttribute("fency", fencyOptional.orElse(null));
        return "fency-form";
    }

    @GetMapping("/list")
    public String listFencies(Model model) {
        List<Fency> fencyList = fencyRepository.findAll();
        model.addAttribute("fencyList", fencyList);
        return "fency-list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteFency(@PathVariable long id) {
        Optional<Fency> fencyOptional = fencyRepository.findById(id);
        fencyOptional.ifPresent(fencyRepository::delete);
        return "redirect:/admin/fency/list";
    }

    @ModelAttribute("posts")
    public List<Post> posts() {return postRepository.findAll();}


}
