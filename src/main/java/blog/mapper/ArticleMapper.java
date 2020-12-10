package blog.mapper;

import blog.model.ArticleLabelModel;
import blog.model.ArticleModel;
import blog.model.ArticleTypeModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {


    // 获取首页文章列表
    @Select("SELECT * FROM article WHERE top = 1")
    List<ArticleModel> getTopArticle();

    // 获取文章标签表
    @Select("select * from article_label")
    List<ArticleLabelModel> getArticleLabel();

    // 获取标签的文章
    @Select("select * from article where id in(select article_id from article_label where id)")
    List<ArticleModel> getArticleOnLabel();


    // 获取文章分类表
    @Select("select * from article_type")
    List<ArticleTypeModel> getArticType();

    // 获取分类的文章
    @Select("select * from article where id in(select article_id from article_type where id)")
    List<ArticleModel> getArticleOnType();

}
