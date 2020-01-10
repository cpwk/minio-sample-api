package com.mdtech.minio_sample.api.file.service;


import com.mdtech.minio_sample.api.file.entity.UploadToken;

import java.io.File;

public interface IFileService {

    UploadToken presignedPutObject(String namespace, String fileName, int fileSize) throws Exception;

    String putObject(String namespace, String fileName, boolean settledName) throws Exception;

    String getObject(String bucket, String objectName) throws Exception;

    String presignedGetObject(String bucket, String objectName) throws Exception;

    File createTmpFile(String namespace, String extension) throws Exception;

    File createTmpFolderWithName(String namespace, String fileName);

}
