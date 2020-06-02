package zulfa.controller;

import javax.servlet.http.HttpSession;

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
import zulfa.validator.PatientCommandValidator;
@Controller
public class CoronaPatientRegistration {
	@Autowired
	private CoronaService service;
	@Autowired
	private PatientCommandValidator  validator;
	
	@ModelAttribute("patCmd")
	public CoronaCommand  getPatientCommand() {
		System.out.println("getPatientCommand()");
		return new CoronaCommand();
	}
	
	@GetMapping("/corona.htm")   //for Initial Phase request
	public  String  showForm(@ModelAttribute("patCmd") CoronaCommand cmd ) {
		cmd.setLocation("hyd");  cmd.setHospital("Gandhi Hospital");
		System.out.println("PatientOperationsController.showForm()");
		//return LVN
		return "patient_registration";
	}
	
	@PostMapping("/corona.htm")   //for POST back request
	public String  processForm(HttpSession ses,
			                                              @ModelAttribute("patCmd") CoronaCommand cmd,
			                                              BindingResult br) {
		System.out.println("PatientOperationsController.processForm()");
		CoronaDTO  dto=null;
		String result=null;
		
		
		
		// call supports(-) ,validator(-) methods
		if(validator.supports(CoronaCommand.class)) {
				  validator.validate(cmd, br);
		       if(br.hasErrors())
		    	   return "patient_registration";
		}
		
		//Application logic errors
		if(cmd.getLocation().equalsIgnoreCase("hyd")) {
			  br.rejectValue("location", "hyd.blocked");
			  return  "patient_registration";
		}
		
		//convert cmd to  dto
		dto=new CoronaDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		result=service.register(dto);
		
		//keep result in model attribute-(SESSION SCOPE IS BEST MODEL)
		ses.setAttribute("resMsg", result);
		//return LVN
		return "redirect:/result.htm";
		
		//1-map.put- ( Appending Query String to url)
		//2-RedirectAttribute (FlashAttribute)
		//3-HttpSession- BEST
		
	}
	
	// Solving Re-Submission and Refresh Problem
	@GetMapping("/result.htm")
	public String showResultPage() {
		System.out.println("CoronaPatientRegistration.showResultPage()");
		return "show_result";
	}

}
