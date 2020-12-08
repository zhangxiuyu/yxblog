package blog.entity;

import blog.domain.BaseEntity;

import java.util.Date;

/**
 * (Article)实体类
 *
 * @author makejava
 * @since 2020-12-08 11:26:32
 */
public class Article extends BaseEntity {
    /**
     * 文章id
     */
    private Integer id;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章简介
     */
    private String brief;
    /**
     * 文章内容
     */
    private String con;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 更新时间
     */
    private Date updatedAt;
    /**
     * 是否置顶 1 置顶 0 不置顶
     */
    private Object top;
    /**
     * 状态 1正常 0下架
     */
    private Object state;

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

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getTop() {
        return top;
    }

    public void setTop(Object top) {
        this.top = top;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }
}