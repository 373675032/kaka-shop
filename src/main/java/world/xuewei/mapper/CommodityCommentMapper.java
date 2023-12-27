package world.xuewei.mapper;

import org.apache.ibatis.annotations.Mapper;
import world.xuewei.entity.CommodityComment;

import java.util.List;

/**
 * 商品评价表(CommodityComment)表数据库访问层
 *
 * @author XUEW
 **/
@Mapper
public interface CommodityCommentMapper {

    /**
     * @param commodityComment 实例对象
     * @return 影响行数
     * 添加CommodityComment
     */
    int insert(CommodityComment commodityComment);

    /**
     * @param id 主键
     * @return 影响行数
     * 删除CommodityComment
     */
    int deleteById(Integer id);

    /**
     * @param id 主键
     * @return 实例对象
     * 查询单条数据
     */
    CommodityComment getById(Integer id);

    /**
     * @return 对象列表
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    List<CommodityComment> listCommodityComments();

    /**
     * @param commodityComment 实例对象
     * @return 对象列表
     * 实体作为筛选条件查询数据
     */
    List<CommodityComment> listCommodityComments(CommodityComment commodityComment);

    /**
     * @param commodityComment 实例对象
     * @return 结果数量
     * 实体作为筛选条件获取结果数量
     */
    int countCommodityComments(CommodityComment commodityComment);

    /**
     * @param commodityComment
     * @return 影响行数
     * 修改CommodityComment, 根据 commodityComment 的主键修改数据
     */
    int update(CommodityComment commodityComment);

    /**
     * 获取商品的平均星星数
     */
    Double getAvgStar(Integer commodityId);
}