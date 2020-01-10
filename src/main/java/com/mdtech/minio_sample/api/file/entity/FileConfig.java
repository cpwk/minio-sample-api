package com.mdtech.minio_sample.api.file.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "fs", ignoreUnknownFields = false)
@Validated
@Component
public class FileConfig {

    @NotNull
    private String tmpDir;

    public String getTmpDir() {
        return tmpDir;
    }

    public void setTmpDir(String tmpDir) {
        this.tmpDir = tmpDir;
    }

}
