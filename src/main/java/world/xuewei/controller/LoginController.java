package world.xuewei.controller;

import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import world.xuewei.dto.ResponseResult;
import world.xuewei.entity.User;

import java.util.List;

/**
 * 用户登陆注册控制器
 *
 * @author XUEW
 */
@Slf4j
@Controller
public class LoginController extends BaseController {

    /**
     * 用户登陆
     */
    @PostMapping("/login")
    @ResponseBody
    public ResponseResult login(String email, String password) {
        log.info("请求登陆：email = " + email + ", password = " + password);
        // 查询用户
        User search = User.builder().email(email).password(password).build();
        List<User> users = userService.listUsers(search);
        if (ObjectUtil.isEmpty(users)) {
            // 根据邮箱和密码没有查询到用户，只根据邮箱查询
            search.setPassword(null);
            users = userService.listUsers(search);
            if (ObjectUtil.isEmpty(users)) {
                // 用户未注册
                result.setCode(404);
                result.setMessage("当前邮箱未进行注册");
            } else {
                result.setCode(500);
                result.setMessage("密码错误，请重试..");
            }
        } else {
            // 查询到用户，将用户信息放入session
            session.setAttribute("loginUser", users.get(0));
            // 登陆成功
            result.setCode(200);
            result.setMessage("登陆成功");
        }
        return result;
    }

    /**
     * 用户注册
     */
    @PostMapping("/register")
    @ResponseBody
    public ResponseResult register(String username, String password, String email) {
        // 查询邮箱是否已被注册
        if (userService.isExistEmail(email)) {
            result.setCode(500);
            result.setMessage("当前邮箱已经被占用，请更换邮箱注册..");
        } else {
            // 添加到数据库
            if (userService.insert(username, password, email)) {
                result.setCode(200);
                result.setMessage("注册成功");
            } else {
                result.setCode(500);
                result.setMessage("服务器出错");
            }
        }
        return result;
    }

    /**
     * 退出登陆
     */
    @GetMapping("/logout")
    public String logout() {
        log.info("退出登陆：" + loginUser);
        // 清空session
        session.invalidate();
        return "redirect:/index.html";
    }

}
