package top.xystudio.apishield.exception;

/**
 * <p>InvalidAlgorithmException class.</p>
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
public class InvalidAlgorithmException extends ApiShieldException {
    /**
     * 构建一个异常
     *
     * @param message 异常描述信息
     */
    public InvalidAlgorithmException(String message) {
        super(message);
    }

    /**
     * <p>Constructor for InvalidAlgorithmException.</p>
     */
    public InvalidAlgorithmException() {
        super("无效的算法");
    }
}
