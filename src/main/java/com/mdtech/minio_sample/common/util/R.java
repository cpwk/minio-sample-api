package com.mdtech.minio_sample.common.util;

import com.sunnysuperman.commons.util.FileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class R {

    public static InputStream getStream(String path) {
        return R.class.getResourceAsStream("/resources/" + path);
    }

    public static URL getResource(String path) {
        return R.class.getResource("/resources/" + path);
    }

    public static byte[] getBytes(String path) {
        try {
            return FileUtil.readAsByteArray(getStream(path));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
