package world.xuewei.mapper;

import org.apache.ibatis.annotations.Mapper;
import world.xuewei.entity.Cart;

import java.util.List;

/**
 * 购物车(Cart)表数据库访问层
 *
 * @author XUEW
 **/
@Mapper
public interface CartMapper {

    /**
     * @param cart 实例对象
     * @return 影响行数
     * 添加Cart
     */
    int insert(Cart cart);

    /**
     * @param id 主键
     * @return 影响行数
     * 删除Cart
     */
    int deleteById(Integer id);

    /**
     * @param id 主键
     * @return 实例对象
     * 查询单条数据
     */
    Cart getById(Integer id);

    /**
     * @return 对象列表
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    List<Cart> listCarts();

    /**
     * @param cart 实例对象
     * @return 对象列表
     * 实体作为筛选条件查询数据
     */
    List<Cart> listCarts(Cart cart);

    /**
     * @param cart 实例对象
     * @return 结果数量
     * 实体作为筛选条件获取结果数量
     */
    int countCarts(Cart cart);

    /**
     * @param cart
     * @return 影响行数
     * 修改Cart, 根据 cart 的主键修改数据
     */
    int update(Cart cart);

}