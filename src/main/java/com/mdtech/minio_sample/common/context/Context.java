package com.mdtech.minio_sample.common.context;


public class Context {

    private SessionWrap session;

    private String requestIp;

    public SessionWrap getSession() {
        return session;
    }

    public void setSession(SessionWrap session) {
        this.session = session;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }
}
