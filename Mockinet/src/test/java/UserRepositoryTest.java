import org.example.IUserRepository;
import org.example.User;

public class UserRepositoryTest implements IUserRepository {
  private User user;
  @Override
  public void saveUser(User user) {
    this.user = user;
  }

  @Override
  public boolean checkIfUserExist(String email) {
    return false;
  }
  @Override
  public void validateUser(String email) {
  }
  public User getUser() {
    return user;
  }
}
