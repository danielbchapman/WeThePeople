package wethepeople.data.backend;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class TestUser
{
  @Test
  public void testFindDefaultAdmin()
  {
    User x = Users.find(new UUID(12L, 7L).toString());//test user
    Assert.assertTrue(x != null);
  }
  
  @Test
  public void testFindNone()
  {
    User x = Users.find(new UUID(1L, 1L).toString());//test user
    Assert.assertTrue(x == null);
  }
  
}
