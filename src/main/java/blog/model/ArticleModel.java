package blog.model;

import blog.domain.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * (Article)实体类
 *
 * @author makejava
 * @since 2020-12-08 11:26:32
 */
public class ArticleModel extends BaseModel {
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date created_at;
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updated_at;
    /**
     * 是否置顶 1 置顶 0 不置顶
     */
    private Object top;
    /**
     * 状态 1正常 0下架
     */
    private Object state;

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }


    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Object getShow_num() {
        return show_num;
    }

    public void setShow_num(Object show_num) {
        this.show_num = show_num;
    }

    /**
     *
     * 观看数量
     */
    private Object show_num;



    public Object getShowNum() {
        return show_num;
    }

    public void setShowNum(Object showNum) {
        this.show_num = showNum;
    }



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
        return created_at;
    }

    public void setCreatedAt(Date createdAt) {
        this.created_at = createdAt;
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


    @Override
    public String toString() {
        return "ArticleModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", con='" + con + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", top=" + top +
                ", state=" + state +
                ", show_num=" + show_num +
                '}';
    }
}