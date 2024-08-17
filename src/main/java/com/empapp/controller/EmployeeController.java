package com.empapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.empapp.dto.EmployeeDto;
import com.empapp.entity.Employee;
import com.empapp.service.EmailService;
import com.empapp.service.EmployeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeService employeeService;
	@Autowired
	private EmailService emailService;

	// http://localhost:8080/viewAddEmployee
	@RequestMapping("/viewAddEmployee")
	public String viewAddEmployeePage() {
		return "NewFile";
	}

//       @RequestMapping("/addEmployee")
//       public String addEmployee(Employee emp,ModelMap map) {
//    	   map.addAttribute("msg", "record is saved!");
//    	   employeeService.addEmployee(emp);
//    	   return "NewFile";
//       }

//	@RequestMapping("/addEmployee")
//        public String addEmployee(Employee emp) {
//        	System.out.println(emp.getName());
//        	System.out.println(emp.getMobile());
//        	System.out.println(emp.getEmail());
//        	return "NewFile";
//        }

//	@RequestMapping("/addEmployee")
//    public String addEmployee(
//    		@RequestParam String firstName,
//    		@RequestParam String email,
//    		@RequestParam String mobile,
//    		ModelMap map) {
//		Employee emp = new Employee();
//		emp.setName(firstName);
//		emp.setEmail(email);
//		emp.setMobile(mobile);
//		employeeService.addEmployee(emp);
// 	   map.addAttribute("msg", "record is saved!");
// 	   
// 	   return "NewFile";
// 	   

	@RequestMapping("/addEmployee")
	public String addEmployee(EmployeeDto empDto, ModelMap map) {
		Employee emp = new Employee();
		emp.setName(empDto.getFirstName());
		emp.setEmail(empDto.getEmail());
		emp.setMobile(empDto.getMobile());
		employeeService.addEmployee(emp);
		emailService.sendEmail(empDto.getEmail(), "Welcome", "hello karthik kaise ho bro ");
		map.addAttribute("msg", "record is saved!");
		return "NewFile";

	}

	@RequestMapping("/listEmployee")

	public String getAllEmployees(ModelMap model) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		return "list_employees";
	}

	@RequestMapping("/delete")
	public String deleteEmployee(@RequestParam long id, Model model) {
		employeeService.deleteEmployee(id);
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		return "list_employees";
	}

	@RequestMapping("/update")
	public String getEmployeeById(@RequestParam long id, Model model) {
		Optional<Employee> emp = employeeService.getEmployeeById(id);
		Employee employee = emp.get();
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	@RequestMapping("/updateEmployee")
	public String Employee(EmployeeDto empDto, ModelMap map) {
		Employee emp = new Employee();
		emp.setId(empDto.getId());
		emp.setName(empDto.getFirstName());
		emp.setEmail(empDto.getEmail());
		emp.setMobile(empDto.getMobile());
		employeeService.updateEmployee(emp);
		List<Employee> employees = employeeService.getAllEmployees();
		map.addAttribute("employees", employees);
		return "list_employees";

	}

}
