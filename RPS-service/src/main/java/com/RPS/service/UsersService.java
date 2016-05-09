package com.RPS.service;

import com.RPS.model.UsersDto;

/**
 * Created by Administrator on 2016/4/29.
 */
public interface UsersService {

    /**
     * find by username
     */
    UsersDto findByUsername(String username);

    /**
     * save
     * @param usersDto
     */
    void save(UsersDto usersDto);

    /**
     * get users by session
     * @return
     */
    UsersDto getUserBySession();

    /**
     * 检查当前用户是否有此权限
     *
     * @param authority
     * @return
     */
    boolean isCurrentUserInRole(String authority);

    /**
     * update
     * @param usersDto
     */
    void update(UsersDto usersDto);
}
