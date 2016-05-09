package com.RPS.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Created by Administrator on 2016/5/9.
 */
public interface UploadService {
    public String upload(MultipartHttpServletRequest request, String path, String addr);
}
