package top.xystudio.apishield.annotation;

import java.lang.annotation.*;

/**
 * 校验Referer注解
 * <p> 可标注在函数、类上（效果等同于标注在此类的所有方法上）
 * @author liupeiqiang
 * @date 2022/12/12 15:40
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ApiShieldReferer {

    /**
     * 允许的Referer
     * @return 允许的Referer内容集合
     */
    String[] value() default {};

    /**
     * 不允许的Referer
     * @return 不允许的Referer内容集合
     */
    String[] forbids() default {};

}
