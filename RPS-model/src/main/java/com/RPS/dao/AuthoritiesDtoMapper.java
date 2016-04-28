package com.RPS.dao;

import com.RPS.model.AuthoritiesDto;
import com.RPS.model.AuthoritiesDtoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthoritiesDtoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authorities
     *
     * @mbggenerated Wed Apr 27 21:55:11 CST 2016
     */
    int countByExample(AuthoritiesDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authorities
     *
     * @mbggenerated Wed Apr 27 21:55:11 CST 2016
     */
    int deleteByExample(AuthoritiesDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authorities
     *
     * @mbggenerated Wed Apr 27 21:55:11 CST 2016
     */
    int insert(AuthoritiesDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authorities
     *
     * @mbggenerated Wed Apr 27 21:55:11 CST 2016
     */
    int insertSelective(AuthoritiesDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authorities
     *
     * @mbggenerated Wed Apr 27 21:55:11 CST 2016
     */
    List<AuthoritiesDto> selectByExample(AuthoritiesDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authorities
     *
     * @mbggenerated Wed Apr 27 21:55:11 CST 2016
     */
    int updateByExampleSelective(@Param("record") AuthoritiesDto record, @Param("example") AuthoritiesDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authorities
     *
     * @mbggenerated Wed Apr 27 21:55:11 CST 2016
     */
    int updateByExample(@Param("record") AuthoritiesDto record, @Param("example") AuthoritiesDtoExample example);
}