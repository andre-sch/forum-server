package com.forum.features.deleteUser;

import java.util.Objects;
import com.forum.entities.User;
import com.forum.repositories.UsersRepository;
import com.forum.exceptions.domain.RequestException;
import com.forum.exceptions.domain.OwnershipException;

class DeleteUserService {
  private UsersRepository usersRepository;

  public DeleteUserService(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  public void execute(UserDeletionRequest deletionRequest) {
    User user = this.usersRepository.listOne(deletionRequest.deletedUserId);

    if (user == null) {
      throw new RequestException("user does not exist");
    }

    if (!Objects.equals(user.getId(), deletionRequest.authenticatedUserId)) {
      throw new OwnershipException("cannot delete third-party account");
    }

    this.usersRepository.delete(deletionRequest.deletedUserId);
  }
}
