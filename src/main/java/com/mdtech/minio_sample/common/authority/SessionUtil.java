package com.mdtech.minio_sample.common.authority;

import com.mdtech.minio_sample.common.context.SessionWrap;
import com.mdtech.minio_sample.common.entity.Constants;
import com.mdtech.minio_sample.common.entity.ErrorCode;
import com.mdtech.minio_sample.common.exception.ServiceException;
import com.mdtech.minio_sample.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class SessionUtil {

    @Autowired
    private com.mdtech.minio_sample.api.admin.service.IAdminService adminService;


    public static Map<String, SessionWrap> map = new HashMap<>();

    public static SessionWrap getSession(String token) {
        return map.get(token);
    }

    public static boolean tokenTimeout(String token) {
        if (map.get(token) == null) {
            return true;
        } else {
            SessionWrap wrap = map.get(token);
            if (wrap == null) {
                return true;
            }
            long currT = System.currentTimeMillis();
            if (wrap instanceof com.mdtech.minio_sample.api.admin.authority.AdminSessionWrap) {
                com.mdtech.minio_sample.api.admin.model.AdminSession session = ((com.mdtech.minio_sample.api.admin.authority.AdminSessionWrap) wrap).getAdminSession();
                return session == null || session.getExpireAt() <= currT;
            } else {
                return true;
            }
        }

    }

    public static void putSession(String token, SessionWrap sess) {
        if (map == null || map.isEmpty()) {
            map = new HashMap<>();
        }
        map.put(token, sess);
    }

    public static void removeSession(String token) {
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (token.equals(key)) {
                iterator.remove();
                map.remove(key);
            }
        }
    }

    public SessionWrap adminPermissionCheck(Enum type, String token, String permission) throws ServiceException {

        if (tokenTimeout(token)) {
            long currT = System.currentTimeMillis();
            if (type == AdminType.ADMIN) {
                com.mdtech.minio_sample.api.admin.model.AdminSession session = adminService.adminSession(token);

                if (session != null && session.getExpireAt() > currT) {
                    com.mdtech.minio_sample.api.admin.model.Admin admin = adminService.admin(session.getAdminId(), true);
                    if (admin != null && admin.getStatus() == Constants.STATUS_OK) {
                        com.mdtech.minio_sample.api.admin.authority.AdminSessionWrap wrap = new com.mdtech.minio_sample.api.admin.authority.AdminSessionWrap(admin, session);
                        putSession(token, wrap);
                    } else {
                        throw new ServiceException(ErrorCode.NO_PERMISSION.getCode());
                    }
                } else {
                    throw new ServiceException(ErrorCode.SESSIONTIMEOUT.getCode());
                }
            }
        }

        {
            boolean pass = false;

            SessionWrap wrap = getSession(token);
            if (wrap == null) {
                throw new ServiceException(ErrorCode.SESSIONTIMEOUT.getCode());
            }

            if (StringUtils.isEmpty(permission) || permission.equals("NONE")) {
                pass = true;
            } else {
                List<String> ps = new ArrayList<>();
                if (wrap instanceof com.mdtech.minio_sample.api.admin.authority.AdminSessionWrap) {
                    com.mdtech.minio_sample.api.admin.model.Admin admin = ((com.mdtech.minio_sample.api.admin.authority.AdminSessionWrap) wrap).getAdmin();
                    ps = admin.getRole().getPermissions();
                }
                pass = ps.contains(permission);
            }

            if (pass) {
                return wrap;
            } else {
                throw new ServiceException(ErrorCode.NO_PERMISSION.getCode());
            }
        }

    }

}
