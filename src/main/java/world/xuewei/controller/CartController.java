package world.xuewei.controller;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import world.xuewei.dto.ResponseResult;
import world.xuewei.entity.Cart;

import java.util.Date;
import java.util.List;

/**
 * 购物车控制器
 *
 * @author XUEW
 */
@RestController
public class CartController extends BaseController {

    /**
     * 加入购物车
     */
    @PostMapping("/addCart")
    public ResponseResult addCart(@RequestParam("commodityId") Integer commodityId, Integer count) {
        if (ObjectUtil.isEmpty(loginUser)) {
            result.setCode(500);
            result.setMessage("请先登录系统");
            return result;
        }
        // 检查数量
        count = ObjectUtil.isEmpty(count) ? 1 : count;
        // 判断当前用户是否已经收藏了这件商品
        Cart param = Cart.builder().userId(loginUser.getId()).commodityId(commodityId).build();
        List<Cart> carts = cartService.listCarts(param);
        if (ObjectUtil.isNotEmpty(carts)) {
            // 获取当前的收藏信息
            Cart cart = carts.get(0);
            cart.setCount(cart.getCount() + count);
            cart.setAddTime(new Date());
            if (cartService.update(cart)) {
                result.setMessage("添加购物车成功");
                result.setCode(200);
            }
        } else {
            param.setCount(count);
            param.setAddTime(new Date());
            if (cartService.insert(param)) {
                result.setCode(200);
                result.setMessage("添加购物车成功");
            } else {
                result.setCode(500);
                result.setMessage("服务器出错");
            }
        }
        return result;
    }

    /**
     * 删除购物车
     */
    @PostMapping("/deleteCart")
    public ResponseResult deleteCart(@RequestParam("id") Integer id) {
        // 删除
        if (cartService.deleteById(id)) {
            result.setCode(200);
            result.setMessage("删除购物车成功");
        } else {
            result.setCode(500);
            result.setMessage("服务器出错");
        }
        return result;
    }

    /**
     * 修改购物车的数量
     */
    @PostMapping("/changeCartCount")
    public ResponseResult changeCartCount(@RequestParam("id") Integer id, @RequestParam("count") Integer count) {
        Cart cart = cartService.getById(id);
        cart.setCount(count);
        if (cartService.update(cart)) {
            result.setMessage("更新数量成功");
            result.setCode(200);
        } else {
            result.setCode(500);
            result.setMessage("服务器出错");
        }
        return result;
    }
}
