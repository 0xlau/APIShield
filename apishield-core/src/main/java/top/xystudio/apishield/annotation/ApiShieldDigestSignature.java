package top.xystudio.apishield.annotation;

import top.xystudio.apishield.handle.signature.DefaultDigestSignatureHandler;
import top.xystudio.apishield.handle.signature.DigestSignatureHandler;

import java.lang.annotation.*;

/**
 * 摘要签名注解
 * <p> 可标注在函数、类上（效果等同于标注在此类的所有方法上）
 *
 * @author liupeiqiang
 * @version $Id: $Id
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ApiShieldDigestSignature {

    // sign 关键字名称
    String value() default "";

    // sign 盐
    String salt() default "";
    Class<? extends DigestSignatureHandler> handler() default DefaultDigestSignatureHandler.class;


}
