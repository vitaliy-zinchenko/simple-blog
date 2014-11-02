package zinjvi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zinchenko on 30.10.14.
 */
@Controller
@RequestMapping("/gameConstructor")
public class GameConstructorController {

    @RequestMapping("/index")
    public String gameConstructor() {
        return "gameConstructor";
    }

}
