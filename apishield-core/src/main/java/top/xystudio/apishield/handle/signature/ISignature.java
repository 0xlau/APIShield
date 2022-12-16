package top.xystudio.apishield.handle.signature;

import top.xystudio.apishield.context.model.ApiShieldRequest;

/**
 * 签名接口
 * @author liupeiqiang
 * @date 2022/12/14 22:47
 */
public interface ISignature {

    /**
     * 取源签名值
     * @return
     */
    public String getSourceSignValue(ApiShieldRequest request);

}
