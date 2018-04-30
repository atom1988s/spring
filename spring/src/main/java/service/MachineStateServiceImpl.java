package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import db.model.MachineState;
import logic.MachineLogic;
import logic.MachineStateLogic;

@Service
public class MachineStateServiceImpl implements MachineStateService{

	@Autowired
	MachineStateLogic machineStateLogic;
	
	@Override
	public List<MachineState> getMachineStateAll() {
		// TODO Auto-generated method stub
		return machineStateLogic.getMachineStateAll();
	}

}
