package com.mdtech.minio_sample.api.file.service;

import com.mdtech.minio_sample.api.file.entity.FileConfig;
import com.mdtech.minio_sample.api.file.entity.OSSConfig;
import com.mdtech.minio_sample.api.file.entity.UploadToken;
import com.mdtech.minio_sample.common.entity.Constants;
import com.mdtech.minio_sample.common.exception.DetailedException;
import com.mdtech.minio_sample.common.util.StringUtils;
import com.mdtech.minio_sample.common.util.UUIDCreatorFactory;
import com.mdtech.minio_sample.common.util.UUIDCreatorFactory.UUIDCreator;
import com.sunnysuperman.commons.util.FileUtil;
import io.minio.MinioClient;
import io.minio.errors.MinioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.Calendar;

@Service
public class FileService implements IFileService {

    @Autowired
    private OSSConfig ossConfig;

    @Autowired
    private FileConfig fileConfig;

    private MinioClient minioClient;
    private UUIDCreator fileNameCreator = UUIDCreatorFactory.get();

    @PostConstruct
    public void init() throws Exception {
        minioClient = new MinioClient(ossConfig.getEndpoint(), ossConfig.getKey(), ossConfig.getSecret());
        checkBucket(ossConfig.getBucket());
    }

    private void checkBucket(String bucket) throws Exception {
        try {
            boolean found = minioClient.bucketExists(bucket);
            if (!found) {
                minioClient.makeBucket(bucket);
                System.out.println(bucket + " is created successfully");
            }

        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
        }
    }

    @Override
    public UploadToken presignedPutObject(String namespace, String fileName, int fileSize) throws Exception {
        if (fileSize > Constants.MAX_UPLOAD_SIZE) {
            throw new DetailedException("超过最大上传文件大小");
        }
        String bucket = ossConfig.getBucket();
        String objectName = generateObjectName(namespace, fileName, 8, false);
        String putUrl = minioClient.presignedPutObject(bucket, objectName, Constants.EXPIRE_UPLOAD);
        String url = getObject(bucket, objectName);

        return new UploadToken(objectName, putUrl, url, System.currentTimeMillis());
    }

    @Override
    public String getObject(String bucket, String objectName) throws Exception {
        return minioClient.getObjectUrl(bucket, objectName);
    }

    @Override
    public String presignedGetObject(String bucket, String objectName) throws Exception {
        return minioClient.presignedGetObject(bucket, objectName, 60 * 60 * 24 * 7);
    }

    private String generateObjectName(String namespace, String fileName, int randomLength, boolean settledName) {
        if (StringUtils.isEmpty(namespace)) {
            throw new IllegalArgumentException("namespace");
        }

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        StringBuilder buf = new StringBuilder();
        if (ossConfig.getNamespace() != null) {
            buf.append(ossConfig.getNamespace()).append('/');
        }
        buf.append(namespace).append('/').append(year).append('/').append(month).append('/').append(day).append('/')
                .append(fileNameCreator.create());

        if (randomLength > 0) {
            buf.append(StringUtils.randomString(StringUtils.allstrs, randomLength));
        }

        if (settledName) {
            buf.append("/").append(getFileName(fileName));
        } else {
            String ext = FileUtil.getFileExt(fileName);
            if (ext != null) {
                buf.append('.').append(ext);
            }
        }
        return buf.toString();
    }

    private static String getFileName(String fileName) {
        if (fileName == null) {
            return null;
        } else {
            fileName = fileName.trim();
            int index = fileName.lastIndexOf(File.separator);
            return index > 0 && index < fileName.length() - 1 ? fileName.substring(index + 1).toLowerCase() : null;
        }
    }

    @Override
    public String putObject(String namespace, String fileName, boolean settledName) throws Exception {

        String bucket = ossConfig.getBucket();
        String objectName = generateObjectName(namespace, fileName, 8, settledName);

        minioClient.putObject(bucket, objectName, fileName);

        return getObject(bucket, objectName);

    }

    @Override
    public File createTmpFile(String namespace, String extension) throws Exception {
        File dir = new File(fileConfig.getTmpDir(), namespace);
        dir.mkdirs();
        String fileName = fileNameCreator.create();
        if (extension != null) {
            fileName += "." + extension;
        }
        return new File(dir, fileName);
    }

    @Override
    public File createTmpFolderWithName(String namespace, String fileName) {
        StringBuilder buf = new StringBuilder();
        buf.append(fileConfig.getTmpDir()).append("/").append(namespace).append("/").append(fileNameCreator.create());
        File dir = new File(buf.toString());
        dir.mkdirs();
        return new File(dir, fileName);
    }

}
