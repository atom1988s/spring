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
 * マシンリスト画面コントローラー
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
		
		//全権取得
		machineAllList.setMachines(getDammyAllMachines());
		
		//全件数
		int machineCount = machineAllList.getMachines().size();
		
		//1ページ件数
		int offset = 14;
		
		//最大ページ数
		int maxPage = (int)Math.ceil((double)machineCount / (double)offset);
		
		//指定ページ
		int page = form.getPage();
		//初期表示の指定ページ無しの場合
		if(page == 0) {
			page = 1;
		}
		
		//指定ページが最大ページ数を超えている場合は、最大ページ数を返す。
		if(maxPage < page) {
			page = maxPage;
		}
		
		//最大前頁数
		int prePage = 8;
		
		//最大後頁数
		int postPage = 8;

		//表示可能ページ番号の決定
		//現在ページから戻ることができるページの決定
		int beginOffset; 
		if(page - prePage < 1) {
			beginOffset = 1;
		}else {
			beginOffset = page - prePage;
		}
		//現在ページから進むことができるページの決定
		int endOffset;
		if(maxPage < page + postPage) {
			endOffset = maxPage;
		}else {
			endOffset = page + postPage;
		}
		
		//表示件数範囲の決定
		//範囲の最初の件数目決定
		int beginCount;
		beginCount = page * offset - offset + 1;
		//範囲の最後の件数目決定
		int endCount = page * offset;
		if(machineCount < endCount) {
			endCount = machineCount;
		}
		//返却データ作成
		MachineListResult machineListResult = new MachineListResult(); 
		
		//範囲分のデータを返却データへ追加
		List<MachineResult> viewMachines = new ArrayList<MachineResult>();	
		for(int i = beginCount; i <= endCount; i ++) {
			MachineResult machineResult = machineAllList.getMachines().get(i-1);
			viewMachines.add(machineResult);
		}
		
		//返却結果へのデータ追加
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
				machineResult.setStatusName("申請中");
			}else if(i % 2 == 0) {
				machineResult.setStatusId(2);
				machineResult.setStatusName("使用中");
			}else {
				machineResult.setStatusId(3);
				machineResult.setStatusName("未使用");
			}
			
			if(i % 2 == 0) {
				machineResult.setStateId(1);
				machineResult.setStateName("正常");
			}else if(i % 5 == 0) {
				machineResult.setStateId(2);
				machineResult.setStateName("故障");
			}else {
				machineResult.setStateId(3);
				machineResult.setStateName("行方不明");
			}
			
			machineResult.setDelFlg(0);
			machineResult.setName("PC" + i);
			machineResult.setUserName(i + "太郎");
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
