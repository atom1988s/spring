package db.mapper;

import db.model.Unit;

public interface UnitMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table unit
     *
     * @mbggenerated Fri Apr 27 09:06:28 JST 2018
     */
    int deleteByPrimaryKey(Integer unitId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table unit
     *
     * @mbggenerated Fri Apr 27 09:06:28 JST 2018
     */
    int insert(Unit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table unit
     *
     * @mbggenerated Fri Apr 27 09:06:28 JST 2018
     */
    int insertSelective(Unit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table unit
     *
     * @mbggenerated Fri Apr 27 09:06:28 JST 2018
     */
    Unit selectByPrimaryKey(Integer unitId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table unit
     *
     * @mbggenerated Fri Apr 27 09:06:28 JST 2018
     */
    int updateByPrimaryKeySelective(Unit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table unit
     *
     * @mbggenerated Fri Apr 27 09:06:28 JST 2018
     */
    int updateByPrimaryKey(Unit record);
}