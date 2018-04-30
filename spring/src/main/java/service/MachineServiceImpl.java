package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import db.model.Machine;
import logic.MachineLogic;
import result.MachineListResult;
import result.MachineResult;

@Component
public class MachineServiceImpl implements MachineService{

	@Autowired
	MachineLogic machineLogic;
	
	@Transactional(readOnly = true)
	@Override
	public MachineListResult getAllMachines() {
		// TODO Auto-generated method stub
		return machineLogic.getAllMachines();
	}
	
	@Transactional
	@Override
	public int insert(Machine machine) {
		return machineLogic.insert(machine); 
	}

	@Override
	public Machine getMachine(String machineName) {
		return machineLogic.getMachine(machineName); 
	}

	@Override
	public void editMachine(Machine machine) {
		machineLogic.editMachine(machine); 
	}
	
}
