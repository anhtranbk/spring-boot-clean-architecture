package com.ezgo.resource;

import com.ezgo.domain.Events;
import org.springframework.stereotype.Component;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
public class EventResource {

    @HeaderParam("user")
    String userName;

    @GET
    @Path("/categories/{categoryId}/events")
    public List<Events> getEventsByCategoryId(@PathParam("categoryId") String categoryId,
                                              @DefaultValue("0") @QueryParam("offset") int offset,
                                              @DefaultValue("20") @QueryParam("limit") int limit) {
        return new ArrayList<>();
    }

    @GET
    @Path("/events/trending")
    public List<Events> getTrendingEvents(@DefaultValue("0") @QueryParam("offset") int offset,
                                          @DefaultValue("20") @QueryParam("limit") int limit) {
        return new ArrayList<>();
    }

    @GET
    @Path("/events/{id}")
    public Events getEventById(@PathParam("id") String eventId) {
        return null;
    }

    @GET
    @Path("/me/events")
    public List<Events> getMyEvents(@DefaultValue("0") @QueryParam("offset") int offset,
                                    @DefaultValue("20") @QueryParam("limit") int limit) {
        return new ArrayList<>();
    }

    @POST
    @Path("/me/events")
    public Response createEvent(Events event) {
        return Response.ok(event).build();
    }

    @PUT
    @Path("/me/events/{id}")
    public Response updateEvent(Events event) {
        return Response.ok(event).build();
    }

    @GET
    @Path("/me/events/likes")
    public List<Events> getMyLikeEvents(@DefaultValue("0") @QueryParam("offset") int offset,
                                        @DefaultValue("20") @QueryParam("limit") int limit) {
        return new ArrayList<>();
    }

    @PUT
    @Path("/me/events/{eventId}/likes")
    public Response updateReactionToEvent(@PathParam("eventId") String eventId) {
        return Response.ok().build();
    }
}
