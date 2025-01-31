import org.example.IEmailService;

public class EmailServiceTest implements IEmailService {
  private String userEmail;

  @Override
  public void sendConfirmationEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getUserEmail() {
    return userEmail;
  }
}
