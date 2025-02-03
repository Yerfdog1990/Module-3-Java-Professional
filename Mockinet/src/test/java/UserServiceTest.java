import org.example.IEmailService;
import org.example.IUserRepository;
import org.example.User;
import org.example.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
  // Using mock annotations to initialize IUserRepositories and IEmailService
  @Mock
  private IUserRepository userRepository;
  @Mock
  private IEmailService emailService;

  @AfterEach
  void resetMocks() {
    Mockito.reset(userRepository, emailService);
  }
  @Test
  @DisplayName("Test Register User")
  void testRegisterUser() {
    // 1.Structure
    UserService userService = new UserService(userRepository, emailService);
    User user = new User("<EMAIL>", "Joe Doe");

    // 2.Logic
    userService.registerUser(user);

    // 3.Assertions
    InOrder inOrder = inOrder(userRepository, emailService);
    inOrder.verify(userRepository, Mockito.times(1)).saveUser(user);
    inOrder.verify(emailService, Mockito.times(1)).sendConfirmationEmail(user.email());

  }
  @Test
  @DisplayName("Test Check If User Exist")
  void testCheckIfEmailExist(){
    // 1.Structure
    UserService userService = new UserService(userRepository, emailService);
    User user = new User("jdoe@com", "Joe Doe");
    when(userRepository.checkIfUserExist(user.email())).thenReturn(true);
    //doReturn(true).when(emailService).sendConfirmationEmail(user.email());

    // 2.Logic
    assertThrows(IllegalArgumentException.class, () -> {userService.registerUser(user);});

    // 3.Assertions
    verify(userRepository, Mockito.never()).saveUser(any(User.class));
    verify(emailService, Mockito.never()).sendConfirmationEmail(anyString());
  }
  @Test
  @DisplayName("Validate User Test")
  void validateUserTest(){
    // 1.Structure
    UserService userService = new UserService(userRepository, emailService);
    User user = new User("jdoe@com", "Joe Doe");
    doThrow(new IllegalArgumentException("User is not valid")).when(emailService).sendConfirmationEmail(user.email());
  }
}
