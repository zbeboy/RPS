package com.RPS.service;

import com.RPS.model.EnterpriseDto;

/**
 * Created by Administrator on 2016/4/29.
 */
public interface EnterpriseService {

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    EnterpriseDto findByUsername(String username);
}
