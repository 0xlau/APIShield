package top.xystudio.apishield.handle.signature;

import top.xystudio.apishield.context.model.ApiShieldRequest;
import top.xystudio.apishield.exception.NoSupportContentTypeException;
import top.xystudio.apishield.exception.NoSupportMethodException;
import top.xystudio.apishield.utils.ApiShieldUtil;

import java.util.TreeMap;

/**
 * 默认摘要签名处理器，实现 DigestSignatureHandler
 * 序列化规则：将请求参数的key升序排列，并序列化为 key1:value1&key2:value2&...形式
 * 加盐规则：在文本后面加入固定盐
 * 摘要规则：MD5算法
 * @author liupeiqiang
 * @date 2022/12/13 9:58
 */
public class DefaultDigestSignatureHandler extends DigestSignatureHandler {

    private String doRule(TreeMap sorted){
        StringBuilder result = new StringBuilder();
        for (Object key : sorted.keySet()) {
            if (key.equals(this.signName)) continue;
            Object value = sorted.get(key);
            if (value instanceof String){
                result.append(key + ":" + value + "&");
            }else if(value instanceof String[]){
                result.append(key + ":" + ((String[]) value)[0] + "&");
            }
        }
        return result.toString();
    }

    @Override
    public String serialize(ApiShieldRequest request) {
        if (request.getMethod().equalsIgnoreCase("get")){
            TreeMap paramMap = new TreeMap<>(ApiShieldUtil.splitQueryString(request.getQueryString()));
            return doRule(paramMap);
        } else if (request.getMethod().equalsIgnoreCase("post")) {
            if (request.getContentType() == null || request.getContentType().equalsIgnoreCase("application/x-www-form-urlencoded")){
                TreeMap<String, String[]> paramMap = new TreeMap<>(ApiShieldUtil.splitQueryString(request.getBody()));
                return doRule(paramMap);
            }
            throw new NoSupportContentTypeException("暂不支持 Content-Type:" + request.getContentType() + "，请自行实现 DigestSignatureHandler");
        }
        throw new NoSupportMethodException("暂不支持 " + request.getMethod() + " 方法，请自行实现 DigestSignatureHandler");
    }

    @Override
    public String salt(String serializedStr) {
        if (ApiShieldUtil.isEmpty(this.signSalt)){
            return serializedStr;
        }
        return serializedStr + this.signSalt;
    }

    @Override
    public String encrypt(String plainText) {
        return ApiShieldUtil.md5(plainText);
    }

}
