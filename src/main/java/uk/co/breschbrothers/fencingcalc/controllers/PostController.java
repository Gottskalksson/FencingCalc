package uk.co.breschbrothers.fencingcalc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import uk.co.breschbrothers.fencingcalc.entity.Post;
import uk.co.breschbrothers.fencingcalc.repositories.PostRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/admin/post", produces = "text/plain;charset=utf-8")
public class PostController {
    private final PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/add")
    public String addPost(Model model) {
        model.addAttribute("post", new Post());
        return "post-form";
    }

    @PostMapping("/add")
    public String validatePost(@ModelAttribute @Valid Post post, BindingResult result) {

        if (!(result.hasErrors())) {

            post.setPricePerPiece();
            postRepository.save(post);

            return "redirect:/admin/post/list";
        } else {
            return "post-form";
        }
    }

    @RequestMapping("/edit/{id}")
    public String editPost(@PathVariable long id, Model model) {
        Optional<Post> post = postRepository.findById(id);
        model.addAttribute("post", post.orElse(null));
        return "post-form";
    }

    @GetMapping("/list")
    public String listPosts(Model model) {
        List<Post> postList = postRepository.findAll();
        model.addAttribute("postList", postList);
        return "post-list";
    }

    @RequestMapping("/delete/{id}")
    public String deletePost(@PathVariable long id) {
        Optional<Post> post = postRepository.findById(id);
        postRepository.delete(post.orElse(null));
        return "redirect:/admin/post/list";
    }

}
