package world.xuewei.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import world.xuewei.entity.Collection;
import world.xuewei.entity.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 系统页面跳转控制器
 *
 * @author XUEW
 */
@Controller
public class SystemController extends BaseController {

    /**
     * 商城主页
     */
    @GetMapping("/index.html")
    public String indexPage(Map<String, Object> map) {
        Commodity param = Commodity.builder()
                .status(1)
                .build();
        // 获取最新上架的9件商品
        PageHelper.startPage(0, 9);
        List<Commodity> commodities9 = commodityService.listCommoditys(param);
        // 获取销量排名前10的商品
        PageHelper.startPage(0, 10);
        List<Commodity> commodities = commodityService.listCommoditysOrderBySaleCount();

        // 按照折扣排序
        commodities9 = commodities9.stream().sorted(Comparator.comparingDouble(Commodity::getDiscount)).collect(Collectors.toList());

        // 合并集合
        Set<Commodity> hashSet = new HashSet<>();
        hashSet.addAll(commodities);
        hashSet.addAll(commodities9);
        map.put("commodities9", commodities9);
        map.put("commodities", commodities);
        map.put("sumCommodities", hashSet);
        return "index";
    }

    /**
     * 全部商品
     */
    @GetMapping("/goods")
    public String goods(Map<String, Object> map) {
        List<Commodity> commodities = commodityService.listCommoditys();
        // 查询所有上架商品
        map.put("commodities", commodities);
        return "background/goods";
    }

    /**
     * 商品详情
     */
    @GetMapping("/product")
    public String product(@RequestParam("id") Integer id, String orderNumber, Map<String, Object> map) {
        // 获取指定商品
        Commodity commodity = commodityService.getById(id);
        if (ObjectUtil.isNotEmpty(loginUser)) {
            // 判断改商品是否被收藏
            world.xuewei.entity.Collection collection = world.xuewei.entity.Collection.builder().commodityId(id).userId(loginUser.getId()).build();
            List<world.xuewei.entity.Collection> collections = collectionService.listCollections(collection);
            if (ObjectUtil.isNotEmpty(collections)) {
                // 当前商品已被收藏，赋值收藏时间
                commodity.setAddTime(collections.get(0).getAddTime());
            }

        }

        CommodityComment param = CommodityComment.builder().commodityId(id).build();
        // 获取商品评价
        List<CommodityComment> comments = commodityCommentService.listCommodityComments(param);
        Integer commentCount = comments.size();
        // 过滤出一级评论
        comments = comments.stream()
                .filter(comment -> ObjectUtil.isNotEmpty(comment.getStars()))
                .collect(Collectors.toList());
        // 设置被回复的评论
        comments.forEach(comment -> {
            // 获取评论者的头像及用户名
            User user = userService.getById(comment.getUserId());
            comment.setUserImg(user.getImg());
            comment.setUserName(user.getName());
            // 获取回复此条留言的所以回复
            List<CommodityComment> replyComments = commodityCommentService.listCommodityComments(
                    CommodityComment.builder().replyId(comment.getId()).build()
            );
            // 获取回复的评论的头像
            replyComments.forEach(reply -> {
                User replyUser = userService.getById(reply.getUserId());
                reply.setUserImg(replyUser.getImg());
                reply.setUserName(replyUser.getName());
            });
            comment.setReplyComments(replyComments);
        });

        if (ObjectUtil.isNotEmpty(loginUser)) {
            // 获取订单信息
            Order order = Order.builder().orderNumber(orderNumber).userId(loginUser.getId()).status(2).build();
            if (orderService.countOrders(order) > 0) {
                map.put("orderNumber", orderNumber);
            }
        }
        map.put("commentCount", commentCount);
        map.put("commodity", commodity);
        map.put("comments", comments);
        return "front/product";
    }

    /**
     * 我的资料
     */
    @GetMapping("/profile")
    public String profile(Map<String, Object> map) {
        map.put("user", loginUser);
        return "front/profile";
    }

    /**
     * 我的地址
     */
    @GetMapping("/address")
    public String address(Map<String, Object> map) {
        // 获取当前登陆用户的所有地址
        Address param = Address.builder()
                .userId(loginUser.getId())
                .build();
        List<Address> addresses = addressService.listAddresss(param);
        map.put("addresses", addresses);
        return "front/address";
    }

