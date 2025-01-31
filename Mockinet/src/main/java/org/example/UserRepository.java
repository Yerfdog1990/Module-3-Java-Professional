package org.example;

// Will store users in the database
public class UserRepository implements IUserRepository {
  @Override
  public void saveUser(User user) {
    System.out.println("Saving user " + user.name() + " to the database");
  }
}
