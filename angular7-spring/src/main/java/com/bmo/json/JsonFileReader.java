package com.bmo.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bmo.model.PersonInfo;
 
public class JsonFileReader
{
	public static List<PersonInfo> temppersons = new ArrayList<PersonInfo>();
	

    @SuppressWarnings("unchecked")
    public List<PersonInfo> ReadData()
    {
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("convertcsv.json"))
        {
      
            Object obj = jsonParser.parse(reader);
 
            JSONArray characterList = (JSONArray) obj;
            System.out.println(characterList);
             
         
            characterList.forEach( character -> parseCharacterObject( (JSONObject) character) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return temppersons;
    }
 
    private void parseCharacterObject(JSONObject character)
    {
        
         
        String firstName = (String) character.get("firstName");        
        String lastName = (String) character.get("lastName");    
        PersonInfo person1= new PersonInfo();
		person1.setFirstName(firstName);
		person1.setLastName(lastName);
		temppersons.add(person1);
		
         
    }
}