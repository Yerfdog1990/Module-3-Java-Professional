package org.example;

public class UserService {
  private final IUserRepository userRepository;
  private final IEmailService emailService;

  public UserService(IUserRepository userRepository, IEmailService emailService) {
    this.userRepository = userRepository;
    this.emailService = emailService;
  }

  public void registerUser(User user) {
    // 0. Check that user does not exist
    if (userRepository.checkIfUserExist(user.email())) {
      throw new IllegalArgumentException("User already exists");
    }
    // 1.Store user in the database
    userRepository.saveUser(user);

    // 2. Send confirmation email to user
    emailService.sendConfirmationEmail(user.email());
  }
}
