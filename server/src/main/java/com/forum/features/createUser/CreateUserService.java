package com.forum.features.createUser;

import com.forum.entities.User;
import com.forum.repositories.UsersRepository;
import com.forum.exceptions.domain.RequestException;
import com.forum.security.HashGenerator;

class CreateUserService {
  private HashGenerator hashGenerator;
  private UsersRepository usersRepository;

  public CreateUserService(
    HashGenerator hashGenerator,
    UsersRepository usersRepository
  ) {
    this.hashGenerator = hashGenerator;
    this.usersRepository = usersRepository;
  }

  public User execute(UserCreationRequest creationRequest) {
    User registeredUser = this.usersRepository.listOneByEmail(creationRequest.email);

    if (registeredUser != null) {
      throw new RequestException("email already registered");
    }

    String passwordHash = this.hashGenerator.generate(creationRequest.password);

    User user = new User();
    user.setName(creationRequest.name);
    user.setEmail(creationRequest.email);
    user.setPassword(passwordHash);
    user.setAvatarUrl(creationRequest.avatarUrl);

    this.usersRepository.save(user);

    return user;
  }
}
