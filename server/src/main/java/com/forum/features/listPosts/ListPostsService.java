package com.forum.features.listPosts;

import java.util.*;
import java.util.regex.*;
import com.forum.entities.*;
import com.forum.repositories.Repository;

class ListPostsService {
  private Repository<Post> postsRepository;

  public ListPostsService(Repository<Post> postsRepository) {
    this.postsRepository = postsRepository;
  }

  public List<Post> execute(PostListingRequest listingRequest) {
    return this.postsRepository.list((post) -> {
      boolean authorMatches = listingRequest.author == null ? true
        : this.checkIfAuthorMatches(post.getAuthorName(), listingRequest.author);

      boolean someCategoriesMatch = listingRequest.categoryNames.size() == 0 ? true
        : this.checkIfSomeCategoriesMatch(post.getCategoryNames(), listingRequest.categoryNames);

      return authorMatches && someCategoriesMatch;
    });
  }

  private boolean checkIfAuthorMatches(String baseAuthor, String inputAuthor) {
    Pattern pattern = Pattern.compile(inputAuthor, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(baseAuthor);
    return matcher.find();
  }

  private boolean checkIfSomeCategoriesMatch(Set<String> baseCategories, Set<String> inputCategories) {
    return inputCategories.stream().anyMatch(baseCategories::contains);
  }
}
