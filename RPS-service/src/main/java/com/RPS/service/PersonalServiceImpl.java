package com.RPS.service;

import com.RPS.dao.PersonalDtoMapper;
import com.RPS.model.PersonalDto;
import com.RPS.model.PersonalDtoExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public PersonalDto findByUsername(String username) {
        PersonalDtoExample personalDtoExample = new PersonalDtoExample();
        PersonalDtoExample.Criteria  cr = personalDtoExample.createCriteria();
        cr.andUsernameEqualTo(username);
        List<PersonalDto> personalDtos = personalDtoMapper.selectByExample(personalDtoExample);
        if(!personalDtos.isEmpty()&&personalDtos.size()>0){
            return personalDtos.get(0);
        } else {
            return null;
        }
    }
}
