package com.RPS.dao;

import com.RPS.model.UsersDto;
import com.RPS.model.UsersDtoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersDtoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated Mon May 09 17:34:08 CST 2016
     */
    int countByExample(UsersDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated Mon May 09 17:34:08 CST 2016
     */
    int deleteByExample(UsersDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated Mon May 09 17:34:08 CST 2016
     */
    int deleteByPrimaryKey(String username);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated Mon May 09 17:34:08 CST 2016
     */
    int insert(UsersDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated Mon May 09 17:34:08 CST 2016
     */
    int insertSelective(UsersDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated Mon May 09 17:34:08 CST 2016
     */
    List<UsersDto> selectByExample(UsersDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated Mon May 09 17:34:08 CST 2016
     */
    UsersDto selectByPrimaryKey(String username);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated Mon May 09 17:34:08 CST 2016
     */
    int updateByExampleSelective(@Param("record") UsersDto record, @Param("example") UsersDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated Mon May 09 17:34:08 CST 2016
     */
    int updateByExample(@Param("record") UsersDto record, @Param("example") UsersDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated Mon May 09 17:34:08 CST 2016
     */
    int updateByPrimaryKeySelective(UsersDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated Mon May 09 17:34:08 CST 2016
     */
    int updateByPrimaryKey(UsersDto record);
}