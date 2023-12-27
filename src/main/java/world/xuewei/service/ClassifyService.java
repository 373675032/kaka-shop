package world.xuewei.service;

import world.xuewei.entity.Classify;

import java.util.List;

/**
 * @author XUEW
 * @InterfaceName ClassifyService
 * 归类(Classify)表业务接口
 * @date 2021-02-28 21:07:19
 * @Version 1.0
 **/
public interface ClassifyService {

    /**
     * @param classify 实例对象
     * @return 是否成功
     * 添加Classify
     */
    boolean insert(Classify classify);

    /**
     * @param id 主键
     * @return 是否成功
     * 删除Classify
     */
    boolean deleteById(Integer id);

    /**
     * @param id 主键
     * @return 实例对象
     * 查询单条数据
     */
    Classify getById(Integer id);

    /**
     * @return 对象列表
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    List<Classify> listClassifys();

    /**
     * @param classify 实例对象
     * @return 对象列表
     * 实体作为筛选条件查询数据
     */
    List<Classify> listClassifys(Classify classify);

    /**
     * @param classify 实例对象
     * @return 结果数量
     * 实体作为筛选条件获取结果数量
     */
    int countClassifys(Classify classify);

    /**
     * @param classify 实例对象
     * @return 是否成功
     * 修改数据，哪个属性不为空就修改哪个属性
     */
    boolean update(Classify classify);

}