package com.serv.DojoNinjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.serv.DojoNinjas.models.Dojo;
import com.serv.DojoNinjas.services.DojoService;

@Controller
public class DojosController {
	private final DojoService ds;
	
 
	
	public DojosController(DojoService ds) {
		this.ds = ds;
	}

	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) { //*creates a new Dojo//
		return "/dojos/new.jsp";
	}
	
	@PostMapping("/dojos")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojos/new.jsp";
		}
		else {
			Dojo createDojo = ds.createDojo(dojo);
			return "redirect:/dojos/" + createDojo.getId();
		}
	}
	
	@GetMapping("/dojos/{dojoId}")
	public String show(@PathVariable("dojoId") Long dojoId, Model model) {
		Dojo dojo = ds.findDojo(dojoId);
		model.addAttribute("dojo", dojo);
		return "/dojos/show.jsp";
	}
	
}
