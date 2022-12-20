package top.xystudio.apishield.springboot.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.xystudio.apishield.interceptor.ApiShieldInterceptor;

/**
 * Web 项目拦截器配置
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
@Configuration
@ConditionalOnProperty(prefix = "apishield", name = "enable", havingValue = "true")
@AutoConfigureAfter({ApiShieldPropertyAutoConfiguration.class, ApiShieldMainAutoConfiguration.class})
public class ApiShieldWebMvcConfigurer implements WebMvcConfigurer {

    /** {@inheritDoc} */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ApiShieldInterceptor()).addPathPatterns("/**");
    }
}
