package logic;

import java.util.List;

import db.model.Machine;
import result.MachineListResult;
import result.MachineResult;

public interface MachineLogic {
	public MachineListResult getAllMachines();

	public int insert(Machine machine);

	public Machine getMachine(String machineName);

	public void editMachine(Machine machine);
}
