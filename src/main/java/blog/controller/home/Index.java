package blog.controller.home;

import java.util.List;
import blog.mapper.ArticleMapper;
import blog.model.ArticleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {

    @Autowired
    private ArticleMapper articleMapper;


    // 首页
    @RequestMapping("/")
    String index(ModelMap mmap) {
        // 获取数据
        List<ArticleModel> article = articleMapper.getTopArticle();
        mmap.put("article",article);
        System.out.println(article.toString());
        return "home/index";
    }


    @RequestMapping("/php")
    String php() {
        return "home/php";
    }
}
