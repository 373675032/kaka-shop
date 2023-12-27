package world.xuewei.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据返回结果
 *
 * @author XUEW
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseResult {

    private Integer code;

    private String message = "";

    private Object data;

    private String url;

    public ResponseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseResult(int code) {
        this.code = code;
    }

    public ResponseResult(int code, String message, String url) {
        this.code = code;
        this.message = message;
        this.url = url;
    }
}
