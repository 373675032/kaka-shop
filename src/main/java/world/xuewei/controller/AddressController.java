package world.xuewei.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import world.xuewei.dto.ResponseResult;
import world.xuewei.entity.Address;

import java.util.List;

/**
 * 地址控制器
 *
 * @author XUEW
 */
@RestController
public class AddressController extends BaseController {

    /**
     * 添加收货地址
     */
    @PostMapping("/addAddress")
    public ResponseResult addAddress(Address address) {
        address.setUserId(loginUser.getId());
        address.setIsDefault(0);
        if (addressService.insert(address)) {
            result.setCode(200);
            result.setMessage("添加地址成功");
        } else {
            result.setCode(500);
            result.setMessage("服务器出错");
        }
        return result;
    }

    /**
     * 删除地址
     */
    @PostMapping("/deleteAddress")
    public ResponseResult deleteAddress(Integer id) {
        // 删除地址
        if (addressService.deleteById(id)) {
            result.setCode(200);
            result.setMessage("删除地址成功");
        } else {
            result.setCode(500);
            result.setMessage("服务器出错");
        }
        return result;
    }

    /**
     * 更新地址
     */
    @PostMapping("/updateAddress")
    public ResponseResult updateAddress(Integer id) {
        Address param = Address.builder()
                .userId(loginUser.getId())
                .build();
        // 获取当前登陆用户的所有地址
        List<Address> addresses = addressService.listAddresss(param);
        addresses.forEach(address -> {
            if (!address.getId().equals(id)) {
                // 将其他地址设为非默认
                address.setIsDefault(0);
            } else {
                address.setIsDefault((address.getIsDefault() + 1) % 2);
            }
            addressService.update(address);
        });
        result.setCode(200);
        result.setMessage("更新成功");
        return result;
    }
}