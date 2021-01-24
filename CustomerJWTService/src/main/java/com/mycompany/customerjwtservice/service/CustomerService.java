package com.mycompany.customerjwtservice.service;

import com.mycompany.customerjwtservice.entity.CustomerMaster;
import com.mycompany.customerjwtservice.model.CustomerModel;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/customer")
public class CustomerService {
    @Inject CustomerModel customerModel;
    
    @RolesAllowed("User")
    @GET
    @Path("getCustomerMasters/{condition}/{rating}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<CustomerMaster> getCustomerMasters(@PathParam("condition") String condition,@PathParam("rating") int rating) {
        return customerModel.getCustomerMasters(condition, rating);
    }
}
