package world.xuewei.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import world.xuewei.dto.ResponseResult;
import world.xuewei.entity.User;

import java.io.IOException;
import java.util.Date;

/**
 * 用户控制器
 *
 * @author XUEW
 */
@RestController
public class UserController extends BaseController {

    /**
     * 上传头像
     */
    @PostMapping("/uploadAvatar")
    public ResponseResult uploadAvatar(@RequestParam("avatar") MultipartFile file) throws IOException {
        String url = ossClient.upload(file, String.valueOf(loginUser.getId()));
        loginUser.setImg(url);
        if (userService.update(loginUser)) {
            result.setCode(200);
            result.setData(url);
            result.setMessage("上传成功");
        } else {
            result.setCode(500);
            result.setMessage("上传失败");
        }
        return result;
    }

    /**
     * 修改用户资料
     */
    @PostMapping("/updateProfile")
    public ResponseResult updateProfile(String username, String info, String email) {
        // 更新了邮箱并且邮箱已被占用
        if (!loginUser.getEmail().equals(email) && userService.isExistEmail(email)) {
            result.setCode(500);
            result.setMessage("当前邮箱已经被占用，请更换邮箱..");
        } else {
            loginUser.setName(username);
            loginUser.setInfo(info);
            loginUser.setEmail(email);
            if (userService.update(loginUser)) {
                result.setCode(200);
                result.setMessage("更新资料成功");
            } else {
                result.setCode(500);
                result.setMessage("服务器出错");
            }
        }
        return result;
    }

    /**
     * 修改用户资料
     */
    @PostMapping("/updateUserInfo")
    public ResponseResult updateUserInfo(Integer id, String name, String info, String email, String password) {
        User user = userService.getById(id);
        // 更新了邮箱并且邮箱已被占用
        if (!user.getEmail().equals(email) && userService.isExistEmail(email)) {
            result.setCode(500);
            result.setMessage("当前邮箱已经被占用，请更换邮箱..");
        } else {
            user.setName(name);
            user.setPassword(password);
            user.setInfo(info);
            user.setEmail(email);
            user.setUpdateTime(new Date());
            if (userService.update(user)) {
                result.setCode(200);
                result.setMessage("更新资料成功");
            } else {
                result.setCode(500);
                result.setMessage("服务器出错");
            }
        }
        return result;
    }

    /**
     * 修改密码
     */
    @PostMapping("/updatePassword")
    public ResponseResult updatePassword(String newPassword, String oldPassword) {
        // 判断旧密码是否正确
        if (!loginUser.getPassword().equals(oldPassword)) {
            result.setCode(500);
            result.setMessage("旧密码错误");
        } else {
            loginUser.setPassword(newPassword);
            if (userService.update(loginUser)) {
                result.setCode(200);
                result.setMessage("更新密码成功");
            } else {
                result.setCode(500);
                result.setMessage("服务器出错");
            }
        }
        return result;
    }

    /**
     * 忘记密码
     */
    @PostMapping("/forgetPassword")
    public ResponseResult forgetPassword(String email) {
        // 判断邮箱是否存在
        if (!userService.isExistEmail(email)) {
            result.setCode(404);
            result.setMessage("邮箱尚未注册");
        } else {
            User user = userService.getByEmail(email);
            // 实例化邮件工具类
            // 发送邮件
            mailClient.sendEmail(email, user.getPassword());
            result.setCode(200);
            result.setMessage("发送邮件成功，请注意查收..");
        }
        return result;
    }

    /**
     * 更改用户角色
     */
    @PostMapping("/changeRole")
    public ResponseResult changeRole(@RequestParam("id") Integer id) {
        User user = userService.getById(id);

        user.setRole((user.getRole() + 1) % 2);
        if (userService.update(user)) {
            result.setCode(200);
            result.setMessage("修改成功");
        } else {
            result.setCode(500);
            result.setMessage("服务器出错");
        }
        return result;
    }

}
