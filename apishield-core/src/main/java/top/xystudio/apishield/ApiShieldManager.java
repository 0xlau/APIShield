package top.xystudio.apishield;

import top.xystudio.apishield.config.ApiShieldConfig;
import top.xystudio.apishield.context.ApiShieldContext;
import top.xystudio.apishield.exception.InvalidConfigException;
import top.xystudio.apishield.strategy.ApiShieldLogic;

/**
 * 管理 ApiShield 所有全部组件
 * @author liupeiqiang
 * @date 2022/12/11 23:24
 */
public class ApiShieldManager {

    /**
     * 逻辑处理 Bean
     */
    private static final ApiShieldLogic apiShieldLogic = new ApiShieldLogic();
    public static final ApiShieldLogic getApiShieldLogic(){
        return apiShieldLogic;
    }

    /**
     * 配置文件 Bean
     */
    public volatile static ApiShieldConfig config;

    public static void setConfig(ApiShieldConfig config){
        ApiShieldManager.config = config;
    }

    public static ApiShieldConfig getConfig() {
        if (config == null) {
            synchronized (ApiShieldManager.class) {
                if (config == null) {
                    throw new InvalidConfigException("未能获取有效的Config配置");
                }
            }
        }
        return config;
    }

    /**
     * 上下文Context Bean
     */
    private volatile static ApiShieldContext apiShieldContext;
    public static void setApiShieldContext(ApiShieldContext apiShieldContext) {
        ApiShieldManager.apiShieldContext = apiShieldContext;
    }
    public static ApiShieldContext getApiShieldContext() {
        return apiShieldContext;
    }


}
