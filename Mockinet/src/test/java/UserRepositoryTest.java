import org.example.IUserRepository;
import org.example.User;

public class UserRepositoryTest implements IUserRepository {
  private User user;

  @Override
  public void saveUser(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }
}
