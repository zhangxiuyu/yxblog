package blog.controller.home;

import blog.mapper.ArticleMapper;
import blog.model.ArticleLabelModel;
import blog.model.ArticleModel;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ArticleTypeController {

    @Autowired
    ArticleMapper articleMapper;

    @Value("${yunxiu.pageSize}")
    private int pageSize;

    @RequestMapping("/article_type/{type_id}")
    String getType(@PathVariable(name = "type_id") int type_id,
                   ModelMap mmap) {
        List<ArticleLabelModel> articleLabelModelList = articleMapper.getArticleLabel();

        PageHelper.startPage(1,this.pageSize);
        List<ArticleModel> article = articleMapper.getArticleOnType(type_id);

        mmap.put("type_id",type_id);
        mmap.put("article",article);
        mmap.put("article_label",articleLabelModelList);


        return "/home/articleType";
    }


    @RequestMapping("/article_type/{type_id}/{page}")
    String getType(@PathVariable(name = "type_id") int type_id,
                   @PathVariable(name = "page") int page,
                   ModelMap mmap) {
        List<ArticleLabelModel> articleLabelModelList = articleMapper.getArticleLabel();

        PageHelper.startPage(page,this.pageSize);
        List<ArticleModel> article = articleMapper.getArticleOnType(type_id);

        mmap.put("type_id",type_id);
        mmap.put("article",article);
        mmap.put("article_label",articleLabelModelList);


        return "/home/articleType";
    }

}
