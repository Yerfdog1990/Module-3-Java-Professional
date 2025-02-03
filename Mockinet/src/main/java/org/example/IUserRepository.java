package org.example;

public interface IUserRepository {
  void saveUser(User user);
  boolean checkIfUserExist(String email);
  void validateUser(String email) throws IllegalArgumentException;
}
