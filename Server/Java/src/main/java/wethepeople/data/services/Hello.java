package wethepeople.data.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/hello")
public class Hello
{
  @GET
  @Path("/{test}")
  public Response helloWorld(@PathParam("test") String msg)
  {
    String out = "Hello world! " + msg;
    return Response.status(200).entity(out).build();
  }
}
