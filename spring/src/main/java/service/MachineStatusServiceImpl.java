package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import db.model.MachineStatus;
import logic.MachineStateLogic;
import logic.MachineStatusLogic;

@Service
public class MachineStatusServiceImpl implements MachineStatusService{

	@Autowired
	MachineStatusLogic machineStatusLogic;
	
	@Override
	public List<MachineStatus> getMachineStatusAll() {
		// TODO Auto-generated method stub
		return machineStatusLogic.getMachineStatusAll();
	}

}
