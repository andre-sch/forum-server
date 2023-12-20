package com.forum;

import com.forum.http.*;
import com.forum.http.impl.Javalin.*;

import com.forum.features.createUser.CreateUser;
import com.forum.repositories.UsersRepository;
import com.forum.repositories.impl.InMemoryUsersRepository;

public class Main {
  public static void main(String[] args) {
    HttpServer server = new JavalinServer();
    HttpApp app = server.start(4000);

    UsersRepository usersRepository = new InMemoryUsersRepository();
    app.post("/users", new CreateUser(usersRepository).handler);
  }
}
