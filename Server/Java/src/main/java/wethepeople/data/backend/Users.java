package wethepeople.data.backend;

import java.util.ArrayList;
import java.util.UUID;

import lombok.val;

public class Users
{
  private static ArrayList<User> users = new ArrayList<User>();
        
  public static User find(String uuid)
  {
    if(users.isEmpty())
    {
      User user = new User(new UUID(12L, 7L))//Test administrator
      {{
        setUsername("admin");
        updatePassword("admin");
      }};
      System.out.println(user);
      users.add(user);
    }
    try
    {
      final UUID id = UUID.fromString(uuid);
      User found = null; 
      val opt = users.parallelStream()
        .filter(u -> u.getUuid().equals(id))
        .findFirst();
      
      if(opt.isPresent())
        found = opt.get();
      
      return found;
    }
    catch (IllegalArgumentException e)
    {
      return null; //bad UUID
    }
  }
}
