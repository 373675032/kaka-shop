package world.xuewei.service;

import world.xuewei.entity.Cart;

import java.util.List;

/**
 * @author XUEW
 * @InterfaceName CartService
 * 购物车(Cart)表业务接口
 * @date 2021-02-28 21:07:18
 * @Version 1.0
 **/
public interface CartService {

    /**
     * @param cart 实例对象
     * @return 是否成功
     * 添加Cart
     */
    boolean insert(Cart cart);

    /**
     * @param id 主键
     * @return 是否成功
     * 删除Cart
     */
    boolean deleteById(Integer id);

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
     * @param cart 实例对象
     * @return 是否成功
     * 修改数据，哪个属性不为空就修改哪个属性
     */
    boolean update(Cart cart);

}