package top.xystudio.apishield.context;

import top.xystudio.apishield.context.model.ApiShieldRequest;
import top.xystudio.apishield.exception.InvalidContextException;

/**
 * @author liupeiqiang
 * @date 2022/12/11 23:22
 */
public class ApiShieldContextDefaultImpl implements ApiShieldContext{

    @Override
    public ApiShieldRequest getRequest() {
        throw new InvalidContextException("未能获取有效的上下文处理器");
    }

}
