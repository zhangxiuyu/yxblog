package blog.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {


    // 首页
    @RequestMapping("/")
    String index() {
        // 获取数据

        return "home/index";
    }


    @RequestMapping("/php")
    String php() {
        return "home/php";
    }
}
