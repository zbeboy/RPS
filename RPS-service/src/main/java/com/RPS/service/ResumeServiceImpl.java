package com.RPS.service;

import com.RPS.dao.ResumeDtoMapper;
import com.RPS.model.ResumeDto;
import com.RPS.model.ResumeDtoExample;
import com.RPS.model.ResumeDtoWithBLOBs;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/4/29.
 */
@Service("resumeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ResumeServiceImpl implements ResumeService{

    @Resource
    private ResumeDtoMapper resumeDtoMapper;


    @Override
    public List<ResumeDto> findAllAndPage(int pageNum, int pageSize,String title) {
        List<ResumeDto> resumeDtos = null;
        ResumeDtoExample resumeDtoExample = new ResumeDtoExample();
        ResumeDtoExample.Criteria cr = resumeDtoExample.createCriteria();
        cr.andIsPassEqualTo(1);
        cr.andIsShowEqualTo(true);
        if(StringUtils.isNotBlank(title)){
            cr.andTitleLike(title);
            PageHelper.startPage(pageNum,pageSize);
            resumeDtos = resumeDtoMapper.selectByExample(resumeDtoExample);
        } else {
            PageHelper.startPage(pageNum,pageSize);
            resumeDtos = resumeDtoMapper.selectByExample(resumeDtoExample);
        }
        return resumeDtos;
    }

    @Override
    public ResumeDto findById(int id) {
        ResumeDto resumeDto = resumeDtoMapper.selectByPrimaryKey(id);
        return resumeDto;
    }

    @Override
    public void save(ResumeDtoWithBLOBs resumeDtoWithBLOBs) {
        resumeDtoMapper.insert(resumeDtoWithBLOBs);
    }

    @Override
    public List<ResumeDto> findAllByUsernameAndPage(String username, int pageNum, int pageSize) {
        ResumeDtoExample resumeDtoExample = new ResumeDtoExample();
        ResumeDtoExample.Criteria cr = resumeDtoExample.createCriteria();
        cr.andUsernameEqualTo(username);
        PageHelper.startPage(pageNum,pageSize);
        List<ResumeDto> resumeDtos = resumeDtoMapper.selectByExample(resumeDtoExample);
        return resumeDtos;
    }
}
