package com.unitral.ev_station;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main_Controler {
	boolean b=true;
	@Autowired
	private Repository repository;
	
	
		boolean f(){
		repository.save(new Station_Data(687,"a1","www.",2,"india"));
		repository.save(new Station_Data(688,"a31","www",22,"india"));
		repository.save(new Station_Data(689,"a31","www",242,"india"));
		repository.save(new Station_Data(686,"a12","w.ww",82,"india"));
		repository.save(new Station_Data(685,"a13","www",12,"india"));
		repository.save(new Station_Data(684,"a1","ww;;w",32,"india"));
		repository.save(new Station_Data(683,"a51","www",62,"india"));
		repository.save(new Station_Data(682,"a132","www",82,"india"));
		repository.save(new Station_Data(681,"a21","wkww",23,"india"));
		repository.save(new Station_Data(680,"a21","www",22,"india"));
		repository.save(new Station_Data(782,"a21","wwwr",42,"india"));
		repository.save(new Station_Data(671,"a10","www",92,"india"));
		repository.save(new Station_Data(780,"a10","wwrw",52,"india"));
		return false;
		}
		
	@GetMapping("/")
	public List<Station_Data> getAll(
			@RequestParam(value="pagenumber",defaultValue = "0",required  = false) int pagenumber,
			@RequestParam(value="noOfPost",defaultValue = "10",required   = false) int noOfPost,
			@RequestParam(value="sortby",defaultValue = "stationId",required = false) String sortby,
			@RequestParam(value="sortDir",defaultValue = "asc",required = false) String sortDir
	){
		b=b?f():false;
		
		Sort sort=
		  sortDir.equalsIgnoreCase("asc")?
			Sort.by(sortby).ascending():Sort.by(sortby).descending();
		
			
		
		Pageable pgb=PageRequest.of(pagenumber, noOfPost,sort);
		Page<Station_Data> pg=repository.findAll(pgb);
		List<Station_Data> sd=(List<Station_Data>) pg.getContent();
		
		return  sd;
	}

	@GetMapping("/show/{id}")
	 Optional<Station_Data> getOneById(@PathVariable int id) {
		return repository.findById(id);
	
	}
	 
	 
	 @PostMapping("/station")
	  Station_Data postData(@RequestBody Station_Data newStation_data) {
	    return repository.save(newStation_data);
	  }
	 
	 
	 @PutMapping("/station/{id}")
	  Station_Data replaceEmployee(@RequestBody Station_Data newStation_data, @PathVariable int id) {
	    
	    return repository.findById(id)
	      .map(storedata -> {
	        storedata.setStation_name(newStation_data.getStation_name());
	        storedata.setStation_image(newStation_data.getStation_image());
	        storedata.setStation_address(newStation_data.getStation_address());
	        storedata.setStation_pricing(newStation_data.getStation_pricing());
	        return repository.save(storedata);
	      })
	      .orElseGet(() -> {
	        newStation_data.setStation_id(id);
	        return repository.save(newStation_data);
	      });
	  }
	 
	 
	 @DeleteMapping("/station/{id}")
	  void deleteEmployee(@PathVariable int id) {
	    repository.deleteById(id);
	  }
	 
}
