package top.xystudio.apishield.handle.signature;

import top.xystudio.apishield.ApiShieldManager;
import top.xystudio.apishield.config.ApiShieldConfig;
import top.xystudio.apishield.context.model.ApiShieldRequest;
import top.xystudio.apishield.handle.ICheck;

/**
 * <p>Abstract SignatureHandler class.</p>
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
public abstract class SignatureHandler implements ISignature, ICheck {

    /** sign 名称 **/
    protected String signName;

    /** sign 盐 **/
    protected String signSalt;

    /**
     * <p>Setter for the field <code>signName</code>.</p>
     *
     * @param signName a {@link java.lang.String} object.
     * @return a {@link top.xystudio.apishield.handle.signature.SignatureHandler} object.
     */
    public SignatureHandler setSignName(String signName) {
        this.signName = signName;
        return this;
    }

    /**
     * <p>Setter for the field <code>signSalt</code>.</p>
     *
     * @param signSalt a {@link java.lang.String} object.
     * @return a {@link top.xystudio.apishield.handle.signature.SignatureHandler} object.
     */
    public SignatureHandler setSignSalt(String signSalt) {
        this.signSalt = signSalt;
        return this;
    }

    /** {@inheritDoc} */
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
