package top.xystudio.apishield.exception;

/**
 * @author liupeiqiang
 * @date 2022/12/12 16:33
 */
public class NotAllowUserAgentException extends ApiShieldException{

    public static final String BE_MESSAGE = "User-Agent不合法，拒绝访问";
    /**
     * 构建一个异常
     *
     * @param message 异常描述信息
     */
    public NotAllowUserAgentException(String message) {
        super(message);
    }

    public NotAllowUserAgentException(){
        super(BE_MESSAGE);
    }
}
