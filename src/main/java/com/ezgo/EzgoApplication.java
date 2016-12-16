package com.ezgo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Component
@Singleton
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class EzgoApplication {

    @GET
    public Response entry() {
        Map<String, String> map = new HashMap<>();
//        String root = uriInfo.getBaseUri().getPath();

        UriComponents uri = ServletUriComponentsBuilder.fromCurrentRequest().build();
        String baseUrl = uri.getScheme() + "://" + uri.getHost();
        if (uri.getPort() != 80) baseUrl += ":" + uri.getPort();
        map.put("user_url", baseUrl + "/{me}");
        map.put("category_url", baseUrl + "/categories{/id}");
        map.put("product_url", baseUrl + "/products{/id}{?fields}");
        map.put("user_product_url",
                baseUrl + "//products{/id}/owned|liked|viewed{?fields,filters,sort,order,offset,limit}");
        map.put("search_product_url", baseUrl + "/products/search{?filters,sort,order,offset,limit}");
        map.put("comment_url", baseUrl + "/user/comments{/id}{?fields,sort,order,offset,limit}");
        map.put("upload_url", baseUrl + "/ul{?type,size,sha1}");

        return Response.ok(map).build();
    }

    public static void main( String[] args ) {
        SpringApplication.run(EzgoApplication.class, args);
    }
}
