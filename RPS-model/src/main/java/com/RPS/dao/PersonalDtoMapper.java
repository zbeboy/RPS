package com.RPS.dao;

import com.RPS.model.PersonalDto;
import com.RPS.model.PersonalDtoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonalDtoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personal
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    int countByExample(PersonalDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personal
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    int deleteByExample(PersonalDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personal
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personal
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    int insert(PersonalDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personal
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    int insertSelective(PersonalDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personal
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    List<PersonalDto> selectByExample(PersonalDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personal
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    PersonalDto selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personal
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    int updateByExampleSelective(@Param("record") PersonalDto record, @Param("example") PersonalDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personal
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    int updateByExample(@Param("record") PersonalDto record, @Param("example") PersonalDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personal
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    int updateByPrimaryKeySelective(PersonalDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personal
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    int updateByPrimaryKey(PersonalDto record);
}