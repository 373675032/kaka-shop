package world.xuewei.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 商品表(Commodity)实体类
 *
 * @author XUEW
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Commodity implements Serializable {

    private static final long serialVersionUID = -94965477111737504L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品简介
     */
    private String info;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 颜色
     */
    private String color;

    /**
     * 原材料
     */
    private String material;

    /**
     * 产地
     */
    private String origin;

    /**
     * 商品分类ID
     */
    private Integer classifyId;
    private String classify;

    /**
     * 原价
     */
    private Double originalPrice;

    /**
     * 现价
     */
    private Double nowPrice;

    /**
     * 库存
     */
    private Integer inventory;

    /**
     * 上架时间
     */
    private Date publishTime;

    /**
     * 状态【1:上架】【0:下架】
     */
    private Integer status;

    /**
     * 商品图片地址
     */
    private String img;

    /**
     * 评价平均星星数
     */
    private Integer stars;

    /**
     * 商品折扣
     */
    private Double discount;

    /**
     * 销量
     */
    private Integer saleCount;

    /**
     * 收藏时间
     */
    private Date addTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return Objects.equals(id, commodity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}