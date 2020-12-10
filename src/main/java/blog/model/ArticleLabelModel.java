package blog.model;

import java.io.Serializable;

/**
 * 文章标签表(ArticleLabel)实体类
 *
 * @author makejava
 * @since 2020-12-10 15:22:34
 */
public class ArticleLabelModel implements Serializable {
    private static final long serialVersionUID = -69536901963985195L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 名称
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