package com.mdtech.minio_sample.api.file.controller;

import com.mdtech.minio_sample.api.admin.authority.AdminPermission;
import com.mdtech.minio_sample.api.file.service.FileService;
import com.mdtech.minio_sample.common.authority.AdminType;
import com.mdtech.minio_sample.common.authority.RequiredPermission;
import com.mdtech.minio_sample.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/adm/file")
public class AdmFileController extends BaseController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/upload_token")
    @RequiredPermission(adminType = AdminType.ADMIN, adminPermission = AdminPermission.NONE)
    public ModelAndView upload_token(String namespace, String fileName, int fileSize) throws Exception {
        return feedback(fileService.presignedPutObject(namespace, fileName, fileSize));
    }

}
