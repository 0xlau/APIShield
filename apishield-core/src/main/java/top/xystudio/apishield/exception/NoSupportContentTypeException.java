package top.xystudio.apishield.exception;

/**
 * @author liupeiqiang
 * @date 2022/12/8 16:00
 */
public class NoSupportContentTypeException extends ApiShieldException {
    /**
     * 构建一个异常
     *
     * @param message 异常描述信息
     */
    public NoSupportContentTypeException(String message) {
        super(message);
    }

    public NoSupportContentTypeException() {
        super("不支持的Content-Type");
    }
}
