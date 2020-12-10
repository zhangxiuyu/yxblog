package blog.model;

import java.io.Serializable;

/**
 * 文章分类表(ArticleType)实体类
 *
 * @author makejava
 * @since 2020-12-10 15:23:52
 */
public class ArticleTypeModel implements Serializable {
    private static final long serialVersionUID = 138369515409915949L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}