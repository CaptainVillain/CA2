/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facade.FacadeCity;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Tiba
 */
@Path("city")
public class RestCityCode {

    @Context
    private UriInfo context;
    private Gson gson;
    private facade.FacadeCity fc = new FacadeCity(Persistence.createEntityManagerFactory("pu"));

    /**
     * Creates a new instance of RestCityCode
     */
    public RestCityCode() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    /**
     * Retrieves representation of an instance of rest.RestCityCode
     * @return an instance of Response
     */
    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
  
        String json = gson.toJson(fc.getZipCodes());
        return Response.ok(json).build();
                
    }

    /**
     * PUT method for updating or creating an instance of RestCityCode
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Response content) {
    }
}
