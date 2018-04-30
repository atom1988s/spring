package service;

import db.model.Machine;
import result.MachineListResult;

public interface MachineService {
	public MachineListResult getAllMachines();

	public int insert(Machine machine);

	public Machine getMachine(String machineName);

	public void editMachine(Machine machine);
}