    /**
     * 收藏夹
     */
    @GetMapping("/collection")
    public String collection(Map<String, Object> map) {
        // 获取我的收藏
        world.xuewei.entity.Collection param = world.xuewei.entity.Collection.builder()
                .userId(loginUser.getId())
                .build();
        List<world.xuewei.entity.Collection> collections = collectionService.listCollections(param);
        // 获取收藏的商品ID
        List<Integer> commodityIds = collections.stream()
                .map(world.xuewei.entity.Collection::getCommodityId)
                .collect(Collectors.toList());

        List<Commodity> commodities = new ArrayList<>();
        for (Integer commodityId : commodityIds) {
            Commodity commodity = commodityService.getById(commodityId);
            commodity.setAddTime(collections.stream().
                    filter(collection -> collection.getCommodityId().equals(commodity.getId()))
                    .findFirst()
                    .get()
                    .getAddTime());
            commodities.add(commodity);
        }

        map.put("commodities", commodities);
        return "front/collection";
    }

    /**
     * 商品列表
     */
    @GetMapping("/list")
    public String list(String keyWord, Integer classifyId, Map<String, Object> map) {
        List<Commodity> commodities = null;
        if (ObjectUtil.isNotEmpty(classifyId)) {
            Commodity param = Commodity.builder().classifyId(classifyId).build();
            commodities = commodityService.listCommoditys(param);
            map.put("classifyId", classifyId);
        } else if (ObjectUtil.isNotEmpty(keyWord)) {
            commodities = commodityService.listCommoditys(keyWord);
            map.put("keyWord", keyWord);
        } else {
            commodities = commodityService.listCommoditys();
        }
        if (ObjectUtil.isNotEmpty(loginUser)) {
            commodities.forEach(commodity -> {
                // 判断改商品是否被收藏
                world.xuewei.entity.Collection collection = world.xuewei.entity.Collection.builder().commodityId(commodity.getId()).userId(loginUser.getId()).build();
                List<Collection> collections = collectionService.listCollections(collection);
                if (ObjectUtil.isNotEmpty(collections)) {
                    // 当前商品已被收藏，赋值收藏时间
                    commodity.setAddTime(collections.get(0).getAddTime());
                }
            });
        }

        // 获取全部的分类
        List<Classify> classifies = classifyService.listClassifys();
        map.put("commodities", commodities);
        map.put("classifies", classifies);
        return "front/list";
    }

    /**
     * 发布商品
     */
    @GetMapping("/new-goods")
    public String newGoods(Map<String, Object> map) {
        // 获取全部的商品分类
        List<Classify> classifies = classifyService.listClassifys();

        map.put("classifies", classifies);
        return "background/new-goods";
    }

    /**
     * 编辑商品
     */
    @GetMapping("/edit-goods")
    public String editGoods(@RequestParam("id") Integer id, Map<String, Object> map) {
        // 通过ID获取商品
        Commodity commodity = commodityService.getById(id);
        // 获取全部的商品分类
        List<Classify> classifies = classifyService.listClassifys();

        map.put("classifies", classifies);
        map.put("commodity", commodity);
        return "background/edit-goods";
    }

    /**
     * 用户管理
     */
    @GetMapping("/user-manage")
    public String userManage(Map<String, Object> map) {
        List<User> users = userService.listUsers();

        map.put("users", users);
        return "background/user-manage";
    }

    /**
     * 商品分类管理
     */
    @GetMapping("/classify-manage")
    public String classifyManage(Map<String, Object> map) {
        // 获取全部的商品分类
        List<Classify> classifies = classifyService.listClassifys();

        map.put("classifies", classifies);
        return "background/classify-manage";
    }

    /**
     * 购物车
     */
    @GetMapping("/cart")
    public String cart(Map<String, Object> map) {
        // 查询我的购物车
        Cart param = Cart.builder().userId(loginUser.getId()).build();
        List<Cart> carts = cartService.listCarts(param);

        map.put("carts", carts);
        return "front/cart";
    }

