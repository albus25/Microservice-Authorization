/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.customerjwtclient.service;

import com.mycompany.customerjwtservice.entity.CustomerMaster;
import java.util.Collection;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import token.GenerateToken;

/**
 *
 * @author Albus
 */
@RegisterRestClient(configKey = "customerClient",baseUri = "http://localhost:8080/CustomerJWTService/rest/customer")
public interface CustomerClient {
    
    @GET
    @Path("getCustomerMasters/{condition}/{rating}")
    @Produces(MediaType.APPLICATION_JSON)
    @ClientHeaderParam(name = "Authorization",value="{generateJWTToken}")
    public Collection<CustomerMaster> getCustomerMasters(@PathParam("condition") String condition,@PathParam("rating") int rating);
    
    default String generateJWTToken() {
        String token = GenerateToken.generateJWT();
        System.out.println("Bearer " + token);
        return "Bearer " + token;
    }
}
