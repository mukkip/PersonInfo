package com.bmo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bmo.json.JsonFileReader;
import com.bmo.model.PersonInfo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CodeController {
	
	
	
	private List<PersonInfo> persons = createList();
	

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public List<PersonInfo> firstPage() {
	
		return persons;
	}
	
	private List<PersonInfo> createList(){
		
		JsonFileReader freader = new JsonFileReader();
		List<PersonInfo> temppersons = freader.ReadData();
		return temppersons;
		
	}

}
