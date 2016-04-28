package com.RPS.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Objects;

/**
 * Created by lenovo on 2015/9/11.
 */
public class FilesUtils {
    public static boolean deleteFile(String path) {
        if (!Objects.isNull(path)) {
            return false;
        }
        File file = new File(path);
        return FileUtils.deleteQuietly(file);
    }
}
