package com.devsuperior.test1.dsclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.test1.dsclient.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
	
}
