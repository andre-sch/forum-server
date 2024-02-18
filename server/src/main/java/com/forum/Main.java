package com.forum;

import com.forum.http.*;
import com.forum.http.impl.Javalin.*;

import com.forum.features.listUsers.ListUsers;
import com.forum.features.createUser.CreateUser;
import com.forum.features.updateUser.UpdateUser;
import com.forum.features.deleteUser.DeleteUser;

import com.forum.features.listPosts.ListPosts;
import com.forum.features.listOnePost.ListOnePost;
import com.forum.features.createPost.CreatePost;
import com.forum.features.createComment.CreateComment;
import com.forum.features.rankContribution.RankContribution;

import com.forum.features.listCategories.ListCategories;
import com.forum.features.createCategory.CreateCategory;
import com.forum.features.updateCategory.UpdateCategory;
import com.forum.features.deleteCategory.DeleteCategory;

import com.forum.repositories.impl.hibernate.*;
import com.forum.repositories.Repository;
import com.forum.entities.*;

public class Main {
  public static void main(String[] args) {
    var transaction = new Transaction("com.forum");

    HttpServer server = new JavalinServer();
    HttpApp app = server.start(4000);

    Repository<User> usersRepository = new HibernateUsersRepository(transaction);
    Repository<Post> postsRepository = new HibernatePostsRepository(transaction);
    Repository<Comment> commentsRepository = new HibernateCommentsRepository(transaction);
    Repository<Contribution> contributionsRepository = new HibernateContributionsRepository(transaction);
    Repository<Ranking> rankingsRepository = new HibernateRankingsRepository(transaction);
    Repository<Category> categoriesRepository = new HibernateCategoriesRepository(transaction);

    app.get("/users", new ListUsers(usersRepository).handler);
    app.post("/users", new CreateUser(usersRepository).handler);
    app.put("/users/{userId}", new UpdateUser(usersRepository).handler);
    app.delete("/users/{userId}", new DeleteUser(usersRepository).handler);

    app.get("/posts", new ListPosts(postsRepository).handler);
    app.get("/posts/{postId}", new ListOnePost(postsRepository, commentsRepository).handler);

    app.post("/posts", new CreatePost(postsRepository, usersRepository, categoriesRepository).handler);
    app.post("/comments", new CreateComment(commentsRepository, usersRepository, postsRepository).handler);

    app.put(
      "/ranking/{contributionId}/{action}",
      new RankContribution(usersRepository, contributionsRepository, rankingsRepository).handler
    );

    app.get("/categories", new ListCategories(categoriesRepository).handler);
    app.post("/categories", new CreateCategory(categoriesRepository).handler);
    app.put("/categories/{categoryName}", new UpdateCategory(categoriesRepository).handler);
    app.delete("/categories/{categoryName}", new DeleteCategory(categoriesRepository).handler);
  }
}
