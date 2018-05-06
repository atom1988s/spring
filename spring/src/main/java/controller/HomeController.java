package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import service.MachineService;

/**
 * HomeController
 * ホーム画面コントローラー
 * @author dgic
 *
 */
@Controller
@RequestMapping(path = "/")
public class HomeController {

	@Autowired
	MachineService machineService;

	//ホーム画面表示
	
	public String view(Model model) {
		return "index";
	}

	//マシンリスト画面へリダイレクト
	@RequestMapping(path = "/machine", params="gotoList")
	public String gotoListView(Model model) {
		return "redirect:./list";
	}

}
