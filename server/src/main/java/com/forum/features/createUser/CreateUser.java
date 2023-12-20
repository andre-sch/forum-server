package com.forum.features.createUser;

import com.forum.security.HashGenerator;
import com.forum.security.BcryptHashGenerator;
import com.forum.repositories.UsersRepository;
import com.forum.http.HttpHandler;

public class CreateUser {
  private HashGenerator hashGenerator = new BcryptHashGenerator();
  
  private UsersRepository usersRepository;
  private CreateUserService createUserService;
  private CreateUserController createUserController;

  public CreateUser(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
    this.createUserService = new CreateUserService(this.hashGenerator, this.usersRepository);
    this.createUserController = new CreateUserController(this.createUserService);

    this.handler = this.createUserController;
  }

  public HttpHandler handler;
}
