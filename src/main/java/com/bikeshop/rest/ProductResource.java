package com.bikeshop.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/products")
public class ProductResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllProducts() {
        // Sample data or fetch data from the service/database
        return "[{\"name\":\"Mountain Bike\", \"price\":500}, {\"name\":\"Road Bike\", \"price\":700}]";
    }
}
