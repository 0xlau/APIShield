package top.xystudio.apishield.handle.signature;

import top.xystudio.apishield.ApiShieldManager;
import top.xystudio.apishield.context.model.ApiShieldRequest;
import top.xystudio.apishield.exception.InvalidSignatureValueException;
import top.xystudio.apishield.utils.ApiShieldUtil;

/**
 * 摘要签名处理抽象类
 * @author liupeiqiang
 * @date 2022/12/13 9:39
 */
public abstract class DigestSignatureHandler extends SignatureHandler implements IDigestSignature{

    private ApiShieldRequest getRequest(){
        return ApiShieldManager.getApiShieldContext().getRequest();
    }

    @Override
    public void check(){
        // 获取 sign 值
        String signValue = getSourceSignValue(getRequest());
        if (signValue == null){
            throw new InvalidSignatureValueException("未能读取到有效Sign");
        }

        // 摘要计算处理
        String serializedStr = serialize(getRequest());
        String plainText = salt(serializedStr);
        String digest = encrypt(plainText);
        if (!ApiShieldUtil.equals(digest.toLowerCase(), signValue.toLowerCase())){
            throw new InvalidSignatureValueException();
        }
    }
}
