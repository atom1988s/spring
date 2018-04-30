package logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import db.mapper.MachineMapper;
import db.model.Machine;
import result.MachineListResult;
import result.MachineResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Component
public class MachineLogicImpl implements MachineLogic{

	@Autowired
	private MachineMapper mapper;
	
	@Override
	public MachineListResult getAllMachines() {
		// TODO Auto-generated method stub
		MachineListResult result = mapper.selectAll();
		
		return result;
	}

	@Override
	public int insert(Machine machine) {
		// TODO Auto-generated method stub
		int result = 0;
		if(null == mapper.selectByPrimaryKey(machine.getName())) {
			result = mapper.insertSelective(machine);
		}
		return result;
	}

	@Override
	public Machine getMachine(String machineName) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(machineName);
	}

	@Override
	public void editMachine(Machine machine) {
		// TODO Auto-generated method stub
		mapper.updateByPrimaryKeySelective(machine);
	}
	
	private List<MachineResult> getDammyAllMachines(Pageable pageable,String name) {
		List<MachineResult> results = new ArrayList<MachineResult>();
		for(int i = 1; i <= 132; i ++) {
			MachineResult machineResult = new MachineResult();
			machineResult.setUserId(String.valueOf(i));
			machineResult.setSerialNo(String.valueOf(i));
			if(i % 3 == 0) {
				machineResult.setStatusId(1);
				machineResult.setStatusName("�\����");
			}else if(i % 2 == 0) {
				machineResult.setStatusId(2);
				machineResult.setStatusName("�g�p��");
			}else {
				machineResult.setStatusId(3);
				machineResult.setStatusName("���g�p");
			}
			
			if(i % 2 == 0) {
				machineResult.setStateId(1);
				machineResult.setStateName("����");
			}else if(i % 5 == 0) {
				machineResult.setStateId(2);
				machineResult.setStateName("�̏�");
			}else {
				machineResult.setStateId(3);
				machineResult.setStateName("�s���s��");
			}
			
			machineResult.setDelFlg(0);
			machineResult.setName("PC" + i);
			machineResult.setUserName(i + "���Y");
			results.add(machineResult);
			
		}
		return results;
	}

}
