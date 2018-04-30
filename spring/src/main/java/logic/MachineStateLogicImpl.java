package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import db.mapper.MachineMapper;
import db.mapper.MachineStateMapper;
import db.model.MachineState;

@Component
public class MachineStateLogicImpl implements MachineStateLogic{

	@Autowired
	private MachineStateMapper mapper;
	
	@Override
	public List<MachineState> getMachineStateAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

}
