package blog.controller.home;

import blog.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleMapper articleMapper;

    @Value("${yunxiu.header.title}")
    private String title;

    public String getTitle() {
        return title;
    }


    // 文章详情
    @RequestMapping("/article/{id}")
    public void getArticleOne(@PathVariable(name = "id") String id,
                           ModelMap mapp) {
        List<ArticleMapper> article = articleMapper.getArticleOne(id);
        mapp.put("article",article);
        return "home/index";
    }
}
