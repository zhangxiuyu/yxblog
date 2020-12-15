package blog.mapper;

import blog.model.ArticleLabelModel;
import blog.model.ArticleModel;
import blog.model.ArticleTypeModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ArticleMapper {


    // 获取首页文章列表
    @Select("SELECT * FROM article WHERE top = 1 and state =1 order by sort  DESC")
    List<ArticleModel> getTopArticle();

    // 获取文章标签表
    @Select("select * from article_label")
    List<ArticleLabelModel> getArticleLabel();

    // 获取标签的文章
    @Select("select * from article where id in(select article_id from article_on_label where label_id = ${label_id}) and state =1  order by sort  DESC")
    List<ArticleModel> getArticleOnLabel(int label_id);


    // 获取文章分类表
    @Select("select * from article_type")
    List<ArticleTypeModel> getArticType();

    // 获取分类的文章
    @Select("select * from article where id in(select article_id from article_on_type where type_id = ${type_id}) and state =1  order by sort  DESC")
    List<ArticleModel> getArticleOnType(int type_id);

    // 获取文章详情
    @Select("select * from article where id = ${id} and state =1")
    List<ArticleModel> getArticleOne(String id);

    // 获取文章列表
    @Select("select * from article where state =1 order by sort DESC")
    List<ArticleModel> getArticle();

    // 根据浏览量排序
    @Select("select * from article where state = 1 order by show_num DESC")
    List<ArticleModel> getArticleHot();

    // 浏览量
    @Update("update article set show_num = show_num+1 where id = ${id}")
    void addArticleOne(String id);

    // 分页
    @Select("select * from article where state = 1 order by show_num DESC  limit ${count},${pagesize}")
    List<ArticleModel> getArticlePage(int count,
                                      int pagesize);
    // 总数量
    @Select("select count(*) from article where state = 1")
    int findCount();



}
