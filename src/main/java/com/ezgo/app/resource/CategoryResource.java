package com.ezgo.app.resource;

import com.ezgo.app.domain.Category;
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
 * @author <a href="https://github.com/tjeubaoit">tjeubaoit</a>
 */
@Component
@Path("/categories")
public class CategoryResource {

    @GET
    @Path("/")
    public List<Category> getListCategories() {
        return new ArrayList<>();
    }

    @GET
    @Path("/{id}")
    public Category getCategoryById() {
        return null;
    }

    @POST
    @Path("/")
    public Response createCategory(@QueryParam("creator") String creator,
                                   Category category) {
        return Response.ok(category).build();
    }

    @PUT
    @Path("/{categoryId}")
    public Response updateCategory(@QueryParam("categoryId") String categoryId,
                                   Category category) {
        return Response.ok(category).build();
    }
}
