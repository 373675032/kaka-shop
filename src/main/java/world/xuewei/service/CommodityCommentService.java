package world.xuewei.service;

import world.xuewei.entity.CommodityComment;

import java.util.List;

/**
 * @author XUEW
 * @InterfaceName CommodityCommentService
 * 商品评价表(CommodityComment)表业务接口
 * @date 2021-02-28 21:07:21
 * @Version 1.0
 **/
public interface CommodityCommentService {

    /**
     * @param commodityComment 实例对象
     * @return 是否成功
     * 添加CommodityComment
     */
    boolean insert(CommodityComment commodityComment);

    /**
     * @param id 主键
     * @return 是否成功
     * 删除CommodityComment
     */
    boolean deleteById(Integer id);

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
     * @param commodityComment 实例对象
     * @return 是否成功
     * 修改数据，哪个属性不为空就修改哪个属性
     */
    boolean update(CommodityComment commodityComment);

    /**
     * 获取商品的平均星星数
     */
    Double getAvgStar(Integer commodityId);
}