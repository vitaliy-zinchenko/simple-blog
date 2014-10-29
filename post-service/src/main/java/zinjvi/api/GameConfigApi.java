package zinjvi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zinjvi.bean.Post;
import zinjvi.bean.gameconfig.GameConfig;
import zinjvi.controller.BaseRestController;
import zinjvi.service.GameConfigService;
import zinjvi.service.Service;

/**
 * Created by zinchenko on 29.10.14.
 */
@RestController
@RequestMapping("/api/postapi")
public class GameConfigApi extends BaseRestController<GameConfig, String> {

    @Autowired
    protected GameConfigApi(GameConfigService service) {
        super(service);
    }

}
