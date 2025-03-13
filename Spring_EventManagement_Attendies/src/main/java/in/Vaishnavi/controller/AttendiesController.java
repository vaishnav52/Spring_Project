package in.Vaishnavi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.Vaishnavi.entity.AttendiesEntity;
import in.Vaishnavi.entity.EventsEntity;
import in.Vaishnavi.serviceImplementation.AttendiesServiceImpl;
import in.Vaishnavi.serviceInterface.EventServiceInterface;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/Attendies")
public class AttendiesController {
	
	@Autowired
	private AttendiesServiceImpl service;
	
	@PostMapping("adminAddAttendies")
	public String adminAddEvents(@ModelAttribute AttendiesEntity a, Model model) {
			Integer uid = service.saveAttendie(a);
			if(uid>0)
			{
				model.addAttribute("msg","Attendie Added");
			}
         return "AddAttendies";
	}
	
	@GetMapping("EditProfile")
	public String AttendieEditProfile( Model model, HttpSession session) {
		
		AttendiesEntity a=service.findbyEmail("");
		return "AttendieEdit";
	}
	
	

}
