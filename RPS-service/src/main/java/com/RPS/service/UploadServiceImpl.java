package com.RPS.service;

import com.RPS.util.IPTimeStamp;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/5/9.
 */
@Service("uploadService")
public class UploadServiceImpl implements UploadService {
    private static Logger logger = Logger.getLogger(UploadServiceImpl.class);

    @Override
    public String upload(MultipartHttpServletRequest request, String path, String addr) {
        String lastPath = null;
        try {
            //1. build an iterator
            Iterator<String> itr = request.getFileNames();
            MultipartFile mpf = null;
            List<String> list = new ArrayList<String>();

            //2. get each file
            while (itr.hasNext()) {
                //2.1 get next MultipartFile
                mpf = request.getFile(itr.next());
                logger.info(mpf.getOriginalFilename() + " uploaded! ");
                list.add(mpf.getContentType());
                IPTimeStamp ipTimeStamp = new IPTimeStamp(addr);
                String[] words = mpf.getOriginalFilename().split("\\.");
                String disk = path.split(":")[0];
                String ext = null;
                String filename = null;
                File file = null;
                File saveFile = null;
                if (words.length > 1) {
                    ext = words[words.length - 1];
                    filename = ipTimeStamp.getIPTimeRand() + "." + ext;
                    if (filename.contains(":")) {
                        filename = filename.substring(filename.lastIndexOf(":") + 1, filename.length());
                    }
                    // copy file to local disk (make sure the path "e.g. D:/temp/files" exists)
                    if (StringUtils.isNotEmpty(disk)) {
                        file = new File(disk + ":");
                        saveFile = new File(path, filename);
                        if (mpf.getSize() < file.getFreeSpace()) {
                            //构建路径
                            if (!saveFile.getParentFile().exists()) {
                                saveFile.getParentFile().mkdirs();
                            }
                            logger.info(path);
                            FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(path + File.separator + filename));
                            lastPath = path + File.separator + filename;
                        } else {
                            logger.info("not valiablespace!");
                            return null;
                        }
                    } else {
                        logger.info("get disk fail!");
                        return null;
                    }
                } else {
                    //没有文件名
                    filename = ipTimeStamp.getIPTimeRand();
                    // copy file to local disk (make sure the path "e.g. D:/temp/files" exists)
                    if (!StringUtils.isNotEmpty(disk)) {
                        file = new File(disk + ":");
                        if (mpf.getSize() < file.getFreeSpace()) {
                            //构建路径
                            if (!saveFile.getParentFile().exists()) {
                                saveFile.getParentFile().mkdirs();
                            }
                            logger.info(path);
                            FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(path + File.separator + filename));
                            lastPath = path + File.separator + filename;
                        } else {
                            logger.info("not valiablespace!");
                            return null;
                        }
                    } else {
                        logger.info("get disk fail!");
                        return null;
                    }
                }
            }
        } catch (IOException e) {
            logger.error("upload fail! " + e.getMessage() + " " + e.getStackTrace());
            return null;
        }
        return lastPath;
    }
}
