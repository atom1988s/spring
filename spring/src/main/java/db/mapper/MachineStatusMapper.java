package db.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import db.model.MachineStatus;

@Repository
public interface MachineStatusMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table machine_status
	 * @mbggenerated  Fri Apr 27 09:06:28 JST 2018
	 */
	int deleteByPrimaryKey(Integer statusId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table machine_status
	 * @mbggenerated  Fri Apr 27 09:06:28 JST 2018
	 */
	int insert(MachineStatus record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table machine_status
	 * @mbggenerated  Fri Apr 27 09:06:28 JST 2018
	 */
	int insertSelective(MachineStatus record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table machine_status
	 * @mbggenerated  Fri Apr 27 09:06:28 JST 2018
	 */
	MachineStatus selectByPrimaryKey(Integer statusId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table machine_status
	 * @mbggenerated  Fri Apr 27 09:06:28 JST 2018
	 */
	int updateByPrimaryKeySelective(MachineStatus record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table machine_status
	 * @mbggenerated  Fri Apr 27 09:06:28 JST 2018
	 */
	int updateByPrimaryKey(MachineStatus record);

	List<MachineStatus> selectAll();
}