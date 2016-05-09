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

    /**
     * 保存企业用户
     * @param enterpriseDto
     */
    void save(EnterpriseDto enterpriseDto);

    /**
     * 更新企业信息
     * @param enterpriseDto
     */
    void update(EnterpriseDto enterpriseDto);
}
