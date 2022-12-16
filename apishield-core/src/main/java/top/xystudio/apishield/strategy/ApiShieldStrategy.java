package top.xystudio.apishield.strategy;

import top.xystudio.apishield.ApiShieldManager;
import top.xystudio.apishield.annotation.ApiShieldCheckTimestamp;
import top.xystudio.apishield.annotation.ApiShieldDigestSignature;
import top.xystudio.apishield.annotation.ApiShieldReferer;
import top.xystudio.apishield.annotation.ApiShieldUserAgent;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

/**
 * ApiShield 策略对象
 * ApiShieldStrategy 全局单例
 * @author liupeiqiang
 * @date 2022/12/12 15:56
 */
public final class ApiShieldStrategy {

    private ApiShieldStrategy() {
    }

    public static final ApiShieldStrategy me = new ApiShieldStrategy();


    public void checkMethodAnnotation(Method method) {

        // 先校验 Method 所属 Class 上的注解
        checkElementAnnotation(method.getDeclaringClass());

        // 再校验 Method 上的注解
        checkElementAnnotation(method);
    }

    private void checkElementAnnotation(AnnotatedElement target){
        // 校验Referer
        ApiShieldReferer apiShieldReferer = target.getAnnotation(ApiShieldReferer.class);
        if (apiShieldReferer != null){
            ApiShieldManager.getApiShieldLogic().checkByAnnotation(apiShieldReferer);
        }

        // 校验UserAgent
        ApiShieldUserAgent apiShieldUserAgent = target.getAnnotation(ApiShieldUserAgent.class);
        if (apiShieldUserAgent != null){
            ApiShieldManager.getApiShieldLogic().checkByAnnotation(apiShieldUserAgent);
        }

        // 校验摘要签名
        ApiShieldDigestSignature apiShieldDigestSignature = target.getAnnotation(ApiShieldDigestSignature.class);
        if (apiShieldDigestSignature != null){
            ApiShieldManager.getApiShieldLogic().checkByAnnotation(apiShieldDigestSignature);
        }

        // 校验摘要签名
        ApiShieldCheckTimestamp apiShieldCheckTimestamp = target.getAnnotation(ApiShieldCheckTimestamp.class);
        if (apiShieldCheckTimestamp != null){
            ApiShieldManager.getApiShieldLogic().checkByAnnotation(apiShieldCheckTimestamp);
        }

    }
}
