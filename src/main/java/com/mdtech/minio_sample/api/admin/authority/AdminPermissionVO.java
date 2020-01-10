package com.mdtech.minio_sample.api.admin.authority;

import com.mdtech.minio_sample.common.authority.Permission;

import java.util.ArrayList;
import java.util.List;

public class AdminPermissionVO extends Permission {

    private static List<Permission> list = null;

    public static List<Permission> initPermissions() {
        if (list == null) {
            list = new ArrayList<>();
            for (AdminPermission p : AdminPermission.values()) {
                list.add(new Permission(p.name(), p.getVal(), p.getLevel()));
            }
        }
        return list;
    }

    public static List<Permission> initPermissionsByPs(List<String> ps) {
        List<Permission> list = initPermissions();
        List<Permission> result = new ArrayList<>();
        if (ps.size() > 0) {
            for (String s : ps) {
                for (Permission p : list) {
                    if (s.equals(p.getCode()))
                        result.add(p);
                }
            }
        }
        return result;
    }


}
