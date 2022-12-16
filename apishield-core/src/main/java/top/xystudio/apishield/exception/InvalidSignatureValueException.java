package top.xystudio.apishield.exception;

/**
 * @author liupeiqiang
 * @date 2022/12/8 18:33
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

    public InvalidSignatureValueException(){
        super("无效的sign签名");
    }
}
