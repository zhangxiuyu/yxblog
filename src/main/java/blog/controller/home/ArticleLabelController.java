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
public class ArticleLabelController {

    @Autowired
    ArticleMapper articleMapper;

    @Value("${yunxiu.pageSize}")
    private int pageSize;

    @RequestMapping("/article_label/{label_id}")
    String getType(@PathVariable(name = "label_id") int label_id,
                   ModelMap mmap) {

        List<ArticleLabelModel> articleLabelModelList = articleMapper.getArticleLabel();

        PageHelper.startPage(1,this.pageSize);
        List<ArticleModel> article = articleMapper.getArticleOnLabel(label_id);

        System.out.println(article);

        mmap.put("type_id",label_id);
        mmap.put("article",article);
        mmap.put("article_label",articleLabelModelList);


        return "/home/articleLabel";
    }



    @RequestMapping("/article_label/{label_id}/{pageNum}")
    String getType(@PathVariable(name = "label_id") int label_id,
                   @PathVariable(name = "pageNum") int page,
                   ModelMap mmap) {

        List<ArticleLabelModel> articleLabelModelList = articleMapper.getArticleLabel();

        PageHelper.startPage(page,this.pageSize);
        List<ArticleModel> article = articleMapper.getArticleOnLabel(label_id);

        mmap.put("type_id",label_id);
        mmap.put("article",article);
        mmap.put("article_label",articleLabelModelList);


        return "/home/articleLabel";
    }

}
