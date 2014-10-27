package zinjvi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zinjvi.service.PostService;

/**
 * Created by zinchenko on 27.10.14.
 */
@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "index";
    }

}
