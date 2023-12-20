package com.forum.features.createUser;

import com.forum.entities.User;
import com.forum.repositories.UsersRepository;
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

  public UserCreationResponse execute(UserCreationRequest creationRequest) {
    // TODO: apenas 1 usuário por email

    String passwordHash = this.hashGenerator.generate(creationRequest.password);

    User user = new User(
      creationRequest.name,
      creationRequest.email,
      passwordHash
    );

    this.usersRepository.create(user);

    return new UserCreationResponse(user);
  }
}
