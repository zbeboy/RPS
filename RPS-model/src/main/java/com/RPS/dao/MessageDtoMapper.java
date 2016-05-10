package com.RPS.dao;

import com.RPS.model.MessageDto;
import com.RPS.model.MessageDtoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageDtoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbggenerated Tue May 10 21:54:22 CST 2016
     */
    int countByExample(MessageDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbggenerated Tue May 10 21:54:22 CST 2016
     */
    int deleteByExample(MessageDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbggenerated Tue May 10 21:54:22 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbggenerated Tue May 10 21:54:22 CST 2016
     */
    int insert(MessageDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbggenerated Tue May 10 21:54:22 CST 2016
     */
    int insertSelective(MessageDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbggenerated Tue May 10 21:54:22 CST 2016
     */
    List<MessageDto> selectByExample(MessageDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbggenerated Tue May 10 21:54:22 CST 2016
     */
    MessageDto selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbggenerated Tue May 10 21:54:22 CST 2016
     */
    int updateByExampleSelective(@Param("record") MessageDto record, @Param("example") MessageDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbggenerated Tue May 10 21:54:22 CST 2016
     */
    int updateByExample(@Param("record") MessageDto record, @Param("example") MessageDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbggenerated Tue May 10 21:54:22 CST 2016
     */
    int updateByPrimaryKeySelective(MessageDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbggenerated Tue May 10 21:54:22 CST 2016
     */
    int updateByPrimaryKey(MessageDto record);
}