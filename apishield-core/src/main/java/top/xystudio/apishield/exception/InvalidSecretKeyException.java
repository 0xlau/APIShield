package top.xystudio.apishield.exception;

/**
 * <p>InvalidSecretKeyException class.</p>
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
public class InvalidSecretKeyException extends ApiShieldException {
    /**
     * 构建一个异常
     *
     * @param message 异常描述信息
     */
    public InvalidSecretKeyException(String message) {
        super(message);
    }

    /**
     * <p>Constructor for InvalidSecretKeyException.</p>
     */
    public InvalidSecretKeyException() {
        super("请设置SecretKey");
    }
}
