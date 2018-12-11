package com.serv.DojoNinjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.serv.DojoNinjas.models.Ninja;
import com.serv.DojoNinjas.services.DojoService;
import com.serv.DojoNinjas.services.NinjaService;

@Controller
public class NinjasControllers {
	private final DojoService ds;
	private final NinjaService ns;
	
	public NinjasControllers(DojoService ds, NinjaService ns) {
		this.ds = ds;
		this.ns = ns;
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("allDojos", ds.findAllDojos());
		return "/ninjas/new.jsp";
	}
	
	@PostMapping("/ninjas")
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "/ninjas/new.jsp";
		}
		else {
			Ninja createdNinja = ns.createNinja(ninja);
			return "redirect:/dojos/" + createdNinja.getDojo().getId();
		}
	}
	
}
