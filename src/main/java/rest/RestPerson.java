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
import facade.FacadePerson;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Tiba
 */
@Path("person")
public class RestPerson {

    @Context
    private UriInfo context;
    private Gson gson;
    private facade.FacadePerson fp = new FacadePerson(Persistence.createEntityManagerFactory("Ca2PU"));

    /**
     * Creates a new instance of RestPerson
     */
    public RestPerson() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

        
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getJson(Json json) {
//
//        
//        String json = gson.toJson(fp.createPerson(p));
//
//        return Response.ok(json).build();
//    }
//    
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getJson(Json json) {
//        Person p = new Person();
//        
//        String json = gson.toJson(fp.editPerson(p));
//
//        return Response.ok(json).build();
//    }
//    @Path("id")
//    @DELETE
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getJson(long id) {
//        
//        
//        fp.deletePerson(id);
//
//        return Response.ok().build();
//    }
    
    @Path("complete")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {

        List<PersonDTO> p = fp.getAllPersons();
        return JsonCon.getJSONFromPerson(p);

        
    }

    @Path("complete/id")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(long id) {

        String json = gson.toJson(fp.getPersonsById(id));

        return Response.ok(json).build();
    }

    @Path("contactinfo")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(String contactinfo) {

        String json = gson.toJson(fp.getPersonsFromContactInfo(contactinfo));

        return Response.ok(json).build();
    }

    @Path("allhobby/id")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson2(long id) {

        String json = gson.toJson(fp.getPersonsByHobby(id));

        return Response.ok(json).build();
    }

    @Path("count/id")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson1(long id) {

        String json = gson.toJson(fp.getPersonCountByHobby(id));

        return Response.ok(json).build();
    }

//    @Path("count/id")
//    @GET
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getJson2(String name) {
//
//        String json = gson.toJson(fp.getPersonCountByHobby(name));
//
//        return Response.ok(json).build();
//    }


    /**
     * PUT method for updating or creating an instance of RestPerson
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Response content) {
    }
}
