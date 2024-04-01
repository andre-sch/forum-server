package com.forum;

import com.forum.repositories.*;
import com.forum.repositories.impl.hibernate.*;

public class Repositories {
  private static Transaction transaction = new Transaction("com.forum");

  private static PermissionsRepository permissionsRepository = new HibernatePermissionsRepository(transaction);
  private static RolesRepository rolesRepository = new HibernateRolesRepository(transaction);
  private static UsersRepository usersRepository = new HibernateUsersRepository(transaction);
  private static ContributionsRepository contributionsRepository = new HibernateContributionsRepository(transaction);
  private static CommentsRepository commentsRepository = new HibernateCommentsRepository(transaction);
  private static PostsRepository postsRepository = new HibernatePostsRepository(transaction);
  private static CategoriesRepository categoriesRepository = new HibernateCategoriesRepository(transaction);
  private static RankingsRepository rankingsRepository = new HibernateRankingsRepository(transaction);

  private Repositories() {}

  public static PermissionsRepository getPermissionsRepository() { return permissionsRepository; }
  public static RolesRepository getRolesRepository() { return rolesRepository; }
  public static UsersRepository getUsersRepository() { return usersRepository; }
  public static ContributionsRepository getContributionsRepository() { return contributionsRepository; }
  public static CommentsRepository getCommentsRepository() { return commentsRepository; }
  public static PostsRepository getPostsRepository() { return postsRepository; }
  public static CategoriesRepository getCategoriesRepository() { return categoriesRepository; }
  public static RankingsRepository getRankingsRepository() { return rankingsRepository; }
}
