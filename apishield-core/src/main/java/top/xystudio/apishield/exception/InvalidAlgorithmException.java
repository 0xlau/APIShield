package top.xystudio.apishield.exception;

/**
 * @author liupeiqiang
 * @date 2022/12/13 15:48
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

    public InvalidAlgorithmException() {
        super("无效的算法");
    }
}
