package top.xystudio.apishield.exception;

/**
 * @author liupeiqiang
 * @date 2022/12/11 23:23
 */
public class InvalidContextException extends ApiShieldException {
    /**
     * 构建一个异常
     *
     * @param message 异常描述信息
     */
    public InvalidContextException(String message) {
        super(message);
    }
}
