package com.nicolas.elcodigo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@GetMapping("/code")
	public String code(Model m) {
		String[] val = {"lealtad","coraje","veracidad","compasion","honor"};
		m.addAttribute("lista",val);
		return "codigo.jsp";
	}
	
	@RequestMapping(value="/validar",method=RequestMethod.POST)
	public String validar(@RequestParam(value="codigo") String codigo,
			Model model,RedirectAttributes r ) {
		if(!codigo.equals("bushido")) {
			r.addFlashAttribute("error","You must train harder!");
			return "redirect:/";
		}
		return "redirect:/code";
	}
}
