package top.xystudio.apishield.handle.signature;

import top.xystudio.apishield.ApiShieldManager;
import top.xystudio.apishield.config.ApiShieldConfig;
import top.xystudio.apishield.context.model.ApiShieldRequest;
import top.xystudio.apishield.handle.ICheck;

/**
 * @author liupeiqiang
 * @date 2022/12/14 23:04
 */
public abstract class SignatureHandler implements ISignature, ICheck {

    /** sign 名称 **/
    protected String signName;

    /** sign 盐 **/
    protected String signSalt;

    public SignatureHandler setSignName(String signName) {
        this.signName = signName;
        return this;
    }

    public SignatureHandler setSignSalt(String signSalt) {
        this.signSalt = signSalt;
        return this;
    }

    @Override
    public String getSourceSignValue(ApiShieldRequest request) {
        ApiShieldConfig config = ApiShieldManager.getConfig();
        String signValue = null;
        // 1. 尝试从query里面读取
        if(signValue == null && config.getIsReadQuery()){
            signValue = request.getQuery(this.signName);
        }
        // 2. 尝试从header里读取
        if(signValue == null && config.getIsReadHeader()){
            signValue = request.getHeader(this.signName);
        }
        // 3. 尝试从cookie里读取
        if(signValue == null && config.getIsReadCookie()){
            signValue = request.getCookieValue(this.signName);
        }
        return signValue;
    }

}
