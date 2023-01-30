package com.unitral.ev_station;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.*;

public interface Repository extends CrudRepository<Station_Data, Integer> {

	//@Query("Select Top(10)u from Station_Data u order by u.station_pricing")
	ArrayList<Station_Data> findByName(String name);

	Page<Station_Data> findAll(Pageable pgb);

	

	

	

	



	
	
	

}
