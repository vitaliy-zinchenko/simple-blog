package zinjvi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zinjvi.bean.gameconfig.GameConfig;
import zinjvi.repository.GameConfigRepository;
import zinjvi.repository.Repository;
import zinjvi.service.GameConfigService;
import zinjvi.service.PostService;

/**
 * Created by zinchenko on 29.10.14.
 */
@Service
public class GameConfigServiceImpl extends BaseService<GameConfig, String>
        implements GameConfigService {

    @Autowired
    private PostService postService;

    @Autowired
    public GameConfigServiceImpl(GameConfigRepository repository) {
        super(repository);
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }
}
