package com.RPS.service;

import com.RPS.model.ResumeDto;
import com.RPS.model.ResumeDtoWithBLOBs;

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
    ResumeDtoWithBLOBs findById(int id);

    /**
     * 保存
     * @param resumeDtoWithBLOBs
     */
    void save(ResumeDtoWithBLOBs resumeDtoWithBLOBs);

    /**
     * 通过 username查询简历并分页
     * @param username
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ResumeDto> findAllByUsernameAndPage(String username,int pageNum,int pageSize);

    /**
     * 更新
     * @param resumeDtoWithBLOBs
     */
    void update(ResumeDtoWithBLOBs resumeDtoWithBLOBs);

    /**
     * 删除
     * @param id
     */
    void deleteById(int id);

    /**
     * 查询所有未通过或未审核的简历
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ResumeDto> findAllByIsPassAndPage(int pageNum,int pageSize);
}
