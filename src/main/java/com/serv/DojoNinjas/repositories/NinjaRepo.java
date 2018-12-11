package com.serv.DojoNinjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.serv.DojoNinjas.models.Ninja;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long>{

}
