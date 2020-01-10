package com.mdtech.minio_sample.api.admin.service;

import com.mdtech.minio_sample.api.admin.model.Admin;
import com.mdtech.minio_sample.api.admin.model.AdminSession;
import com.mdtech.minio_sample.api.admin.model.Role;
import com.mdtech.minio_sample.api.admin.qo.AdminSessionQo;
import com.mdtech.minio_sample.common.exception.ServiceException;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;


public interface IAdminService {

    // role

    void save_role(Role role);

    void remove_role(int id);

    Role role(int id);

    List<Role> roles(boolean init);

    // admin

    List<Admin> admins();

    void save_admin(Admin admin) throws ServiceException;

    void admin_status(int id, byte status) throws ServiceException;

    Admin admin(int id, boolean init);

    void remove_admin(int id) throws ServiceException;

    Page<AdminSession> adminSessions(AdminSessionQo qo) throws Exception;

    AdminSession adminSession(String token);

    void update_password(String password, String oldPassword) throws ServiceException;

    // signin

    Map signin(Admin admin, String ip) throws Exception;

    Map profile() throws Exception;

}
