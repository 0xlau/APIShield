package top.xystudio.apishield.exception;

/**
 * <p>InvalidSignatureValueException class.</p>
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
public class InvalidSignatureValueException extends ApiShieldException {

    /**
     * 构建一个异常
     *
     * @param message 异常描述信息
     */
    public InvalidSignatureValueException(String message) {
        super(message);
    }

    /**
     * <p>Constructor for InvalidSignatureValueException.</p>
     */
    public InvalidSignatureValueException(){
        super("无效的sign签名");
    }
}
