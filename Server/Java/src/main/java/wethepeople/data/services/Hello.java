package wethepeople.data.services;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/hello")
public class Hello
{
  @GET
  @PermitAll
  @Path("/{test}")
  public Response hello(@PathParam("test") String msg)
  {
    String out = "Hello world! " + msg;
    return Response.status(200).entity(out).build();
  }
  
  @GET
  @Path("/secure/{secure}")
  public Response secure(@PathParam("secure") String msg)
  {
    String out = "Secure Hello world! " + msg;
    return Response.status(200).entity(out).build();
  }
}
