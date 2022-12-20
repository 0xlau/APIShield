package top.xystudio.apishield.annotation;

import java.lang.annotation.*;

/**
 * 忽略注解
 * <p> 可标注在函数、类上（效果等同于标注在此类的所有方法上）
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ApiShieldIgnore {
}
