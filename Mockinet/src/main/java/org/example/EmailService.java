package org.example;

// Send confirmation email
public class EmailService implements IEmailService {
  @Override
  public void sendConfirmationEmail(String userEmail) {
    System.out.println("Sending confirmation email to " + userEmail);
  }
}
