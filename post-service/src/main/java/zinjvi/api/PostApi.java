package zinjvi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zinjvi.bean.Post;
import zinjvi.controller.BaseRestController;
import zinjvi.service.PostService;
import zinjvi.service.Service;

@RestController
@RequestMapping("/api/postapi")
public class PostApi extends BaseRestController<Post, String> {

    PostService postService;

    @Autowired
    public PostApi(PostService service) {
        super(service);
        postService = service;
    }

    @RequestMapping("/test")
    public Post get() {
        Post post = new Post();
//        post.setId("1");
        post.setMessage("mmmm");
        postService.save(post);
        return post;
    }
}