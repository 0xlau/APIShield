package top.xystudio.apishield.strategy;

import top.xystudio.apishield.ApiShieldManager;
import top.xystudio.apishield.annotation.ApiShieldCheckTimestamp;
import top.xystudio.apishield.annotation.ApiShieldDigestSignature;
import top.xystudio.apishield.annotation.ApiShieldReferer;
import top.xystudio.apishield.annotation.ApiShieldUserAgent;
import top.xystudio.apishield.config.ApiShieldConfig;
import top.xystudio.apishield.context.model.ApiShieldRequest;
import top.xystudio.apishield.exception.NotAllowRefererException;
import top.xystudio.apishield.exception.NotAllowUserAgentException;
import top.xystudio.apishield.handle.signature.DigestSignatureHandler;
import top.xystudio.apishield.handle.timestamp.CheckTimestampHandler;
import top.xystudio.apishield.utils.ApiShieldUtil;

import java.util.regex.Pattern;

/**
 * ApiShield逻辑实现类
 * @author liupeiqiang
 * @date 2022/12/12 16:13
 */
public class ApiShieldLogic {

    private ApiShieldRequest getRequest(){
        return ApiShieldManager.getApiShieldContext().getRequest();
    }

    private ApiShieldConfig getConfig(){
        return ApiShieldManager.getConfig();
    }

    // ------------------- 注解验证 -------------------
    /**
     * 根据注解(@ApiShieldReferer)验证
     * @param asr 注解对象
     */
    public void checkByAnnotation(ApiShieldReferer asr) {
        String referer = getRequest().getReferer();
        if (referer == null){
            throw new NotAllowRefererException();
        }
        // 不允许访问的Referer
        for (String regex : asr.forbids()) {
            if (Pattern.matches(regex, referer)){
                throw new NotAllowRefererException();
            }
        }
        // 允许访问的Referer
        if (asr.value().length == 0) return;
        for (String regex : asr.value()) {
            if (Pattern.matches(regex, referer)){
                return;
            }
        }
        throw new NotAllowRefererException();
    }

    /**
     * 根据注解(@ApiShieldUserAgent)验证
     * @param asua 注解对象
     */
    public void checkByAnnotation(ApiShieldUserAgent asua) {
        String ua = getRequest().getUserAgent();
        if (ua == null){
            throw new NotAllowUserAgentException();
        }
        // 不允许访问的UA
        for (String regex : asua.forbids()) {
            if (Pattern.compile(regex).matcher(ua.toLowerCase()).find()){
                throw new NotAllowUserAgentException();
            }
        }
        // 允许访问的UA
        if (asua.value().length == 0) return;
        for (String regex : asua.value()) {
            if (Pattern.compile(regex).matcher(ua.toLowerCase()).find()){
                return;
            }
        }
        throw new NotAllowUserAgentException();
    }

    /**
     * 根据注解(@ApiShieldDigestSignature)验证
     * @param asds 注解对象
     */
    public void checkByAnnotation(ApiShieldDigestSignature asds) {
        // 注解 signName 优先 再到 Config 的 signName
        String signName = ApiShieldUtil.isEmpty(asds.value()) ? getConfig().getSignName() : asds.value();
        // 注解 signSalt 优先 再到 Config 的 signSalt
        String signSalt = ApiShieldUtil.isEmpty(asds.salt()) ? getConfig().getSignSalt() : asds.salt();
        Class<? extends DigestSignatureHandler> handler = asds.handler();
        try {
            handler.newInstance()
                    .setSignName(signName)
                    .setSignSalt(signSalt)
                    .check();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据注解(@ApiShieldCheckTimestamp)验证
     * @param asct 注解对象
     */
    public void checkByAnnotation(ApiShieldCheckTimestamp asct) {
        String tsName = ApiShieldUtil.isEmpty(asct.value()) ? getConfig().getTsName() : asct.value();
        Integer lifeTime = asct.lifeTime() <= 0 ? getConfig().getTsLifetime() : asct.lifeTime();
        Class<? extends CheckTimestampHandler> handler = asct.handler();
        try {
            handler.newInstance()
                    .setTsName(tsName)
                    .setLifeTime(lifeTime)
                    .check();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
