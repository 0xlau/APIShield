package top.xystudio.apishield.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import top.xystudio.apishield.annotation.ApiShieldIgnore;
import top.xystudio.apishield.strategy.ApiShieldStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * ApiShield 综合拦截器
 * @author liupeiqiang
 * @date 2022/12/7 17:45
 */
public class ApiShieldInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)){
            return true;
        }

        Method method = ((HandlerMethod) handler).getMethod();

        // 忽略含有 ApiShieldIgnore.class 的 Method 或者 Class
        if (method.isAnnotationPresent(ApiShieldIgnore.class) ||
            method.getDeclaringClass().isAnnotationPresent(ApiShieldIgnore.class)){
            return true;
        }

        ApiShieldStrategy.me.checkMethodAnnotation(method);

        return true;

    }

}
