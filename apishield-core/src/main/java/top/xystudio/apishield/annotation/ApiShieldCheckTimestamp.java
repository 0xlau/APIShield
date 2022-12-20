package top.xystudio.apishield.annotation;

import top.xystudio.apishield.handle.timestamp.CheckTimestampHandler;
import top.xystudio.apishield.handle.timestamp.DefaultCheckTimestampHandler;

import java.lang.annotation.*;

/**
 * 时间戳校验注解
 * <p> 可标注在函数、类上（效果等同于标注在此类的所有方法上）
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ApiShieldCheckTimestamp {

    /**
     * Timestamp 关键词
     * @return 返回 Timestamp关键词
     */
    String value() default "";

    /**
     * 有效期（单位：毫秒）
     * @return 整数型
     */
    int lifeTime() default 0;

    /**
     * 实现了 CheckTimestampHandler 的处理器
     * @return 处理器
     */
    Class<? extends CheckTimestampHandler> handler() default DefaultCheckTimestampHandler.class;

}
