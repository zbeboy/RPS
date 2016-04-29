package com.RPS.service;

import com.RPS.dao.EnterpriseDtoMapper;
import com.RPS.model.EnterpriseDto;
import com.RPS.model.EnterpriseDtoExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/4/29.
 */
@Service("enterpriseService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EnterpriseServiceImpl implements EnterpriseService{
    @Resource
    private EnterpriseDtoMapper enterpriseDtoMapper;


    @Override
    public EnterpriseDto findByUsername(String username) {
        EnterpriseDtoExample enterpriseDtoExample = new EnterpriseDtoExample();
        EnterpriseDtoExample.Criteria cr = enterpriseDtoExample.createCriteria();
        cr.andUsernameEqualTo(username);
        List<EnterpriseDto> enterpriseDtoList = enterpriseDtoMapper.selectByExample(enterpriseDtoExample);
        if(!enterpriseDtoList.isEmpty()&&enterpriseDtoList.size()>0){
            return enterpriseDtoList.get(0);
        }
        return null;
    }
}
