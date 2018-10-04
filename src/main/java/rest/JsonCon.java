/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.PersonDTO;
import entity.Person;
import java.util.List;

public class JsonCon {
static Gson gson = new GsonBuilder().setPrettyPrinting().create();


    public static String getJSONFromPerson(List<PersonDTO> persons){

        return gson.toJson(persons);
        
    }
    
}
