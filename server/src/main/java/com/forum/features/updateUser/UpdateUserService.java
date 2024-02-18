package com.forum.features.updateUser;

import com.forum.repositories.Repository;
import com.forum.entities.User;

class UpdateUserService {
  private Repository<User> usersRepository;

  public UpdateUserService(Repository<User> usersRepository) {
    this.usersRepository = usersRepository;
  }

  public User execute(UserUpdateRequest updateRequest) {
    User user = this.usersRepository.listOne(updateRequest.userId);

    if (user == null) {
      throw new Error("user does not exist");
    }

    if (updateRequest.name != null) {
      user.setName(updateRequest.name);
    }

    if (updateRequest.email != null) {
      User registeredUser = this.usersRepository.listFirst(
        (User instance) -> instance.getEmail().equals(updateRequest.email)
      );

      if (registeredUser != null) {
        throw new Error("email already registered");
      }

      user.setEmail(updateRequest.email);
    }

    if (updateRequest.password != null) {
      user.setPassword(updateRequest.password);
    }

    if (updateRequest.avatarUrl != null) {
      user.setAvatarUrl(updateRequest.avatarUrl);
    }

    this.usersRepository.update(user);

    return user;
  }
}
