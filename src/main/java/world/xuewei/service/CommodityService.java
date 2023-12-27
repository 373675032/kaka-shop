package world.xuewei.service;

import world.xuewei.entity.Commodity;

import java.util.List;

/**
 * @author XUEW
 * @InterfaceName CommodityService
 * 商品【咖啡豆】表(Commodity)表业务接口
 * @date 2021-02-28 21:07:20
 * @Version 1.0
 **/
public interface CommodityService {

    /**
     * @param commodity 实例对象
     * @return 是否成功
     * 添加Commodity
     */
    boolean insert(Commodity commodity);

    /**
     * @param id 主键
     * @return 是否成功
     * 删除Commodity
     */
    boolean deleteById(Integer id);

    /**
     * @param id 主键
     * @return 实例对象
     * 查询单条数据
     */
    Commodity getById(Integer id);

    /**
     * @return 对象列表
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    List<Commodity> listCommoditys();

    /**
     * @param commodity 实例对象
     * @return 对象列表
     * 实体作为筛选条件查询数据
     */
    List<Commodity> listCommoditys(Commodity commodity);

    /**
     * @param keyWord 实例对象
     * @return 对象列表
     * 实体作为筛选条件查询数据
     */
    List<Commodity> listCommoditys(String keyWord);

    /**
     * @param commodity 实例对象
     * @return 结果数量
     * 实体作为筛选条件获取结果数量
     */
    int countCommoditys(Commodity commodity);

    /**
     * @param commodity 实例对象
     * @return 是否成功
     * 修改数据，哪个属性不为空就修改哪个属性
     */
    boolean update(Commodity commodity);

    /**
     * @return 对象列表
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    List<Commodity> listCommoditysOrderBySaleCount();
}