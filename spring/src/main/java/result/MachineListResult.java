package result;

import java.util.ArrayList;
import java.util.List;

public class MachineListResult {
	List<MachineResult> machines = new ArrayList<MachineResult>();
	int currentOffset;
	int maxViewOffset;
	int minViewOffset;
	int currentPage;
	int maxPage;
	public int getCurrentOffset() {
		return currentOffset;
	}

	public void setCurrentOffset(int currentOffset) {
		this.currentOffset = currentOffset;
	}

	public int getMaxViewOffset() {
		return maxViewOffset;
	}

	public void setMaxViewOffset(int maxViewOffset) {
		this.maxViewOffset = maxViewOffset;
	}

	public int getMinViewOffset() {
		return minViewOffset;
	}

	public void setMinViewOffset(int minViewOffset) {
		this.minViewOffset = minViewOffset;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public List<MachineResult> getMachines() {
		return machines;
	}

	public void setMachines(List<MachineResult> list) {
		this.machines = list;
	}
}
