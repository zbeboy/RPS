package com.RPS.service;

import com.RPS.dao.PersonalDtoMapper;
import com.RPS.model.PersonalDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/4/29.
 */
@Service("personalService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PersonalServiceImpl implements PersonalService {
    @Resource
    private PersonalDtoMapper personalDtoMapper;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public void save(PersonalDto personalDto) {
        personalDtoMapper.insert(personalDto);
    }
}
