package zinjvi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import zinjvi.beans.Bean;

@Controller
public class Controllers {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/index")
    public String index(Model model) {
        Bean bean = restTemplate.getForObject("http://localhost:8081/post/", Bean.class);
        model.addAttribute("key", bean.getMessage());
        return "index";
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
