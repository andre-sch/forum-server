package com.forum.security;

public interface HashGenerator {
  String generate(String input);
  boolean compare(String input, String hash);
}
