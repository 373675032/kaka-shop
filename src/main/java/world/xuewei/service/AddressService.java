package world.xuewei.service;

import world.xuewei.entity.Address;

import java.util.List;

/**
 * @author XUEW
 * @InterfaceName AddressService
 * 收货地址(Address)表业务接口
 * @date 2021-04-26 10:25:26
 * @Version 1.0
 **/
public interface AddressService {

    /**
     * @param address 实例对象
     * @return 是否成功
     * 添加Address
     */
    boolean insert(Address address);

    /**
     * @param id 主键
     * @return 是否成功
     * 删除Address
     */
    boolean deleteById(Integer id);

    /**
     * @param id 主键
     * @return 实例对象
     * 查询单条数据
     */
    Address getById(Integer id);

    /**
     * @return 对象列表
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    List<Address> listAddresss();

    /**
     * @param address 实例对象
     * @return 对象列表
     * 实体作为筛选条件查询数据
     */
    List<Address> listAddresss(Address address);

    /**
     * @param address 实例对象
     * @return 结果数量
     * 实体作为筛选条件获取结果数量
     */
    int countAddresss(Address address);

    /**
     * @param address 实例对象
     * @return 是否成功
     * 修改数据，哪个属性不为空就修改哪个属性
     */
    boolean update(Address address);

}
