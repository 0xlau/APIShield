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
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
@Configuration
@AutoConfigureAfter(ApiShieldPropertyAutoConfiguration.class)
@ConditionalOnProperty(prefix = "apishield", name = "enable", havingValue = "true")
public class ApiShieldMainAutoConfiguration {

    /**
     * <p>Constructor for ApiShieldMainAutoConfiguration.</p>
     *
     * @param apiShieldConfig a {@link top.xystudio.apishield.config.ApiShieldConfig} object.
     * @param apiShieldContext a {@link top.xystudio.apishield.context.ApiShieldContext} object.
     */
    public ApiShieldMainAutoConfiguration(
            @Autowired ApiShieldConfig apiShieldConfig,
            @Autowired ApiShieldContext apiShieldContext
    ) {
        ApiShieldUtil.printApiShield();
        ApiShieldManager.setConfig(apiShieldConfig);
        ApiShieldManager.setApiShieldContext(apiShieldContext);
    }


}
