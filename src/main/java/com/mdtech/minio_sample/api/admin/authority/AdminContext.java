package com.mdtech.minio_sample.api.admin.authority;


import com.mdtech.minio_sample.common.context.Contexts;
import com.mdtech.minio_sample.common.context.SessionWrap;
import com.mdtech.minio_sample.common.exception.ServiceException;

public class AdminContext extends Contexts {

    public static AdminSessionWrap getSessionWrap() throws ServiceException {

        SessionWrap session = getContextSessionWrap();
        if (!(session instanceof com.mdtech.minio_sample.api.admin.authority.AdminSessionWrap)) {
            return null;
        }
        return (com.mdtech.minio_sample.api.admin.authority.AdminSessionWrap) session;
    }

}
