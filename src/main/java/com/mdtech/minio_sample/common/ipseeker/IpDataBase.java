package com.mdtech.minio_sample.common.ipseeker;

import com.mdtech.minio_sample.common.util.R;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 管理Ip库
 *
 * @author Cweili
 * @version 2013-4-16 下午3:42:50
 */
public class IpDataBase {

    private static final String IP_FILE = "resources/qqwry.dat";
    private static String TMP_FILE = "ip.tmp";

    private static final Log log = LogFactory.getLog(IpDataBase.class);
    private static final IpDataBase instance = new IpDataBase();

    private IpDataBase() {
//        TMP_FILE = this.getClass().getResource("/").getPath().toString() + TMP_FILE;

        String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        int firstIndex = path.lastIndexOf(System.getProperty("path.separator")) + 1;
        int lastIndex = path.lastIndexOf(File.separator) + 1;
        path = path.substring(firstIndex, lastIndex);
        System.out.println(path);
        TMP_FILE = path + TMP_FILE;
        System.out.println(TMP_FILE);

    }

    public static IpDataBase getInstance() {
        return instance;
    }

    /**
     * 返回Ip库路径
     *
     * @return
     */
    public String getIpFile() {
        if (!new File(TMP_FILE).exists()) {
            writeIpFile();
        }
        return TMP_FILE;
    }

    /**
     * 返回文件路径
     *
     * @return 返回文件路径
     */
    private void writeIpFile() {
        InputStream is = R.getStream(IP_FILE);
        OutputStream os = null;
        try {
            os = new FileOutputStream(TMP_FILE);
            byte buffer[] = new byte[1024];

            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

            os.flush();
        } catch (Exception e) {
            log.error(e);
        } finally {
            try {
                os.close();
            } catch (Exception e) {
                log.error(e);
            }
        }
    }
}
