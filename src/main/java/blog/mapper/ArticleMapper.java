package blog.mapper;

import blog.model.ArticleModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {


    @Select("SELECT * FROM article WHERE top = 1")
    List<ArticleModel> getTopArticle();
}
