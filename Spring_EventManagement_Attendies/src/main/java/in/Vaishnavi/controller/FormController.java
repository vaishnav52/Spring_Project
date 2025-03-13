package in.Vaishnavi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.Vaishnavi.entity.EventsEntity;
import in.Vaishnavi.entity.Form;
import in.Vaishnavi.serviceInterface.EventServiceInterface;
import in.Vaishnavi.serviceInterface.FormService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("Form")
public class FormController {

	@Autowired
	FormService service;
	@Autowired
	EventServiceInterface eService;

	@GetMapping("BookingForm")
	public String FinalForm(@RequestParam String eventCategory, Model model, HttpSession session) {
		System.out.println(eventCategory);
		String page = "";
		EventsEntity ee = eService.loadEventData(eventCategory);//whole event details is found by this metjod
		System.out.println(ee.getEventAmount());//for printing event amount on console
		model.addAttribute("uname", session.getAttribute("uname"));
		model.addAttribute("umail", session.getAttribute("umail"));
		model.addAttribute("uphone", session.getAttribute("uphone"));

		model.addAttribute("formData", ee);
		page = "FinalForm";

		return page;
	}

	@PostMapping("saveForm")
	public String saveForm(@ModelAttribute Form form, Model model) {
		String page = "";
		int ref = service.save(form);
		if (ref > 0) {
			model.addAttribute("message", "Booking succesfull");
			page = "FinalForm";
		} else {
			model.addAttribute("message", "Booking failed");
			page = "Home";
		}
		return page;
	}
}
