package world.xuewei.service.impl;

import org.springframework.stereotype.Service;
import world.xuewei.entity.Order;
import world.xuewei.service.BaseService;
import world.xuewei.service.OrderService;

import java.util.List;

/**
 * @author XUEW
 * @ClassName OrderServiceImpl
 * 订单表(Order)表业务接口实现类
 * @date 2021-02-28 21:07:21
 * @Version 1.0
 **/
@Service("orderService")
public class OrderServiceImpl extends BaseService implements OrderService {

    @Override
    public boolean insert(Order order) {
        return orderMapper.insert(order) == 1;
    }

    @Override
    public boolean deleteById(Integer id) {
        return orderMapper.deleteById(id) == 1;
    }

    @Override
    public Order getById(Integer id) {
        return orderMapper.getById(id);
    }

    @Override
    public List<Order> listOrders() {
        return orderMapper.listOrders();
    }

    @Override
    public List<Order> listOrders(Order order) {
        return orderMapper.listOrders(order);
    }

    @Override
    public int countOrders(Order order) {
        return orderMapper.countOrders(order);
    }

    @Override
    public boolean update(Order order) {
        return orderMapper.update(order) == 1;
    }

}