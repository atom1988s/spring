package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import constant.ViewMode;
import db.model.Machine;
import db.model.MachineState;
import db.model.MachineStatus;
import form.MachineCondition;
import form.MachineResisterForm;
import service.MachineService;
import service.MachineStateService;
import service.MachineStatusService;

@Controller
public class MachineEditController {
	@Autowired
	MachineService machineService;

	@Autowired
	MachineStatusService machineStatusService;
	
	@Autowired
	MachineStateService machineStateService;
	
	@ModelAttribute
	MachineCondition setList(){
		
		MachineCondition machineCondition = new MachineCondition();
		
		List<MachineStatus> statusList = machineStatusService.getMachineStatusAll();
		machineCondition.setStatusList(statusList);
		
		List<MachineState> stateList = machineStateService.getMachineStateAll();
		machineCondition.setStateList(stateList);
		
		return machineCondition;
	}
	
	@RequestMapping(path = "/machine/edit/{machineName}")
	public String view(Model model,@PathVariable String machineName) {
		
		model.addAttribute("viewMode", ViewMode.edit.name());
		Machine machine = machineService.getMachine(machineName);
		MachineResisterForm machineResisterForm = new MachineResisterForm();
		machineResisterForm.setName(machine.getName());
		machineResisterForm.setSerialNo(machine.getSerialNo());
		machineResisterForm.setStatusId(machine.getStatusId());
		machineResisterForm.setStateId(machine.getStateId());
		model.addAttribute(machineResisterForm);
		
		return "register";
	}
	
	@RequestMapping(path = "/machine/edit", params="modify")
	public String view(Model model,MachineResisterForm machineResisterForm) {
		Machine machine = new Machine();
		machine.setName(machineResisterForm.getName());
		machine.setSerialNo(machineResisterForm.getSerialNo());
		machine.setUserId(machineResisterForm.getUserId());
		machine.setStatusId(machineResisterForm.getStatusId());
		machine.setStateId(machineResisterForm.getStateId());
		
		machineService.editMachine(machine);
		model.addAttribute(machineResisterForm);
		
		return "redirect:./list";
	}
	
	@RequestMapping(path = "/machine/edit" ,params="back")
	public String backView() {
		return "redirect:./list";
		
	}
}
