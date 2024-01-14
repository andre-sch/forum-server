package com.forum.features.createUser;

import com.forum.entities.User;
import com.forum.repositories.Repository;
import com.forum.security.HashGenerator;

class CreateUserService {
  private HashGenerator hashGenerator;
  private Repository<User> usersRepository;

  public CreateUserService(
    HashGenerator hashGenerator,
    Repository<User> usersRepository
  ) {
    this.hashGenerator = hashGenerator;
    this.usersRepository = usersRepository;
  }

  public UserView execute(UserCreationRequest creationRequest) {
    // TODO: apenas 1 usuário por email

    String passwordHash = this.hashGenerator.generate(creationRequest.password);

    User user = new User(
      creationRequest.name,
      creationRequest.email,
      passwordHash,
      creationRequest.avatarUrl
    );

    this.usersRepository.create(user);

    return new UserView(user);
  }
}
