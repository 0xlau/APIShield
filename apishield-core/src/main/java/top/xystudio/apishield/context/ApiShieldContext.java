package top.xystudio.apishield.context;

import top.xystudio.apishield.context.model.ApiShieldRequest;

/**
 * 上下文处理器
 * @author liupeiqiang
 */
public interface ApiShieldContext {

    /**
     * 获取当前请求的 [Request] 对象
     *
     * @return see note
     */
    public ApiShieldRequest getRequest();

    /**
     * 此上下文是否有效
     * @return /
     */
    public default boolean isValid() {
        return false;
    }

}
