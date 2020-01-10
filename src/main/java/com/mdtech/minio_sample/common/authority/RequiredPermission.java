package com.mdtech.minio_sample.common.authority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface RequiredPermission {

    AdminType[] adminType();

    com.mdtech.minio_sample.api.admin.authority.AdminPermission[] adminPermission() default {com.mdtech.minio_sample.api.admin.authority.AdminPermission.NONE};

}
