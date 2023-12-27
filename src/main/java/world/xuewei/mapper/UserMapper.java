package world.xuewei.mapper;

import org.apache.ibatis.annotations.Mapper;
import world.xuewei.entity.User;

import java.util.List;

/**
 * 用户表(User)表数据库访问层
 *
 * @author XUEW
 **/
@Mapper
public interface UserMapper {

    /**
     * @param user 实例对象
     * @return 影响行数
     * 添加User
     */
    int insert(User user);

    /**
     * @param id 主键
     * @return 影响行数
     * 删除User
     */
    int deleteById(Integer id);

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
     * @param user
     * @return 影响行数
     * 修改User, 根据 user 的主键修改数据
     */
    int update(User user);

}