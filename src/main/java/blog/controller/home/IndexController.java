package blog.controller.home;

import java.util.List;
import blog.mapper.ArticleMapper;
import blog.model.ArticleLabelModel;
import blog.model.ArticleModel;
import blog.model.ArticleTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private ArticleMapper articleMapper;

    @Value("${yunxiu.header.title}")
    private String title;

    public String getTitle() {
        return title;
    }


    // 首页
    @RequestMapping("/")
    String index(ModelMap mmap) {
        // 获取数据
        List<ArticleModel> article = articleMapper.getTopArticle();
        List<ArticleLabelModel> articleLabelModelList = articleMapper.getArticleLabel();
        List<ArticleTypeModel> articleTypeModelList = articleMapper.getArticType();
        mmap.put("title",this.getTitle());
        mmap.put("mu","index");
        mmap.put("article",article);
        mmap.put("article_label",articleLabelModelList);
        mmap.put("article_type",articleTypeModelList);
        return "home/index";
    }


    // 首页
    @RequestMapping("/user/list")
    String userlist(ModelMap mmap) {
        // 获取数据
        List<ArticleModel> article = articleMapper.getTopArticle();
        List<ArticleLabelModel> articleLabelModelList = articleMapper.getArticleLabel();
        List<ArticleTypeModel> articleTypeModelList = articleMapper.getArticType();
        mmap.put("title",this.getTitle());
        mmap.put("mu","index");
        mmap.put("article",article);
        mmap.put("article_label",articleLabelModelList);
        mmap.put("article_type",articleTypeModelList);
        return "home/index";
    }


}
