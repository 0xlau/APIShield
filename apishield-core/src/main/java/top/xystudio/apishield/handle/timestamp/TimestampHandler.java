package top.xystudio.apishield.handle.timestamp;

import top.xystudio.apishield.ApiShieldManager;
import top.xystudio.apishield.config.ApiShieldConfig;
import top.xystudio.apishield.context.model.ApiShieldRequest;
import top.xystudio.apishield.handle.ICheck;

/**
 *
 * @author liupeiqiang
 * @date 2022/12/15 11:36
 */
public abstract class TimestampHandler implements ITimestamp, ICheck {

    /** timestamp 名称 **/
    protected String tsName;

    /** 存活时间 **/
    protected Integer lifeTime;

    public TimestampHandler setTsName(String tsName) {
        this.tsName = tsName;
        return this;
    }

    public TimestampHandler setLifeTime(Integer lifeTime) {
        this.lifeTime = lifeTime;
        return this;
    }

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
