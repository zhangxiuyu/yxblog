package blog.dev.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {

    @RequestMapping("/")
    String home() {
        return "home/index";
    }


    @RequestMapping("/php")
    String php() {
        return "home/php";
    }
}
