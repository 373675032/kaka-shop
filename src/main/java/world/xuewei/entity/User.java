package world.xuewei.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表(User)实体类
 *
 * @author XUEW
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 463829696564879359L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 头像地址
     */
    private String img;

    /**
     * 个人说明
     */
    private String info;

    /**
     * 注册时间
     */
    private Date registerTime;

    /**
     * 角色
     */
    private Integer role;

    /**
     * 最新更新
     */
    private Date updateTime;

    /**
     * 下单数
     */
    private int orderCount;

    /**
     * 评论数
     */
    private int commentCount;

}