package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import db.mapper.MachineStateMapper;
import db.mapper.MachineStatusMapper;
import db.model.MachineStatus;

@Component
public class MachineStatusLogicImpl implements MachineStatusLogic{

	@Autowired
	private MachineStatusMapper mapper;
	
	@Override
	public List<MachineStatus> getMachineStatusAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

}
