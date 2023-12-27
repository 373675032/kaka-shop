package world.xuewei.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import world.xuewei.entity.CommodityComment;
import world.xuewei.entity.Order;
import world.xuewei.entity.User;
import world.xuewei.mapper.UserMapper;
import world.xuewei.service.BaseService;
import world.xuewei.service.UserService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author XUEW
 * @ClassName UserServiceImpl
 * 用户表(User)表业务接口实现类
 * @date 2021-03-13 16:14:04
 * @Version 1.0
 **/
@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {

    @Resource
    private UserMapper userMapper;

    @Value("${default-avatar}")
    private String defaultAvatar;

    @Override
    public boolean insert(User user) {
        return userMapper.insert(user) == 1;
    }

    @Override
    public boolean insert(String name, String password, String email) {
        User user = User.builder()
                .name(name).password(password).email(email).role(0)
                .img(defaultAvatar)
                .registerTime(new Date())
                .info("-")
                .build();
        return insert(user);
    }

    @Override
    public boolean deleteById(Integer id) {
        return userMapper.deleteById(id) == 1;
    }

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public User getByEmail(String email) {
        return userMapper.getByEmail(email);
    }

    @Override
    public List<User> listUsers() {
        List<User> users = userMapper.listUsers();
        // 处理数据
        users.forEach(user -> {
            // 设置下单数量
            Order param = Order.builder().userId(user.getId()).build();
            user.setOrderCount(orderMapper.countOrders(param));
            // 设置评论数量
            CommodityComment comment = CommodityComment.builder().userId(user.getId()).build();
            user.setCommentCount(commodityCommentMapper.countCommodityComments(comment));
        });
        return users;
    }

    @Override
    public List<User> listUsers(User user) {
        List<User> users = userMapper.listUsers(user);
        // 处理数据
        users.forEach(temp -> {
            // 设置下单数量
            Order param = Order.builder().userId(temp.getId()).build();
            temp.setOrderCount(orderMapper.countOrders(param));
            // 设置评论数量
            CommodityComment comment = CommodityComment.builder().userId(temp.getId()).build();
            temp.setCommentCount(commodityCommentMapper.countCommodityComments(comment));
        });
        return users;
    }

    @Override
    public int countUsers(User user) {
        return userMapper.countUsers(user);
    }

    @Override
    public boolean update(User user) {
        user.setUpdateTime(new Date());
        return userMapper.update(user) == 1;
    }

    @Override
    public boolean isExistEmail(String email) {
        User search = User.builder().email(email).build();
        List<User> users = userMapper.listUsers(search);
        return users.size() > 0;
    }

    @Override
    public boolean isExistEmail(String email, Integer userId) {
        return false;
    }

}