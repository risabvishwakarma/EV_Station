# EV_Station
it is a basic EV charging station api app
for localhost--

get request----------------------
public List<Station_Data> getAll(){}
http://localhost:8080/?noOfPost=3&sortby=stationPricing&sortDir=desc&pagenumber=2

filtering parameters--al are optional by defingin [@RequestParam (value="sortby",defaultvalue="stationPrice",required="false") String sortby ]

pagenumber=2
noOfPost=3
sortby=stationPricing
sortDir=desc

post request------------------
 @PostMapping("/station")
	  Station_Data postData(@RequestBody Station_Data newStation_data) {
	    return repository.save(newStation_data);
	  }
    
put request-----------------
@PutMapping("/station/{id}")
	  Station_Data replaceEmployee(@RequestBody Station_Data newStation_data, @PathVariable int id) {}
    
delete request--------------
 @DeleteMapping("/station/{id}")
	  void deleteEmployee(@PathVariable int id) {
	    repository.deleteById(id);
	  }
	    
      
Database used id h2 inbuilt database




           
