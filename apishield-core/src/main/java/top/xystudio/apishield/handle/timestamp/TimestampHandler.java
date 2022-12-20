package top.xystudio.apishield.handle.timestamp;

import top.xystudio.apishield.ApiShieldManager;
import top.xystudio.apishield.config.ApiShieldConfig;
import top.xystudio.apishield.context.model.ApiShieldRequest;
import top.xystudio.apishield.handle.ICheck;

/**
 * <p>Abstract TimestampHandler class.</p>
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
public abstract class TimestampHandler implements ITimestamp, ICheck {

    /** timestamp 名称 **/
    protected String tsName;

    /** 存活时间 **/
    protected Integer lifeTime;

    /**
     * <p>Setter for the field <code>tsName</code>.</p>
     *
     * @param tsName a {@link java.lang.String} object.
     * @return a {@link top.xystudio.apishield.handle.timestamp.TimestampHandler} object.
     */
    public TimestampHandler setTsName(String tsName) {
        this.tsName = tsName;
        return this;
    }

    /**
     * <p>Setter for the field <code>lifeTime</code>.</p>
     *
     * @param lifeTime a {@link java.lang.Integer} object.
     * @return a {@link top.xystudio.apishield.handle.timestamp.TimestampHandler} object.
     */
    public TimestampHandler setLifeTime(Integer lifeTime) {
        this.lifeTime = lifeTime;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public Long getSourceTimestampValue(ApiShieldRequest request) {
        ApiShieldConfig config = ApiShieldManager.getConfig();
        Long tsValue = null;
        // 1. 尝试从query里面读取
        if(tsValue == null && config.getIsReadQuery()){
            try {tsValue = Long.valueOf(request.getQuery(this.tsName));}catch (Exception e){}
        }
        // 2. 尝试从header里读取
        if(tsValue == null && config.getIsReadHeader()){
            try {tsValue = Long.valueOf(request.getHeader(this.tsName));}catch (Exception e){}
        }
        // 3. 尝试从cookie里读取
        if(tsValue == null && config.getIsReadCookie()){
            try {tsValue = Long.valueOf(request.getCookieValue(this.tsName));}catch (Exception e){}
        }
        return tsValue;
    }
}
