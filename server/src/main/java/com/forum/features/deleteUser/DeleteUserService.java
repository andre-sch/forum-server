package com.forum.features.deleteUser;

import com.forum.entities.User;
import com.forum.repositories.Repository;
import com.forum.exceptions.domain.RequestException;

class DeleteUserService {
  private Repository<User> usersRepository;

  public DeleteUserService(Repository<User> usersRepository) {
    this.usersRepository = usersRepository;
  }

  public void execute(String userId) {
    User user = this.usersRepository.listOne(userId);

    if (user == null) {
      throw new RequestException("user does not exist");
    }

    this.usersRepository.delete(userId);
  }
}
