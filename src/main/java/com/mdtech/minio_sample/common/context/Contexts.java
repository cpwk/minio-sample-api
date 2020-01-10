package com.mdtech.minio_sample.common.context;

import com.mdtech.minio_sample.common.entity.ErrorCode;
import com.mdtech.minio_sample.common.exception.DetailedException;
import com.mdtech.minio_sample.common.exception.ServiceException;

public class Contexts {

    public static void set(Context context) {
        SessionThreadLocal.getInstance().set(context);
    }

    public static Context get() {
        return SessionThreadLocal.getInstance().get();
    }

    protected static SessionWrap getContextSessionWrap() throws ServiceException {
        Context context = get();
        if (context == null) {
            return null;
        }
        SessionWrap session = context.getSession();
        if (session == null) {
            return null;
        }
        return session;
    }


    private static void needContext() throws ServiceException {
        Context context = get();
        if (context == null) {
            throw new ServiceException(ErrorCode.SESSIONTIMEOUT.getCode());
        }
    }

    public static SessionWrap getSession() {
        return get().getSession();
    }

    public static Integer requestAdminId() throws ServiceException {
        needContext();
        Integer adminId = sessionAdminId();
        if (adminId == null) {
            throw new DetailedException("need adminId");
        }
        return adminId;
    }

    public static Integer sessionAdminId() throws ServiceException {
        SessionWrap wrap = getContextSessionWrap();
        Integer adminId = null;

        if (wrap instanceof com.mdtech.minio_sample.api.admin.authority.AdminSessionWrap) {
            adminId = ((com.mdtech.minio_sample.api.admin.authority.AdminSessionWrap) wrap).getAdmin().getId();
        }
        return adminId;
    }

}
