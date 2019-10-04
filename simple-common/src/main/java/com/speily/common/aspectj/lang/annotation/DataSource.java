package com.speily.common.aspectj.lang.annotation;

import com.speily.common.aspectj.lang.enums.DataSourceType;

import java.lang.annotation.*;

/**
 * 自定义多数据源切换注解
 *
 * @author spl
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource {
    /**
     * 切换数据源名称
     */
    public DataSourceType value() default DataSourceType.MASTER;
}
