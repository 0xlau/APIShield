package top.xystudio.apishield.exception;

/**
 * @author liupeiqiang
 * @date 2022/12/12 16:33
 */
public class NotAllowRefererException extends ApiShieldException{

    public static final String BE_MESSAGE = "Referer不合法，拒绝访问";
    /**
     * 构建一个异常
     *
     * @param message 异常描述信息
     */
    public NotAllowRefererException(String message) {
        super(message);
    }

    public NotAllowRefererException(){
        super(BE_MESSAGE);
    }
}
