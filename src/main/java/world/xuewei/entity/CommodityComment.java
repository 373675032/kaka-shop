package world.xuewei.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品评价表(CommodityComment)实体类
 *
 * @author XUEW
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommodityComment implements Serializable {

    private static final long serialVersionUID = -92193160791514971L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userImg;

    /**
     * 商品ID
     */
    private Integer commodityId;
    private Commodity commodity;

    /**
     * 评星数【1-5】
     */
    private Integer stars;

    /**
     * 评价
     */
    private String comment;

    /**
     * 评价时间
     */
    private Date commentTime;

    /**
     * 回复评论的ID
     */
    private Integer replyId;

    /**
     * 回复的评价
     */
    private List<CommodityComment> replyComments;

}