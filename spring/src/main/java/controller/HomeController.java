package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import service.MachineService;

/**
 * HomeController
 * �z�[����ʃR���g���[���[
 * @author dgic
 *
 */
@Controller
@RequestMapping(path = "/")
public class HomeController {

	@Autowired
	MachineService machineService;

	//�z�[����ʕ\��
	
	public String view(Model model) {
		return "index";
	}

	//�}�V�����X�g��ʂփ��_�C���N�g
	@RequestMapping(path = "/machine", params="gotoList")
	public String gotoListView(Model model) {
		return "redirect:./list";
	}

}
