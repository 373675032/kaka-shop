package world.xuewei.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import world.xuewei.dto.ResponseResult;
import world.xuewei.entity.CommodityComment;

import java.util.Date;

/**
 * 评论控制器
 *
 * @author XUEW
 */
@RestController
public class CommentController extends BaseController {

    /**
     * 添加评论
     */
    @PostMapping("/addComment")
    public ResponseResult addComment(Integer id, Integer stars, String comment) {
        // 创建评论对象
        CommodityComment build = CommodityComment.builder()
                .userId(loginUser.getId())
                .userName(loginUser.getName())
                .userImg(loginUser.getImg())
                .commodityId(id)
                .comment(comment)
                .stars(stars)
                .commentTime(new Date())
                .build();
        if (commodityCommentService.insert(build)) {
            result.setCode(200);
            result.setMessage("添加评论成功");
        } else {
            result.setCode(500);
            result.setMessage("服务器出错");
        }
        return result;
    }

    /**
     * 回复评论
     */
    @PostMapping("/replyComment")
    public ResponseResult replyComment(Integer id, String comment) {
        // 获取被回复的评论
        CommodityComment commodityComment = commodityCommentService.getById(id);
        // 创建回复的信息
        CommodityComment build = CommodityComment.builder()
                .replyId(id)
                .comment(comment)
                .commentTime(new Date())
                .userId(loginUser.getId())
                .userName(loginUser.getName())
                .userImg(loginUser.getImg())
                .commodityId(commodityComment.getCommodityId())
                .build();
        if (commodityCommentService.insert(build)) {
            result.setCode(200);
            result.setMessage("回复成功");
        } else {
            result.setCode(500);
            result.setMessage("服务器出错");
        }
        return result;
    }

    /**
     * 删除评论
     */
    @PostMapping("/deleteComment")
    public ResponseResult deleteComment(Integer id) {
        if (commodityCommentService.deleteById(id)) {
            result.setCode(200);
            result.setMessage("删除成功");
        } else {
            result.setCode(500);
            result.setMessage("服务器出错");
        }
        return result;
    }

}
