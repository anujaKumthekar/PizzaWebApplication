package com.accenture.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.PizzaEntity;

@RepositoryDefinition(idClass=Integer.class, 
			domainClass=PizzaEntity.class )
@Transactional("txManager")
public interface PizzaDAO {
	
	@Query(name="findAllPizzaDetails")
	List<PizzaEntity> findAllPizzaDetails();

}
