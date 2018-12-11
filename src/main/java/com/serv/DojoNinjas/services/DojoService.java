package com.serv.DojoNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.serv.DojoNinjas.models.Dojo;
import com.serv.DojoNinjas.repositories.DojoRepo;

@Service
public class DojoService {
	private final DojoRepo dr;
	
	public DojoService(DojoRepo dr) {
		this.dr = dr;
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dr.save(dojo);
		
	}
	
	public List<Dojo>findAllDojos(){
		return dr.findAll();
	}
	
	public Dojo findDojo(Long dojoId) {
		Optional<Dojo> optionaldojo = dr.findById(dojoId);
		if(optionaldojo.isPresent()) {
			return optionaldojo.get();
		}
		else {
			return null;
		}
	}
}
