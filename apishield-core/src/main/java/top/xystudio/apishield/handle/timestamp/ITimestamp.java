package top.xystudio.apishield.handle.timestamp;

import top.xystudio.apishield.context.model.ApiShieldRequest;

/**
 * 时间戳接口
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
public interface ITimestamp {

    /**
     * 取时间戳值
     *
     * @param request a {@link top.xystudio.apishield.context.model.ApiShieldRequest} object.
     * @return a {@link java.lang.Long} object.
     */
    public Long getSourceTimestampValue(ApiShieldRequest request);

}
