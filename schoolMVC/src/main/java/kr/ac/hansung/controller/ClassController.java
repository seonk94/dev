package kr.ac.hansung.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Class;
import kr.ac.hansung.model.SI;
import kr.ac.hansung.model.ysc;
import kr.ac.hansung.service.ClassService;
import lombok.Setter;

@Controller
public class ClassController {
	
	@Setter
	int year, semester;
	
	@Autowired
	private ClassService classService;
	

	@RequestMapping("/menulist")
	public String showMenuList(Model model) {
		
		
		return "menulist";
	}
	
	@RequestMapping("/semester_credit")
	public String semester_credit(Model model) {
		
		List<ysc> YSC = classService.getYSC();
		model.addAttribute("ysc", YSC);
		
		return "semester_credit";
	}
	
	@RequestMapping("/detail")
	public String showDetail(Model model, HttpServletRequest request) {
		int year = Integer.parseInt(request.getParameter("year"));
		int semester = Integer.parseInt(request.getParameter("semester"));
		
		List<Class> Tclass = classService.getClasses_year_semester(year, semester);
		model.addAttribute("classes", Tclass);
		return "detail";
	}
	
	@RequestMapping("/division_credit")
	public String showDC(Model model) {
		
		List<SI> si = classService.getSI();
		model.addAttribute("ds", si);
		
		return "division_credit";
	}
	
	@RequestMapping("/new_class")
	public String createclass(Model model) {
		
		model.addAttribute("tclass", new Class());
		
		return "new_class";
	}
	
	@RequestMapping("/docreate")
	public String doCreate(Model model, @Valid Class tclass, BindingResult result) {
		
		classService.insert(tclass);
		
		return "classcreated";
	}
	
	
	
	@RequestMapping("/check_class")
	public String checkclass(Model model) {
		
		
		List<Class> Tclass = classService.getClasses_year_semester(2018, 1);
		model.addAttribute("classes", Tclass);
		
		return "check_class";
	}
	
}
