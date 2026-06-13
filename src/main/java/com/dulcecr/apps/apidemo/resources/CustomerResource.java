package com.dulcecr.apps.apidemo.resources;

import com.dulcecr.apps.apidemo.dto.CustomerRequest;
import com.dulcecr.apps.apidemo.service.CustomerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/api/customers")
public class CustomerResource {

    @Inject
    CustomerService customerService;

    @GET
    public Response findAll() {
        var customers = customerService.findAll();

        if (customers.isEmpty()) {
            return Response.noContent().build();
        }

        return Response.ok(customerService.findAll())
                .build();
    }

    @POST
    public Response create(CustomerRequest request){
        return Response.ok(
                customerService.create(request)
        ).build();
    }
}
