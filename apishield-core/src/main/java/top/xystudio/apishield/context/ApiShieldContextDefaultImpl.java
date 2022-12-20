package top.xystudio.apishield.context;

import top.xystudio.apishield.context.model.ApiShieldRequest;
import top.xystudio.apishield.exception.InvalidContextException;

/**
 * <p>ApiShieldContextDefaultImpl class.</p>
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
public class ApiShieldContextDefaultImpl implements ApiShieldContext{

    /** {@inheritDoc} */
    @Override
    public ApiShieldRequest getRequest() {
        throw new InvalidContextException("未能获取有效的上下文处理器");
    }

}
