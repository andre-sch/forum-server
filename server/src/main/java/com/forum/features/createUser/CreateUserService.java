package com.forum.features.createUser;

import com.forum.entities.User;
import com.forum.repositories.UsersRepository;
import com.forum.exceptions.domain.RequestException;
import com.forum.security.HashProvider;

class CreateUserService {
  private HashProvider hashProvider;
  private UsersRepository usersRepository;

  public CreateUserService(
    HashProvider hashProvider,
    UsersRepository usersRepository
  ) {
    this.hashProvider = hashProvider;
    this.usersRepository = usersRepository;
  }

  public User execute(UserCreationRequest creationRequest) {
    User registeredUser = this.usersRepository.listOneByEmail(creationRequest.email);

    if (registeredUser != null) {
      throw new RequestException("email already registered");
    }

    String passwordHash = this.hashProvider.hash(creationRequest.password);

    User user = new User();
    user.setName(creationRequest.name);
    user.setEmail(creationRequest.email);
    user.setPassword(passwordHash);
    user.setAvatarUrl(creationRequest.avatarUrl);

    this.usersRepository.save(user);

    return user;
  }
}
