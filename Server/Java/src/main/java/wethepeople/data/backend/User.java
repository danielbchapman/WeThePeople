package wethepeople.data.backend;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class User
{
  @Getter
  @Setter
  private UUID uuid;
  @Getter
  @Setter
  private String username;
  @Getter
  private String password;
  @Getter
  private String salt;

  public User(UUID uuid)
  {
    this.uuid = uuid;
  }
  
  public User()
  {
    this(UUID.randomUUID());
  }
  /**
   * Updates this user's password and salt
   * @param password the password to hash 
   * 
   */
  public void updatePassword(String password)
  {
    try
    {
      Random rand = new Random();
      byte[] salt = new byte[16];
      rand.nextBytes(salt);
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      digest.reset();
      digest.update(salt);
      byte[] out = digest.digest(password.getBytes());
      this.salt = Base64.getEncoder().encodeToString(salt);
      this.password = Base64.getEncoder().encodeToString(out);
    }
    catch (NoSuchAlgorithmException e)
    {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  /**
   * Check this user's password against a password
   * @param user
   * @param password
   * @return true if a match, otherwise false
   * 
   */
  public static boolean check(User user, String password)
  {
    try
    {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      digest.reset();
      digest.update(Base64.getDecoder().decode(user.salt));
      byte[] out = digest.digest(password.getBytes());
      byte[] check = Base64.getDecoder().decode(user.password);

      if (out.length != check.length)
        return false;

      for (int i = 0; i < out.length; i++)
      {
        if (out[i] != check[i])
          return false;
      }

      return true;
    }
    catch (NoSuchAlgorithmException e)
    {
      throw new RuntimeException(e.getMessage(), e);
    }
  }
}
