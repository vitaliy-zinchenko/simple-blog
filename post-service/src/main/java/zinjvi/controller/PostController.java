package zinjvi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zinjvi.bean.Comment;
import zinjvi.bean.Post;
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

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/createComment")
    public String create(@ModelAttribute Post post, @ModelAttribute  String postId) {
        postService.save(post);
        return "redirect:/post/index";
    }

    @RequestMapping("/testC")
    @ResponseBody
    public Post testC() {
        Post post = new Post();
        post.setMessage("m_" + System.currentTimeMillis());

        Comment comment = new Comment();
        comment.setMessage("m_" + System.currentTimeMillis());
        post.getComments().add(comment);

        Comment comment2 = new Comment();
        comment2.setMessage("m_" + System.currentTimeMillis());
        post.getComments().add(comment2);

        postService.save(post);
        return post;
    }

}
