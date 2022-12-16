package top.xystudio.apishield.handle.signature;

import top.xystudio.apishield.context.model.ApiShieldRequest;

/**
 * 摘要签名算法接口
 * @author liupeiqiang
 * @date 2022/12/13 9:20
 */
public interface IDigestSignature {

    /**
     * 将请求序列化按照一定的规则进行字段序列化和排序，最终产生一个字符串 serializedStr
     * @param request 请求数据
     * @return
     */
    public String serialize(ApiShieldRequest request);

    /**
     * 加盐后返回 plainText
     * @param serializedStr 已序列化的字符串
     * @return
     */
    default String salt(String serializedStr){
        return serializedStr;
    }

    /**
     * 摘要算法加密处理
     * @param plainText
     * @return
     */
    String encrypt(String plainText);

}
