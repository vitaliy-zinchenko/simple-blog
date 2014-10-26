package zinjvi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zinjvi.bean.Post;
import zinjvi.repository.PostRepository;
import zinjvi.repository.Repository;
import zinjvi.service.PostService;
import zinjvi.service.impl.BaseService;

/**
 * Created by zinchenko on 26.10.14.
 */
@Service
public class PostServiceImpl extends BaseService<Post, String> implements PostService{

    @Autowired
    public PostServiceImpl(PostRepository repository) {
        super(repository);
    }
}
