package com.forum.features.listUsers;

import java.util.List;
import com.forum.entities.User;
import com.forum.repositories.Repository;

class ListUsersService {
  private Repository<User> usersRepository;

  public ListUsersService(Repository<User> usersRepository) {
    this.usersRepository = usersRepository;
  }

  public List<UserView> execute() {
    List<User> users = this.usersRepository.list();
    return users.stream().map((user) -> new UserView(user)).toList();
  }
}
