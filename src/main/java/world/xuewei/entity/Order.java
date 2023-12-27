package world.xuewei.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单表(Order)实体类
 *
 * @author XUEW
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order implements Serializable {

    private static final long serialVersionUID = 408410776475784096L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 订单号
     */
    private String orderNumber;

    /**
     * 用户ID
     */
    private Integer userId;
    private User user;

    /**
     * 商品ID
     */
    private Integer commodityId;
    private Commodity commodity;

    /**
     * 订单记录
     */
    private String content;

    /**
     * 快递单号
     */
    private String courierNumber;

    /**
     * 快递公司
     */
    private String courierName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 付款时间
     */
    private Date payTime;

    /**
     * 发货时间
     */
    private Date sippingTime;

    /**
     * 成交时间
     */
    private Date successTime;

    /**
     * 订单状态【-1:取消】【0:等待发货】【1:已发货】【2:已完成】
     */
    private Integer status;

    /**
     * 地址Id
     */
    private Integer addressId;
    private Address address;

}