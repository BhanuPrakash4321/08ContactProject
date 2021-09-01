package in.bhanuit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.bhanuit.entity.Contact;
import in.bhanuit.service.ContactService;

@Controller
public class ViewContactController {

	@Autowired
	private ContactService service;
	
	@GetMapping("/edit")
	public String editContact(@RequestParam("cid")Integer contactId, Model model) {
	 Contact contact = service.getContactById(contactId);
	 model.addAttribute("contact", contact);
	 return "conatctInfo";
	}
	
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("cid")Integer contactId, Model model) {
	 service.getContactById(contactId);
	 return "redirect:viewconatcts";
	}
}
