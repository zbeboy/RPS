package com.RPS.service;

import com.RPS.model.PersonalDto;

/**
 * Created by Administrator on 2016/4/29.
 */
public interface PersonalService {

    /**
     * save
     * @param personalDto
     */
    void save(PersonalDto personalDto);

    /**
     * 通过用户名查询
     * @param username
     */
    PersonalDto findByUsername(String username);

    /**
     * update
     * @param personalDto
     */
    void update(PersonalDto personalDto);
}
