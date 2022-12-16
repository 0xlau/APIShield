package top.xystudio.apishield.exception;

/**
 * @author liupeiqiang
 * @date 2022/12/13 15:23
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

    public InvalidSecretKeyException() {
        super("请设置SecretKey");
    }
}
