package world.xuewei.controller;

import cn.hutool.core.util.StrUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import world.xuewei.dto.ResponseResult;
import world.xuewei.entity.Collection;
import world.xuewei.entity.Commodity;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商品控制层
 *
 * @author XUEW
 */
@RestController
public class CommodityController extends BaseController {

    /**
     * 上传商品图片
     */
    @PostMapping("/uploadGoodsImg")
    public ResponseResult uploadGoodsImg(@RequestParam("imgFile") MultipartFile file) throws IOException {
        String url = ossClient.upload(file, String.valueOf(loginUser.getId()));
        if (StrUtil.isNotEmpty(url)) {
            result.setCode(200);
            result.setUrl(url);
            result.setMessage("上传成功");
        } else {
            result.setCode(500);
            result.setMessage("上传失败");
        }
        return result;
    }

    /**
     * 发布新品
     */
    @PostMapping("/publishNewGoods")
    public ResponseResult publishNewGoods(Commodity commodity, Map<String, Object> map) {
        commodity.setPublishTime(new Date());
        if (commodityService.insert(commodity)) {
            result.setCode(200);
            result.setMessage("发布成功");
        } else {
            result.setCode(500);
            result.setMessage("服务器出错");
        }
        return result;
    }

    /**
     * 修改商品
     */
    @PostMapping("/editGoods")
    public ResponseResult editGoods(Commodity commodity, Map<String, Object> map) {
        commodity.setPublishTime(new Date());
        if (commodityService.update(commodity)) {
            result.setCode(200);
            result.setMessage("修改成功");
        } else {
            result.setCode(500);
            result.setMessage("服务器出错");
        }
        return result;
    }

    /**
     * 更改商品状态
     */
    @PostMapping("/changeStatus")
    public ResponseResult changeStatus(@RequestParam("id") Integer id) {
        Commodity commodity = commodityService.getById(id);

        commodity.setStatus((commodity.getStatus() + 1) % 2);
        if (commodityService.update(commodity)) {
            result.setCode(200);
            result.setMessage("修改成功");
        } else {
            result.setCode(500);
            result.setMessage("服务器出错");
        }
        return result;
    }

    /**
     * 取消收藏
     */
    @PostMapping("/undoCollect")
    public ResponseResult undoCollect(@RequestParam("id") Integer id) {
        // 查询收藏信息
        Collection param = Collection.builder()
                .userId(loginUser.getId())
                .commodityId(id)
                .build();
        List<Collection> collections = collectionService.listCollections(param);
        // 取消收藏
        collections.forEach(collection -> {
            collectionService.deleteById(collection.getId());
        });
        result.setCode(200);
        result.setMessage("取消收藏成功");
        return result;
    }

    /**
     * 收藏
     */
    @PostMapping("/doCollect")
    public ResponseResult doCollect(@RequestParam("id") Integer id) {
        // 查询收藏信息
        Collection param = Collection.builder()
                .userId(loginUser.getId())
                .commodityId(id)
                .addTime(new Date())
                .build();
        if (collectionService.insert(param)) {
            result.setCode(200);
            result.setMessage("收藏成功");
        } else {
            result.setCode(500);
            result.setMessage("服务器出错了");
        }
        return result;
    }


}
