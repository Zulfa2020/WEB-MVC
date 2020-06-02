package zulfa.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import zulfa.command.CoronaCommand;
import zulfa.dto.CoronaDTO;
import zulfa.service.CoronaService;
@Controller
public class CoronaPatientRegistration {
@Autowired
	private CoronaService service;

@GetMapping("/corona.htm")
public String showForm(@ModelAttribute("patCmd") CoronaCommand cmd) {
	cmd.setLocation("Hyderabad"); cmd.setHospital("Apollo Hospitals");
	//return LVN
	return "corona_patient_register";
}//method

@PostMapping("/corona.htm")
public String processForm(Map<String,Object> map,@ModelAttribute("patCmd") CoronaCommand cmd, BindingResult br) {
	CoronaDTO dto=null;
	String result=null;
	//convert dto to bo
	dto=new CoronaDTO();
	BeanUtils.copyProperties(cmd, dto);
	//use service
	result=service.register(dto);
	//keep result in model attribute
	map.put("resMsg", result);
	//return LVN
	return "show_result";
	
	
}//method

}
