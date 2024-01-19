package com.forum.features.listUsers;

import java.util.List;
import com.forum.entities.User;
import com.forum.repositories.Repository;

class ListUsersService {
  private Repository<User> usersRepository;

  public ListUsersService(Repository<User> usersRepository) {
    this.usersRepository = usersRepository;
  }

  public  List<User> execute() {
    return this.usersRepository.list();
  }
}
