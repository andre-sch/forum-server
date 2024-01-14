package com.forum.features.createUser;

import com.forum.security.HashGenerator;
import com.forum.security.BcryptHashGenerator;
import com.forum.http.HttpHandler;
import com.forum.repositories.Repository;
import com.forum.entities.User;

public class CreateUser {
  private HashGenerator hashGenerator = new BcryptHashGenerator();

  public CreateUser(Repository<User> usersRepository) {
    CreateUserService service = new CreateUserService(this.hashGenerator, usersRepository);
    CreateUserController controller = new CreateUserController(service);

    this.handler = controller;
  }

  public HttpHandler handler;
}
