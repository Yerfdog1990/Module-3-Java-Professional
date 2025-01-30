import org.example.IEmailService;
import org.example.IUserRepository;
import org.example.User;
import org.example.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UserServiceTest {
  @Test
  void testRegisterUser() {
    // 1.Structure
    IUserRepository userRepository = Mockito.mock(IUserRepository.class);
    IEmailService emailService = Mockito.mock(IEmailService.class);
    UserService userService = new UserService(userRepository, emailService);
    User user = new User("John", "<EMAIL>");

    // 2.Logic
    userService.registerUser(user);
    userService.sendConfirmationEmail(user.email());

    // 3.Assertions
    Mockito.verify(userRepository, Mockito.times(1)).saveUser(user);
    Mockito.verify(emailService, Mockito.times(1)).sendConfirmationEmail(user.email());
  }
}
