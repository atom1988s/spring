package db.mapper;

import db.model.Machine;
import result.MachineListResult;
import result.MachineResult;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface MachineMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table machine
	 * @mbggenerated  Thu Jan 18 16:48:59 JST 2018
	 */
	int deleteByPrimaryKey(String name);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table machine
	 * @mbggenerated  Thu Jan 18 16:48:59 JST 2018
	 */
	int insert(Machine record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table machine
	 * @mbggenerated  Thu Jan 18 16:48:59 JST 2018
	 */
	int insertSelective(Machine record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table machine
	 * @mbggenerated  Thu Jan 18 16:48:59 JST 2018
	 */
	Machine selectByPrimaryKey(String name);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table machine
	 * @mbggenerated  Thu Jan 18 16:48:59 JST 2018
	 */
	int updateByPrimaryKeySelective(Machine record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table machine
	 * @mbggenerated  Thu Jan 18 16:48:59 JST 2018
	 */
	int updateByPrimaryKey(Machine record);

	MachineListResult selectAll();
}