package zinjvi.zinjvi.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zinjvi.zinjvi.beans.Post;

@RestController
@RequestMapping("/post")
public class PostApi {

    @RequestMapping("/")
    public Post get() {
        Post post = new Post();
        post.setId(1L);
        post.setMessage("mmmm");
        return post;
    }
}