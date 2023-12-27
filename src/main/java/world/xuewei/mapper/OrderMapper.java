package world.xuewei.mapper;

import org.apache.ibatis.annotations.Mapper;
import world.xuewei.entity.Order;

import java.util.List;

/**
 * 订单表(Order)表数据库访问层
 *
 * @author XUEW
 **/
@Mapper
public interface OrderMapper {

    /**
     * @param order 实例对象
     * @return 影响行数
     * 添加Order
     */
    int insert(Order order);

    /**
     * @param id 主键
     * @return 影响行数
     * 删除Order
     */
    int deleteById(Integer id);

    /**
     * @param id 主键
     * @return 实例对象
     * 查询单条数据
     */
    Order getById(Integer id);

    /**
     * @return 对象列表
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    List<Order> listOrders();

    /**
     * @param order 实例对象
     * @return 对象列表
     * 实体作为筛选条件查询数据
     */
    List<Order> listOrders(Order order);

    /**
     * @param order 实例对象
     * @return 结果数量
     * 实体作为筛选条件获取结果数量
     */
    int countOrders(Order order);

    /**
     * @param order
     * @return 影响行数
     * 修改Order, 根据 order 的主键修改数据
     */
    int update(Order order);

}