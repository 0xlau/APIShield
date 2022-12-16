package top.xystudio.apishield.springboot.context;

import top.xystudio.apishield.context.ApiShieldContext;
import top.xystudio.apishield.context.model.ApiShieldRequest;
import top.xystudio.apishield.model.ApiShieldRequestForServlet;
import top.xystudio.apishield.utils.SpringMVCUtil;

/**
 * 上下文处理器 [ SpringMVC版本实现 ]
 * @author liupeiqiang
 * @date 2022/12/12 15:19
 */
public class ApiShieldContextForSpring implements ApiShieldContext {

    @Override
    public ApiShieldRequest getRequest() {
        return new ApiShieldRequestForServlet(SpringMVCUtil.getRequest());
    }

    /**
     * 此上下文是否有效
     */
    @Override
    public boolean isValid() {
        return SpringMVCUtil.isWeb();
    }
}
