package com.forum.features.deleteUser;

import com.forum.entities.User;
import com.forum.repositories.UsersRepository;
import com.forum.exceptions.domain.RequestException;

class DeleteUserService {
  private UsersRepository usersRepository;

  public DeleteUserService(UsersRepository usersRepository) {
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
