package com.RPS.service;

import com.RPS.dao.UsersDtoMapper;
import com.RPS.model.UsersDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/4/29.
 */
@Service("usersService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersDtoMapper usersDtoMapper;

    @Override
    public UsersDto findByUsername(String username) {
        UsersDto usersDto = usersDtoMapper.selectByPrimaryKey(username);
        return usersDto;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public void save(UsersDto usersDto) {
        usersDtoMapper.insert(usersDto);
    }

    @Override
    public UsersDto getUserBySession() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = null;
        String password = null;
        if (principal instanceof UserDetails) {
            username = StringUtils.trimWhitespace(((UserDetails) principal).getUsername());
            password = StringUtils.trimWhitespace(((UserDetails) principal).getPassword());
        }
        UsersDto usersDto = new UsersDto();
        usersDto.setUsername(username);
        usersDto.setPassword(password);
        return usersDto;
    }

    @Override
    public boolean isCurrentUserInRole(String authority) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null) {
            if (authentication.getPrincipal() instanceof UserDetails) {
                UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
                return springSecurityUser.getAuthorities().contains(new SimpleGrantedAuthority(authority));
            }
        }
        return false;
    }

    @Override
    public void update(UsersDto usersDto) {
        usersDtoMapper.updateByPrimaryKey(usersDto);
    }
}
