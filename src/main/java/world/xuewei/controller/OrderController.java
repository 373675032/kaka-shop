package world.xuewei.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import world.xuewei.dto.ResponseResult;
import world.xuewei.entity.Cart;
import world.xuewei.entity.Commodity;
import world.xuewei.entity.Order;

import java.util.Date;

/**
 * 订单控制器
 *
 * @author XUEW
 */
@RestController
public class OrderController extends BaseController {

    /**
     * 购买商品
     */
    @PostMapping("/buyCommodity")
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult buyCommodity(@RequestParam("cartId") Integer cartId, Integer addressId) {
        // 获取购物车信息
        Cart cart = cartService.getById(cartId);
        Commodity commodity = cart.getCommodity();
        if (commodity.getInventory() < cart.getCount()) {
            result.setCode(500);
            result.setMessage("库存不足，购买失败");
        } else {
            // 更新库存
            commodity.setInventory(commodity.getInventory() - cart.getCount());
            // 更新销售量
            commodity.setSaleCount(commodity.getSaleCount() + cart.getCount());
            if (commodityService.update(commodity)) {
                // 减库存成功，生成订单
                Order order = Order.builder()
                        .userId(loginUser.getId())
                        .commodityId(commodity.getId())
                        .orderNumber(System.currentTimeMillis() + "")
                        .content(commodity.getClassify() + "-" + commodity.getName() + "*" + cart.getCount())
                        .createTime(new Date())
                        .payTime(new Date())
                        .status(0)
                        .addressId(addressId)
                        .build();
                if (orderService.insert(order)) {
                    // 订单生成成功，删除购物车
                    if (cartService.deleteById(cartId)) {
                        result.setCode(200);
                        result.setMessage("购买成功，等待发货 ...");
                    } else {
                        result.setCode(500);
                        result.setMessage("服务器出错");
                    }
                } else {
                    result.setCode(500);
                    result.setMessage("服务器出错");
                }
            } else {
                result.setCode(500);
                result.setMessage("服务器出错");
            }
        }
        return result;
    }

    /**
     * 发货
     */
    @PostMapping("/deliverGoods")
    public ResponseResult deliverGoods(@RequestParam("id") Integer id, String courierNumber, String courierName) {
        // 获取订单信息
        Order order = orderService.getById(id);
        order.setCourierNumber(courierNumber);
        order.setCourierName(courierName);
        order.setSippingTime(new Date());
        order.setStatus(1);
        // 更新订单信息
        if (orderService.update(order)) {
            result.setCode(200);
            result.setMessage("发货成功");
        } else {
            result.setCode(500);
            result.setMessage("服务器出错");
        }
        return result;
    }

    /**
     * 取消订单
     */
    @PostMapping("/cancelOrder")
    public ResponseResult cancelOrder(Integer id) {
        Order param = Order.builder().id(id).status(-1).build();
        if (orderService.update(param)) {
            result.setCode(200);
            result.setMessage("取消订单成功");
        } else {
            result.setCode(500);
            result.setMessage("服务器出错");
        }
        return result;
    }

    /**
     * 确认收货
     */
    @PostMapping("/confirmOrder")
    public ResponseResult confirmOrder(Integer id) {
        Order param = Order.builder().id(id).status(2).successTime(new Date()).build();
        if (orderService.update(param)) {
            result.setCode(200);
            result.setMessage("确认收货成功");
        } else {
            result.setCode(500);
            result.setMessage("服务器出错");
        }
        return result;
    }

    /**
     * 删除订单
     */
    @PostMapping("/deleteOrder")
    public ResponseResult deleteOrder(Integer id) {
        if (orderService.deleteById(id)) {
            result.setCode(200);
            result.setMessage("删除订单成功");
        } else {
            result.setCode(500);
            result.setMessage("服务器出错");
        }
        return result;
    }


}