package world.xuewei.controller;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;
import world.xuewei.component.MailClient;
import world.xuewei.component.OssClient;
import world.xuewei.dto.ResponseResult;
import world.xuewei.entity.Cart;
import world.xuewei.entity.Order;
import world.xuewei.entity.User;
import world.xuewei.service.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 基础控制器
 *
 * @author XUEW
 */
public class BaseController {

    /**
     * 注入所有的业务逻辑操作类
     */
    @Autowired
    protected AddressService addressService;
    @Autowired
    protected ClassifyService classifyService;
    @Autowired
    protected CartService cartService;
    @Autowired
    protected CollectionService collectionService;
    @Autowired
    protected CommodityCommentService commodityCommentService;
    @Autowired
    protected CommodityService commodityService;
    @Autowired
    protected OrderService orderService;
    @Autowired
    protected UserService userService;
    @Autowired
    protected OssClient ossClient;

    /**
     * 注入Http对象
     */
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    /**
     * 当前登陆对象
     */
    protected User loginUser;

    /**
     * 响应结果对象
     */
    protected ResponseResult result;

    /**
     * 邮件对象
     */
    @Resource
    protected MailClient mailClient;

    /**
     * 邮件发送方
     */
    @Value("${spring.mail.username}")
    protected String fromEmail;

    /**
     * 在每个子类方法调用之前先调用，设置request,response,session这三个对象
     */
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession(true);
        loginUser = (User) session.getAttribute("loginUser");
        result = new ResponseResult();

        // 获取购物车的总价格
        if (ObjectUtil.isNotEmpty(loginUser)) {
            setCartRmb();
            if (loginUser.getRole() == 1) {
                // 管理员统计订单数量
                countOrder();
            }
        }
    }

    /**
     * 获取购物车的总价格
     */
    public void setCartRmb() {
        // 获取购物车的总价格
        Cart cart = Cart.builder().userId(loginUser.getId()).build();
        List<Cart> carts = cartService.listCarts(cart);
        carts.forEach(cartIndex -> {
            cartIndex.setCommodity(commodityService.getById(cartIndex.getCommodityId()));
        });
        double cartRmb = 0;
        for (Cart temp : carts) {
            cartRmb += temp.getCount() * temp.getCommodity().getNowPrice();
        }
        session.setAttribute("cartRmb", cartRmb);
    }

    /**
     * 查询各个订单的数量
     */
    public void countOrder() {
        // 获取待发货的订单
        Order order = Order.builder().status(0).build();
        int waitDeliver = orderService.countOrders(order);
        // 获取已取消的订单
        order.setStatus(-1);
        int cancelOrder = orderService.countOrders(order);
        session.setAttribute("waitDeliver", waitDeliver);
        session.setAttribute("cancelOrder", cancelOrder);
    }
}