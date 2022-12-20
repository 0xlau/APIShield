package top.xystudio.apishield.exception;

/**
 * <p>NotAllowUserAgentException class.</p>
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
public class NotAllowUserAgentException extends ApiShieldException{

    /** Constant <code>BE_MESSAGE="User-Agent不合法，拒绝访问"</code> */
    public static final String BE_MESSAGE = "User-Agent不合法，拒绝访问";
    /**
     * 构建一个异常
     *
     * @param message 异常描述信息
     */
    public NotAllowUserAgentException(String message) {
        super(message);
    }

    /**
     * <p>Constructor for NotAllowUserAgentException.</p>
     */
    public NotAllowUserAgentException(){
        super(BE_MESSAGE);
    }
}
