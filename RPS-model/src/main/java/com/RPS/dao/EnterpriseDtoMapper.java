package com.RPS.dao;

import com.RPS.model.EnterpriseDto;
import com.RPS.model.EnterpriseDtoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnterpriseDtoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    int countByExample(EnterpriseDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    int deleteByExample(EnterpriseDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    int insert(EnterpriseDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    int insertSelective(EnterpriseDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    List<EnterpriseDto> selectByExampleWithBLOBs(EnterpriseDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    List<EnterpriseDto> selectByExample(EnterpriseDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    EnterpriseDto selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    int updateByExampleSelective(@Param("record") EnterpriseDto record, @Param("example") EnterpriseDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    int updateByExampleWithBLOBs(@Param("record") EnterpriseDto record, @Param("example") EnterpriseDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    int updateByExample(@Param("record") EnterpriseDto record, @Param("example") EnterpriseDtoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    int updateByPrimaryKeySelective(EnterpriseDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    int updateByPrimaryKeyWithBLOBs(EnterpriseDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise
     *
     * @mbggenerated Fri Apr 29 16:52:26 CST 2016
     */
    int updateByPrimaryKey(EnterpriseDto record);
}