package com.RPS.service;

import com.RPS.dao.AuthoritiesDtoMapper;
import com.RPS.model.AuthoritiesDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/4/29.
 */
@Service("authoritiesService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AuthoritiesServiceImpl implements AuthoritiesService {
    @Resource
    private AuthoritiesDtoMapper authoritiesDtoMapper;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public void save(AuthoritiesDto authoritiesDto) {
        authoritiesDtoMapper.insert(authoritiesDto);
    }
}
