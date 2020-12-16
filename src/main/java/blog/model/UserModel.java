package blog.model;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-12-15 17:00:44
 */
public class UserModel implements Serializable {

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 授权id
     */
    private Integer openid;
    /**
     * 头像地址
     */
    private String avatarUrl;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 创建时间
     */
    private String createdAt;
    /**
     * 修改时间
     */
    private String updatedAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOpenid() {
        return openid;
    }

    public void setOpenid(Integer openid) {
        this.openid = openid;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", openid=" + openid +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}