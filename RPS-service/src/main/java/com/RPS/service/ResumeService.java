package com.RPS.service;

import com.RPS.model.ResumeDto;

import java.util.List;

/**
 * Created by Administrator on 2016/4/29.
 */
public interface ResumeService {

    /**
     * 分页查询简历
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ResumeDto> findAllAndPage(int pageNum,int pageSize,String title);

    /**
     * 查询通过id
     * @param id
     * @return
     */
    ResumeDto findById(int id);
}
