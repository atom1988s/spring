package db.mapper;

import db.model.MachineWarrantyPeriod;

public interface MachineWarrantyPeriodMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table machine_warranty_period
     *
     * @mbggenerated Fri Apr 27 09:06:28 JST 2018
     */
    int deleteByPrimaryKey(String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table machine_warranty_period
     *
     * @mbggenerated Fri Apr 27 09:06:28 JST 2018
     */
    int insert(MachineWarrantyPeriod record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table machine_warranty_period
     *
     * @mbggenerated Fri Apr 27 09:06:28 JST 2018
     */
    int insertSelective(MachineWarrantyPeriod record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table machine_warranty_period
     *
     * @mbggenerated Fri Apr 27 09:06:28 JST 2018
     */
    MachineWarrantyPeriod selectByPrimaryKey(String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table machine_warranty_period
     *
     * @mbggenerated Fri Apr 27 09:06:28 JST 2018
     */
    int updateByPrimaryKeySelective(MachineWarrantyPeriod record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table machine_warranty_period
     *
     * @mbggenerated Fri Apr 27 09:06:28 JST 2018
     */
    int updateByPrimaryKey(MachineWarrantyPeriod record);
}