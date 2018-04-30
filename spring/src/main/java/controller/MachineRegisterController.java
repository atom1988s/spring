package controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.ViewMode;
import db.model.Machine;
import db.model.MachineState;
import db.model.MachineStatus;
import form.MachineResisterForm;
import form.MachineCondition;
import service.MachineService;
import service.MachineStateService;
import service.MachineStatusService;

@Controller
public class MachineRegisterController {
	@Autowired
	MachineService machineService;

	@Autowired
	MachineStatusService machineStatusService;
	
	@Autowired
	MachineStateService machineStateService;
	
	Logger logger = LoggerFactory.getLogger(MachineRegisterController.class);
	
	@ModelAttribute
	MachineCondition setList(){
		
		logger.info("MachineRegisterController.setList");
		MachineCondition machineCondition = new MachineCondition();
		
		List<MachineStatus> statusList = machineStatusService.getMachineStatusAll();
		machineCondition.setStatusList(statusList);
		
		List<MachineState> stateList = machineStateService.getMachineStateAll();
		machineCondition.setStateList(stateList);
		
		return machineCondition;
	}
	
	@ModelAttribute("viewMode")
	String modeSet() {
		return ViewMode.register.name();
	}
	
	
	@RequestMapping(path = "/machine/register")
	public String view(Model model,MachineResisterForm machineResisterForm) {
		return "register";
	}
	
	@RequestMapping(path = "/machine/register" ,params="insert")
	public String reg(@Valid MachineResisterForm machineResisterForm, BindingResult errors, Model model ,RedirectAttributes redirectAttributes) {
		logger.info("MachineRegisterController.reg");
		List<String> messages = new ArrayList<>();
		if(errors.hasErrors()) {
			model.addAttribute(machineResisterForm);
			return "register";
		}
		
//		if(machineResisterForm.getDelFlg() == 1) {
////			machineService.delete();
//			return gotoListView(redirectAttributes);
//		}
		
		Machine machine = new Machine();
		machine.setName(machineResisterForm.getName());
		machine.setSerialNo(machineResisterForm.getSerialNo());
		machine.setUserId(machineResisterForm.getUserId());
		machine.setStatusId(machineResisterForm.getStatusId());
		machine.setStateId(machineResisterForm.getStateId());
		
		int result = machineService.insert(machine);
		if(result == 0) {
			//　更新ミス
			messages.add(machine.getName() + "は既に登録されています");
			model.addAttribute(machineResisterForm);
			model.addAttribute("messages", messages);
			return "register";
		}

		return gotoListView(redirectAttributes);
	}

	private String gotoListView(RedirectAttributes redirectAttributes) {
			String message = "SUCCESS";
			redirectAttributes.addFlashAttribute("message",message);
			return "redirect:./list";	
	}
	
	@RequestMapping(path = "/machine/register" ,params="back")
	public String backView() {
		return "redirect:./list";
		
	}
}
