package world.xuewei.service;

import world.xuewei.entity.User;

import java.util.List;

/**
 * @author XUEW
 * @InterfaceName UserService
 * 用户表(User)表业务接口
 * @date 2021-03-13 16:14:04
 * @Version 1.0
 **/
public interface UserService {

    /**
     * @param user 实例对象
     * @return 是否成功
     * 添加User
     */
    boolean insert(User user);

    /**
     * @return 是否成功
     * 添加User
     */
    boolean insert(String name, String password, String email);

    /**
     * @param id 主键
     * @return 是否成功
     * 删除User
     */
    boolean deleteById(Integer id);

    /**
     * @param id 主键
     * @return 实例对象
     * 查询单条数据
     */
    User getById(Integer id);

    /**
     * 通过邮箱查询用户
     */
    User getByEmail(String email);

    /**
     * @return 对象列表
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    List<User> listUsers();

    /**
     * @param user 实例对象
     * @return 对象列表
     * 实体作为筛选条件查询数据
     */
    List<User> listUsers(User user);

    /**
     * @param user 实例对象
     * @return 结果数量
     * 实体作为筛选条件获取结果数量
     */
    int countUsers(User user);

    /**
     * @param user 实例对象
     * @return 是否成功
     * 修改数据，哪个属性不为空就修改哪个属性
     */
    boolean update(User user);

    /**
     * 邮箱是否已存在
     */
    boolean isExistEmail(String email);

    /**
     * 邮箱是否已存在
     */
    boolean isExistEmail(String email, Integer userId);
}