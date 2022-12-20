package top.xystudio.apishield.handle.signature;

import top.xystudio.apishield.context.model.ApiShieldRequest;

/**
 * 摘要签名算法接口
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
public interface IDigestSignature {

    /**
     * 将请求序列化按照一定的规则进行字段序列化和排序，最终产生一个字符串 serializedStr
     *
     * @param request 请求数据
     * @return a {@link java.lang.String} object.
     */
    public String serialize(ApiShieldRequest request);

    /**
     * 加盐后返回 plainText
     * @param serializedStr 已序列化的字符串
     * @return a {@link java.lang.String} object.
     */
    default String salt(String serializedStr){
        return serializedStr;
    }

    /**
     * 摘要算法加密处理
     * @param plainText
     * @return a {@link java.lang.String} object.
     */
    String encrypt(String plainText);

}
