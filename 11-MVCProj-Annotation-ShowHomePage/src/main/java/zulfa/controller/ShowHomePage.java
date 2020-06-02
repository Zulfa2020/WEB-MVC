package zulfa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowHomePage {
	
@RequestMapping("/home.htm")

public String home() {
	return "welcome";
}

}
