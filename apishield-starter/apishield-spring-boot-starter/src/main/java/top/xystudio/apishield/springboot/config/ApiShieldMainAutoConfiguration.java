package top.xystudio.apishield.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import top.xystudio.apishield.ApiShieldManager;
import top.xystudio.apishield.config.ApiShieldConfig;
import top.xystudio.apishield.context.ApiShieldContext;
import top.xystudio.apishield.utils.ApiShieldUtil;

/**
 * 主要业务装配器
 * @author liupeiqiang
 * @date 2022/12/8 16:59
 */
@Configuration
@AutoConfigureAfter(ApiShieldPropertyAutoConfiguration.class)
@ConditionalOnProperty(prefix = "apishield", name = "enable", havingValue = "true")
public class ApiShieldMainAutoConfiguration {

    public ApiShieldMainAutoConfiguration(
            @Autowired ApiShieldConfig apiShieldConfig,
            @Autowired ApiShieldContext apiShieldContext
    ) {
        ApiShieldUtil.printApiShield();
        ApiShieldManager.setConfig(apiShieldConfig);
        ApiShieldManager.setApiShieldContext(apiShieldContext);
    }


}
