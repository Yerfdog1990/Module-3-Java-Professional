package org.example;

public class UserService {
  private final IUserRepository userRepository;
  private final IEmailService emailService;

  public UserService(IUserRepository userRepository, IEmailService emailService) {
    this.userRepository = userRepository;
    this.emailService = emailService;
  }

  public void registerUser(User user) {
    // 1.Store user in the database
    userRepository.saveUser(user);
  }

  public void sendConfirmationEmail(String userEmail) {
    // 2. Send confirmation email to user
    emailService.sendConfirmationEmail(userEmail);
  }
}
