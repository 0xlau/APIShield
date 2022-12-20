package top.xystudio.apishield.exception;

/**
 * <p>NoSupportContentTypeException class.</p>
 *
 * @author liupeiqiang
 * @version $Id: $Id
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

    /**
     * <p>Constructor for NoSupportContentTypeException.</p>
     */
    public NoSupportContentTypeException() {
        super("不支持的Content-Type");
    }
}
