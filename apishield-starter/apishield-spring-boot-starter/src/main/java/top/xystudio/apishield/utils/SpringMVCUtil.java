package top.xystudio.apishield.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.xystudio.apishield.exception.NotWebContextException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liupeiqiang
 * @date 2022/12/7 18:30
 */
public class SpringMVCUtil {

    private SpringMVCUtil() {
    }

    /**
     * 获取当前会话的 request
     * @return request
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(servletRequestAttributes == null) {
            throw new NotWebContextException("非Web上下文无法获取Request");
        }
        return servletRequestAttributes.getRequest();
    }

    /**
     * 获取当前会话的 response
     * @return response
     */
    public static HttpServletResponse getResponse() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(servletRequestAttributes == null) {
            throw new NotWebContextException("非Web上下文无法获取Response");
        }
        return servletRequestAttributes.getResponse();
    }

    /**
     * 判断当前是否处于 Web 上下文中
     * @return request
     */
    public static boolean isWeb() {
        return RequestContextHolder.getRequestAttributes() != null;
    }

}
