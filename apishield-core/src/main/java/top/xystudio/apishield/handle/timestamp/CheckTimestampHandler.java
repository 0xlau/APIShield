package top.xystudio.apishield.handle.timestamp;

import top.xystudio.apishield.ApiShieldManager;
import top.xystudio.apishield.context.model.ApiShieldRequest;
import top.xystudio.apishield.exception.InvalidTimestampValueException;
import top.xystudio.apishield.utils.ApiShieldUtil;

/**
 * 默认时间戳校验抽象类
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
public abstract class CheckTimestampHandler extends TimestampHandler {

    private ApiShieldRequest getRequest(){
        return ApiShieldManager.getApiShieldContext().getRequest();
    }

    /** {@inheritDoc} */
    @Override
    public void check() {
        // 获取 timestamp 值
        Long tsValue = getSourceTimestampValue(getRequest());
        if (tsValue == null){
            throw new InvalidTimestampValueException("未能读取到有效Timestamp");
        }
        if (ApiShieldUtil.getTimeStamp() - tsValue > this.lifeTime){
            throw new InvalidTimestampValueException("timestamp已失效");
        }
    }
}
