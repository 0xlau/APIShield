package top.xystudio.apishield;

import top.xystudio.apishield.config.ApiShieldConfig;
import top.xystudio.apishield.context.ApiShieldContext;
import top.xystudio.apishield.exception.InvalidConfigException;
import top.xystudio.apishield.strategy.ApiShieldLogic;

/**
 * 管理 ApiShield 所有全部组件
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
public class ApiShieldManager {

    /**
     * 逻辑处理 Bean
     */
    private static final ApiShieldLogic apiShieldLogic = new ApiShieldLogic();

    /**
     * <p>Getter for the field <code>apiShieldLogic</code>.</p>
     *
     * @return a {@link top.xystudio.apishield.strategy.ApiShieldLogic} object.
     */
    public static final ApiShieldLogic getApiShieldLogic(){
        return apiShieldLogic;
    }

    /**
     * 配置文件 Bean
     */
    public volatile static ApiShieldConfig config;

    /**
     * <p>Setter for the field <code>config</code>.</p>
     *
     * @param config a {@link top.xystudio.apishield.config.ApiShieldConfig} object.
     */
    public static void setConfig(ApiShieldConfig config){
        ApiShieldManager.config = config;
    }

    /**
     * <p>Getter for the field <code>config</code>.</p>
     *
     * @return a {@link top.xystudio.apishield.config.ApiShieldConfig} object.
     */
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
    /**
     * <p>Setter for the field <code>apiShieldContext</code>.</p>
     *
     * @param apiShieldContext a {@link top.xystudio.apishield.context.ApiShieldContext} object.
     */
    public static void setApiShieldContext(ApiShieldContext apiShieldContext) {
        ApiShieldManager.apiShieldContext = apiShieldContext;
    }
    /**
     * <p>Getter for the field <code>apiShieldContext</code>.</p>
     *
     * @return a {@link top.xystudio.apishield.context.ApiShieldContext} object.
     */
    public static ApiShieldContext getApiShieldContext() {
        return apiShieldContext;
    }


}
