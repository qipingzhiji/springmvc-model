package com.lucene.test.config.log.annotations;

import java.lang.annotation.*;

/**
 * Created by zhang_htao on 2019/12/4.
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Target(value = ElementType.METHOD)
public @interface ParamLog {
    String value() default "";
}
