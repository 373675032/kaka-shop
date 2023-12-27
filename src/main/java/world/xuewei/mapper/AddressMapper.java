package world.xuewei.mapper;

import org.apache.ibatis.annotations.Mapper;
import world.xuewei.entity.Address;

import java.util.List;

/**
 * 收货地址(Address)表数据库访问层
 *
 * @author XUEW
 **/
@Mapper
public interface AddressMapper {

    /**
     * @param address 实例对象
     * @return 影响行数
     * 添加Address
     */
    int insert(Address address);

    /**
     * @param id 主键
     * @return 影响行数
     * 删除Address
     */
    int deleteById(Integer id);

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
     * @param address
     * @return 影响行数
     * 修改Address, 根据 address 的主键修改数据
     */
    int update(Address address);

}
