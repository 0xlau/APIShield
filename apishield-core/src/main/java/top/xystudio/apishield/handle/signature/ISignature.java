package top.xystudio.apishield.handle.signature;

import top.xystudio.apishield.context.model.ApiShieldRequest;

/**
 * 签名接口
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
public interface ISignature {

    /**
     * 取源签名值
     *
     * @param request a {@link top.xystudio.apishield.context.model.ApiShieldRequest} object.
     * @return a {@link java.lang.String} object.
     */
    public String getSourceSignValue(ApiShieldRequest request);

}
