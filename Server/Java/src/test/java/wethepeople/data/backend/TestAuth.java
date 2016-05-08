package wethepeople.data.backend;

import org.junit.Assert;
import org.junit.Test;

public class TestAuth
{
  @Test
  public void testBasicAuth()
  {
    User test = new User();
    test.setUsername("Test user");
    test.updatePassword("admin");
    System.out.println(test);
    
    Assert.assertTrue(User.check(test, "test-pass"));
    Assert.assertFalse(User.check(test, "test-pas2"));
  }
}
