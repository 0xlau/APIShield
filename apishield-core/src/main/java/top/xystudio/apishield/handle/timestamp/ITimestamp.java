package top.xystudio.apishield.handle.timestamp;

import top.xystudio.apishield.context.model.ApiShieldRequest;

/**
 * 时间戳接口
 * @author liupeiqiang
 * @date 2022/12/15 11:35
 */
public interface ITimestamp {

    /**
     * 取时间戳值
     * @return
     */
    public Long getSourceTimestampValue(ApiShieldRequest request);

}
