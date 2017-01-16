package com.ezgo.resource;

import com.ezgo.domain.Categories;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Class description here.
 *
 * @author <a href="https://github.com/tjeubaoit">tjeubaoit</a>
 */
@Component
@Path("/")
public class CategoryResource {

    @GET
    @Path("/categories")
    public List<Categories> getListCategories() {
        return new ArrayList<>();
    }

    @GET
    @Path("/categories/{id}")
    public Categories getCategoryById() {
        return null;
    }

    @POST
    @Path("/categories")
    public Response createCategory(@QueryParam("creator") String creator,
                                   Categories category) {
        return Response.ok(category).build();
    }

    @PUT
    @Path("/categories/{categoryId}")
    public Response updateCategory(@PathParam("categoryId") String categoryId,
                                   Categories category) {
        return Response.ok(category).build();
    }
}
