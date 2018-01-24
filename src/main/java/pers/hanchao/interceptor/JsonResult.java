package pers.hanchao.interceptor;

/**
 * Created by 韩超 on 2018/1/23.
 */
public class JsonResult {
    private Integer code = 1;
    private String message = "success!";

    public JsonResult() {
    }

    public JsonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
