package com.serv.DojoNinjas.services;

import org.springframework.stereotype.Service;

import com.serv.DojoNinjas.models.Ninja;
import com.serv.DojoNinjas.repositories.NinjaRepo;

@Service
public class NinjaService {

		private final NinjaRepo nr;
		
		public NinjaService(NinjaRepo nr) {
			this.nr = nr;
		}
		
		public Ninja createNinja(Ninja ninja) {
			return nr.save(ninja);
		}
}
