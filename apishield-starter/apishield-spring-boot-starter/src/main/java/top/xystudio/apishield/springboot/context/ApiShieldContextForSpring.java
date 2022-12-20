package top.xystudio.apishield.springboot.context;

import top.xystudio.apishield.context.ApiShieldContext;
import top.xystudio.apishield.context.model.ApiShieldRequest;
import top.xystudio.apishield.model.ApiShieldRequestForServlet;
import top.xystudio.apishield.utils.SpringMVCUtil;

/**
 * 上下文处理器 [ SpringMVC版本实现 ]
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
public class ApiShieldContextForSpring implements ApiShieldContext {

    /** {@inheritDoc} */
    @Override
    public ApiShieldRequest getRequest() {
        return new ApiShieldRequestForServlet(SpringMVCUtil.getRequest());
    }

    /**
     * {@inheritDoc}
     *
     * 此上下文是否有效
     */
    @Override
    public boolean isValid() {
        return SpringMVCUtil.isWeb();
    }
}
