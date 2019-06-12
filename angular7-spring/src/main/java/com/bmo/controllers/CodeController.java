package com.bmo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bmo.model.PersonInfo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CodeController {
	
	private List<PersonInfo> persons = createList();
	

	@RequestMapping(value = "/persons", method = RequestMethod.GET, produces = "application/json")
	public List<PersonInfo> firstPage() {
	
		return persons;
	}
	
	private List<PersonInfo> createList(){
		List<PersonInfo> temppersons = new ArrayList<PersonInfo>();
		
		PersonInfo person1= new PersonInfo();
		person1.setFirstName("John");
		person1.setLastName("Snow");
		
		PersonInfo person2= new PersonInfo();
		person2.setFirstName("Sansa");
		person2.setLastName("Stark");
		
		temppersons.add(person1);
		temppersons.add(person2);
		
		return temppersons;
		
	}

}
