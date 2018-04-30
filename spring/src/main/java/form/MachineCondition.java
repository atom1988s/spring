package form;

import java.util.List;
import java.util.Map;

import db.model.MachineState;
import db.model.MachineStatus;


public class MachineCondition {
	private List<MachineStatus> statusList;

	private List<MachineState> stateList;

	public List<MachineStatus> getStatusList() {
		return statusList;
	}
	public void setStatusList(List<MachineStatus> statusList) {
		this.statusList = statusList;
	}
	
	public List<MachineState> getStateList() {
		return stateList;
	}
	public void setStateList(List<MachineState> stateList2) {
		this.stateList = stateList2;
	}

	
	
}
