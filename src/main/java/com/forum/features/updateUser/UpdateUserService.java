package com.forum.features.updateUser;

import com.forum.entities.User;
import com.forum.repositories.UsersRepository;
import com.forum.exceptions.domain.RequestException;
import com.forum.providers.HashProvider;

class UpdateUserService {
  private HashProvider hashProvider;
  private UsersRepository usersRepository;

  public UpdateUserService(
    HashProvider hashProvider,
    UsersRepository usersRepository
  ) {
    this.hashProvider = hashProvider;
    this.usersRepository = usersRepository;
  }

  public User execute(UserUpdateRequest updateRequest) {
    User user = this.usersRepository.listOne(updateRequest.authenticatedUserId);

    if (updateRequest.name != null) {
      user.setName(updateRequest.name);
    }

    boolean isEmailUpdated = updateRequest.email != null && updateRequest.email != user.getEmail();

    if (isEmailUpdated) {
      boolean isEmailAlreadyUsed = this.usersRepository.listOneByEmail(updateRequest.email) != null;

      if (isEmailAlreadyUsed) {
        throw new RequestException("new email is already registered");
      }

      user.setEmail(updateRequest.email);
    }

    if (updateRequest.password != null) {
      String passwordHash = this.hashProvider.hash(updateRequest.password);
      user.setPassword(passwordHash);
    }

    this.usersRepository.update(user);

    return user;
  }
}
