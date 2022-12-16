package top.xystudio.apishield.annotation;

import top.xystudio.apishield.handle.timestamp.CheckTimestampHandler;
import top.xystudio.apishield.handle.timestamp.DefaultCheckTimestampHandler;

import java.lang.annotation.*;

/**
 * 时间戳校验注解
 * <p> 可标注在函数、类上（效果等同于标注在此类的所有方法上）
 * @author liupeiqiang
 * @date 2022/12/15 0:19
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ApiShieldCheckTimestamp {

    // timestamp 关键词
    String value() default "";

    // 有效期（单位：毫秒）
    int lifeTime() default 0;

    Class<? extends CheckTimestampHandler> handler() default DefaultCheckTimestampHandler.class;

}
