package top.xystudio.apishield.exception;

/**
 * <p>NotAllowRefererException class.</p>
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
public class NotAllowRefererException extends ApiShieldException{

    /** Constant <code>BE_MESSAGE="Referer不合法，拒绝访问"</code> */
    public static final String BE_MESSAGE = "Referer不合法，拒绝访问";
    /**
     * 构建一个异常
     *
     * @param message 异常描述信息
     */
    public NotAllowRefererException(String message) {
        super(message);
    }

    /**
     * <p>Constructor for NotAllowRefererException.</p>
     */
    public NotAllowRefererException(){
        super(BE_MESSAGE);
    }
}
