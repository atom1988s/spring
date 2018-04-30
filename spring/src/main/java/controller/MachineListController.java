package controller;

import java.util.ArrayList;
import java.util.List;

import org.hsqldb.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import db.model.Machine;
import form.MachineListPageForm;
import result.MachineListResult;
import result.MachineResult;
import service.MachineService;

/**
 * MachineListController
 * �}�V�����X�g��ʃR���g���[���[
 * @author dgic
 *
 */
@SessionAttributes(value = "page")
@Controller
public class MachineListController {

	@Autowired
	MachineService machineService;

	
	@RequestMapping(path = "/machine/list")
	public String view(Model model,MachineListPageForm form) {
		
		MachineListResult machineAllList = new MachineListResult();

		//List<MachineListResult> machines = machineService.getAllMachines();
		
		//�S���擾
		machineAllList.setMachines(getDammyAllMachines());
		
		//�S����
		int machineCount = machineAllList.getMachines().size();
		
		//1�y�[�W����
		int offset = 14;
		
		//�ő�y�[�W��
		int maxPage = (int)Math.ceil((double)machineCount / (double)offset);
		
		//�w��y�[�W
		int page = form.getPage();
		//�����\���̎w��y�[�W�����̏ꍇ
		if(page == 0) {
			page = 1;
		}
		
		//�w��y�[�W���ő�y�[�W���𒴂��Ă���ꍇ�́A�ő�y�[�W����Ԃ��B
		if(maxPage < page) {
			page = maxPage;
		}
		
		//�ő�O�Ő�
		int prePage = 8;
		
		//�ő��Ő�
		int postPage = 8;

		//�\���\�y�[�W�ԍ��̌���
		//���݃y�[�W����߂邱�Ƃ��ł���y�[�W�̌���
		int beginOffset; 
		if(page - prePage < 1) {
			beginOffset = 1;
		}else {
			beginOffset = page - prePage;
		}
		//���݃y�[�W����i�ނ��Ƃ��ł���y�[�W�̌���
		int endOffset;
		if(maxPage < page + postPage) {
			endOffset = maxPage;
		}else {
			endOffset = page + postPage;
		}
		
		//�\�������͈͂̌���
		//�͈͂̍ŏ��̌����ڌ���
		int beginCount;
		beginCount = page * offset - offset + 1;
		//�͈͂̍Ō�̌����ڌ���
		int endCount = page * offset;
		if(machineCount < endCount) {
			endCount = machineCount;
		}
		//�ԋp�f�[�^�쐬
		MachineListResult machineListResult = new MachineListResult(); 
		
		//�͈͕��̃f�[�^��ԋp�f�[�^�֒ǉ�
		List<MachineResult> viewMachines = new ArrayList<MachineResult>();	
		for(int i = beginCount; i <= endCount; i ++) {
			MachineResult machineResult = machineAllList.getMachines().get(i-1);
			viewMachines.add(machineResult);
		}
		
		//�ԋp���ʂւ̃f�[�^�ǉ�
		machineListResult.setMachines(viewMachines);
		machineListResult.setMaxViewOffset(endOffset);
		machineListResult.setMinViewOffset(beginOffset);
		machineListResult.setMaxPage(maxPage);
		machineListResult.setCurrentOffset(page);

		model.addAttribute("machineListResult", machineListResult);
		return "machine_list";
	}
	
	private List<MachineResult> getDammyAllMachines() {
		List<MachineResult> results = new ArrayList<MachineResult>();
		for(int i = 1; i <= 9098; i ++) {
			MachineResult machineResult = new MachineResult();
			machineResult.setUserId(String.valueOf(i));
			machineResult.setSerialNo(String.valueOf(i));
			if(i % 3 == 0) {
				machineResult.setStatusId(1);
				machineResult.setStatusName("�\����");
			}else if(i % 2 == 0) {
				machineResult.setStatusId(2);
				machineResult.setStatusName("�g�p��");
			}else {
				machineResult.setStatusId(3);
				machineResult.setStatusName("���g�p");
			}
			
			if(i % 2 == 0) {
				machineResult.setStateId(1);
				machineResult.setStateName("����");
			}else if(i % 5 == 0) {
				machineResult.setStateId(2);
				machineResult.setStateName("�̏�");
			}else {
				machineResult.setStateId(3);
				machineResult.setStateName("�s���s��");
			}
			
			machineResult.setDelFlg(0);
			machineResult.setName("PC" + i);
			machineResult.setUserName(i + "���Y");
			results.add(machineResult);
			
		}
		return results;
	}

	@RequestMapping(path = "/machine/list", params="gotoRegister")
	public String gotoRegView(Machine machine,RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute(machine);		
		return "redirect:./register";	
	}

}
