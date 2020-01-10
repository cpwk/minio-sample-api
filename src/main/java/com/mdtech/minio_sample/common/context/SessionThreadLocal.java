package com.mdtech.minio_sample.common.context;

public class SessionThreadLocal extends ThreadLocal<Context> {

    private static final SessionThreadLocal INSTANCE = new SessionThreadLocal();

    private SessionThreadLocal() {
    }

    public static SessionThreadLocal getInstance() {
        return INSTANCE;
    }

}
