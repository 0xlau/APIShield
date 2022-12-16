package top.xystudio.apishield.springboot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import top.xystudio.apishield.config.ApiShieldConfig;
import top.xystudio.apishield.context.ApiShieldContext;
import top.xystudio.apishield.springboot.context.ApiShieldContextForSpring;
import top.xystudio.apishield.springboot.property.ApiShieldProperty;

/**
 * ApiShieldConfig的装配类
 * 这个装配类主要是把监控器的配置参数类和流程配置参数类作一个合并，转换成统一的配置参数类。
 * 同时这里设置了默认的参数路径，如果在springboot的application.properties/yml里没取到的话，就取默认值
 * @author liupeiqiang
 * @create 2022/12/7 17:36
 */
@Configuration
@EnableConfigurationProperties({ApiShieldProperty.class})
@ConditionalOnProperty(prefix = "apishield", name = "enable", havingValue = "true")
@PropertySource(
        name = "ApiShield Default Properties",
        value = "classpath:/META-INF/apishield-default.properties")
public class ApiShieldPropertyAutoConfiguration {

    @Bean
    public ApiShieldConfig apiShieldConfig(ApiShieldProperty apiShieldProperty){
        ApiShieldConfig config = new ApiShieldConfig();
        config.setEnable(apiShieldProperty.getEnable());
        config.setIsReadBody(apiShieldProperty.getIsReadBody());
        config.setIsReadCookie(apiShieldProperty.getIsReadCookie());
        config.setIsReadHeader(apiShieldProperty.getIsReadHeader());
        config.setIsReadQuery(apiShieldProperty.getIsReadQuery());
        config.setSignName(apiShieldProperty.getSignName());
        config.setSignSalt(apiShieldProperty.getSignSalt());
        config.setTsServiceEnable(apiShieldProperty.getTsServiceEnable());
        config.setTsLifetime(apiShieldProperty.getTsLifetime());
        config.setTsName(apiShieldProperty.getTsName());
        return config;
    }

    @Bean
    public ApiShieldContext apiShieldContext(){
        return new ApiShieldContextForSpring();
    }

}