    /**
     * 支付页面
     */
    @GetMapping("/pay")
    public String pay(@RequestParam("cartId") Integer cartId, Map<String, Object> map) {
        // 获取购物车信息
        Cart cart = cartService.getById(cartId);
        // 获取地址信息
        Address param = Address.builder().userId(loginUser.getId()).build();
        List<Address> addresses = addressService.listAddresss(param);

        map.put("cart", cart);
        map.put("addresses", addresses);
        return "front/pay";
    }

    /**
     * 待发货订单
     */
    @GetMapping("/wait-deliver")
    public String waitDeliver(Map<String, Object> map) {
        Order param = Order.builder().status(0).build();
        // 获取代发货订单
        List<Order> orders = orderService.listOrders(param);

        map.put("orders", dealOrder(orders));
        return "background/wait-deliver";
    }

    /**
     * 待收货订单
     */
    @GetMapping("/wait-take")
    public String waitTake(Map<String, Object> map) {
        Order param = Order.builder().status(1).build();
        // 获取代发货订单
        List<Order> orders = orderService.listOrders(param);

        map.put("orders", dealOrder(orders));
        return "background/wait-take";
    }

    /**
     * 已完成订单
     */
    @GetMapping("/finished-order")
    public String finishedOrder(Map<String, Object> map) {
        Order param = Order.builder().status(2).build();
        // 获取代发货订单
        List<Order> orders = orderService.listOrders(param);

        map.put("orders", dealOrder(orders));
        return "background/finished-order";
    }

    /**
     * 已取消订单
     */
    @GetMapping("/cancel-order")
    public String cancelOrder(Map<String, Object> map) {
        Order param = Order.builder().status(-1).build();
        // 获取已取消订单
        List<Order> orders = orderService.listOrders(param);

        map.put("orders", dealOrder(orders));
        return "background/cancel-order";
    }

    /**
     * 我的订单
     */
    @GetMapping("/my-order")
    public String myOrder(Integer status, Map<String, Object> map) {
        // 检查订单状态，默认查看未发货的订单
        status = ObjectUtil.isEmpty(status) ? 0 : status;

        Order param = Order.builder().userId(loginUser.getId()).status(status).build();
        // 获取已取消订单
        List<Order> orders = orderService.listOrders(param);

        map.put("status", status);
        map.put("orders", dealOrder(orders));
        return "front/my-order";
    }

    /**
     * 评论管理
     */
    @GetMapping("/comment-manage")
    public String commentManage(Map<String, Object> map) {
        // 获取商品评价
        List<CommodityComment> comments = commodityCommentService.listCommodityComments();
        // 过滤出一级评论
        comments = comments.stream()
                .filter(comment -> ObjectUtil.isNotEmpty(comment.getStars()))
                .collect(Collectors.toList());
        comments.forEach(comment -> {
            comment.setCommodity(commodityService.getById(comment.getCommodityId()));
            comment.setUserName(userService.getById(comment.getUserId()).getName());
        });
        map.put("comments", comments);
        return "background/comment-manage";
    }

    /**
     * 回复评论
     */
    @GetMapping("/comment-reply")
    public String commentReply(@RequestParam("id") Integer id, Map<String, Object> map) {
        // 获取被回复的评论
        CommodityComment commodityComment = commodityCommentService.getById(id);
        CommodityComment param = CommodityComment.builder().replyId(id).build();
        // 获取回复商品评价
        List<CommodityComment> comments = commodityCommentService.listCommodityComments(param);
        comments.forEach(comment -> {
            comment.setCommodity(commodityService.getById(comment.getCommodityId()));
            comment.setUserName(userService.getById(commodityComment.getUserId()).getName());
        });
        map.put("comments", comments);
        return "background/comment-reply";
    }

    /**
     * 处理订单信息
     */
    private List<Order> dealOrder(List<Order> orders) {
        // 处理订单信息
        orders.forEach(order -> {
            order.setUser(userService.getById(order.getUserId()));
            order.setCommodity(commodityService.getById(order.getCommodityId()));
            order.setAddress(addressService.getById(order.getAddressId()));
        });
        return orders;
    }
}
