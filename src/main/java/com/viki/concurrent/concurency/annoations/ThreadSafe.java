package com.viki.concurrent.concurency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: xunruibo
 * @Description:
 * @Date: Created in 15:18 2018/4/23
 * @Modified By:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadSafe {
    String value() default "";
}
