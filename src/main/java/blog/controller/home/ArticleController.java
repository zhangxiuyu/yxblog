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
public class ArticleController {

    @Autowired
    private ArticleMapper articleMapper;

    @Value("${yunxiu.pageSize}")
    private int pageSize;


    // 文章详情
    @RequestMapping("/article/{id}")
    String getArticleOne(@PathVariable(name = "id") String id,
                           ModelMap mmap) {

        articleMapper.addArticleOne(id);// 加一个浏览数
        List<ArticleLabelModel> articleLabelModelList = articleMapper.getArticleLabel();
        List<ArticleModel> article = articleMapper.getArticleOne(id);

        mmap.put("article",article);
        mmap.put("article_label",articleLabelModelList);
        System.out.println(article);

        return "home/articleOne";
    }


    /**
     * 文章列表 分页
     * @param mmap
     * @return
     */
    @RequestMapping("/articleList/{page}")
    String getArticle(@PathVariable(name = "page") int page,ModelMap mmap){

        List<ArticleLabelModel> articleLabelModelList = articleMapper.getArticleLabel();

        PageHelper.startPage(page,this.pageSize);
        List<ArticleModel> article = articleMapper.getArticle();
        mmap.put("title","文章");
        mmap.put("mu","article");
        mmap.put("article",article);
        mmap.put("article_label",articleLabelModelList);


        return "home/articleList";
    }

    /**
     * 文章列表 不分页
     * @param mmap
     * @return
     */
    @RequestMapping("/articleList")
    String getArticleList(ModelMap mmap){

        List<ArticleLabelModel> articleLabelModelList = articleMapper.getArticleLabel();

        PageHelper.startPage(1,this.pageSize);
        List<ArticleModel> article = articleMapper.getArticle();

        mmap.put("title","文章");
        mmap.put("mu","article");
        mmap.put("article",article);
        mmap.put("article_label",articleLabelModelList);

        return "home/articleList";
    }


    /**
     *  热门文章
     * @param mmap
     * @return
     */
    @RequestMapping("/articleHot")
    String getArticleHot(ModelMap mmap){
        List<ArticleLabelModel> articleLabelModelList = articleMapper.getArticleLabel();

        PageHelper.startPage(1,this.pageSize);
        List<ArticleModel> article = articleMapper.getArticleHot();

        mmap.put("mu","articleHot");
        mmap.put("article",article);
        mmap.put("article_label",articleLabelModelList);
        return "home/articleHot";
    }


    /**
     *  热门文章
     * @param mmap
     * @return
     */
    @RequestMapping("/articleHot/{page}")
    String getArticleHotPage(@PathVariable(name = "page") int page,ModelMap mmap){
        List<ArticleLabelModel> articleLabelModelList = articleMapper.getArticleLabel();

        PageHelper.startPage(page,this.pageSize);
        List<ArticleModel> article = articleMapper.getArticleHot();

        mmap.put("mu","articleHot");
        mmap.put("article",article);
        mmap.put("article_label",articleLabelModelList);

        return "home/articleHot";
    }
}
