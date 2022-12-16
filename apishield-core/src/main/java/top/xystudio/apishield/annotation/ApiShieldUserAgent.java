package top.xystudio.apishield.annotation;

import java.lang.annotation.*;

/**
 * 校验UserAgent注解
 * <p> 可标注在函数、类上（效果等同于标注在此类的所有方法上）
 * @author liupeiqiang
 * @date 2022/12/12 15:44
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ApiShieldUserAgent {

    /**
     * 允许的UserAgent
     * @return 允许的UserAgent内容集合
     */
    String[] value() default {};

    /**
     * 不允许的UserAgent
     * @return 不允许的UserAgent内容集合
     */
    String[] forbids() default {};

}
