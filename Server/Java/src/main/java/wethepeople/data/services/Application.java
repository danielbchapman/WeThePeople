package wethepeople.data.services;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig
{
  public Application()
  {
    packages("wethepeople.data.services");
    register(LoggingFilter.class);
    register(AuthFilter.class);
    System.out.println("Application initialized");
  }
}
