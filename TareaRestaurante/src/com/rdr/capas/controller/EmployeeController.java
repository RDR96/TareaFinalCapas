package com.rdr.capas.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rdr.capas.domain.Branch;
import com.rdr.capas.domain.Employee;
import com.rdr.capas.services.BranchInterface;
import com.rdr.capas.services.EmployeeInterface;



@Controller
public class EmployeeController {
	
	@Autowired
	BranchInterface branchService;
	
	@Autowired
	EmployeeInterface employeeService;
	
	@RequestMapping("/create-new-employee")
	public ModelAndView createNewEmployee(@RequestParam String branch_id) {		
		ModelAndView mav = new ModelAndView();
			
		Employee employee = new Employee();					
		
		mav.addObject("employee", employee);
		mav.addObject("mensajeBoton", "Regresar");
		mav.addObject("branchId", Integer.parseInt(branch_id) );
		mav.addObject("pageToRedirect", "edit");
		
		mav.setViewName("employeeInfo");	
		return mav;
	}	
	
	@RequestMapping("/create-employee")
	public String createEmployee(@ModelAttribute Employee employee, @RequestParam String branchId,RedirectAttributes redirectAttributes) {
		employee.setBranch(branchService.getOne(Integer.parseInt(branchId)));
		employeeService.create(employee);		
							
		redirectAttributes.addAttribute("id", branchId );
		
		return "redirect:/edit";
	}	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	

	
}
