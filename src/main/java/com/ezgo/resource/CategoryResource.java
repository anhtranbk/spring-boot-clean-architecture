package com.ezgo.resource;

import com.ezgo.domain.Categories;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
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
    @Path("/categories")
    public Response updateCategory(Categories category) {
        return Response.ok(category).build();
    }
}
