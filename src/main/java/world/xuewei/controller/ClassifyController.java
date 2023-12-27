package world.xuewei.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import world.xuewei.dto.ResponseResult;
import world.xuewei.entity.Classify;

import java.util.Date;

/**
 * 商品分类控制器
 *
 * @author XUEW
 */
@RestController
public class ClassifyController extends BaseController {

    /**
     * 添加分类
     */
    @PostMapping("/addClassify")
    public ResponseResult addClassify(@RequestParam("name") String name) {
        // 根据名称查询，判断新增的分类是否已经重复
        Classify classify = Classify.builder().name(name).build();
        if (classifyService.countClassifys(classify) > 0) {
            result.setCode(500);
            result.setMessage("当前商品分类已存在");
        } else {
            // 新增
            classify.setCreateTime(new Date());
            if (classifyService.insert(classify)) {
                result.setCode(200);
                result.setMessage("新增商品分类成功");
            } else {
                result.setCode(500);
                result.setMessage("服务器出错");
            }
        }
        return result;
    }

    /**
     * 更新商品分类
     */
    @PostMapping("/updateClassify")
    public ResponseResult updateClassify(@RequestParam("id") Integer id, @RequestParam("name") String name) {
        // 根据名称查询，判断新增的分类是否已经重复
        Classify classify = Classify.builder().name(name).build();
        if (classifyService.countClassifys(classify) > 0) {
            result.setCode(500);
            result.setMessage("当前商品分类已存在");
        } else {
            classify = classifyService.getById(id);
            classify.setName(name);
            if (classifyService.update(classify)) {
                result.setCode(200);
                result.setMessage("更新商品分类名称成功");
            } else {
                result.setCode(500);
                result.setMessage("服务器出错");
            }
        }
        return result;
    }

    /**
     * 删除商品分类
     */
    @PostMapping("/deleteClassify")
    public ResponseResult deleteClassify(@RequestParam("id") Integer id) {
        // 删除
        if (classifyService.deleteById(id)) {
            result.setCode(200);
            result.setMessage("删除商品分类成功");
        } else {
            result.setCode(500);
            result.setMessage("服务器出错");
        }
        return result;
    }
}
