package com.forum.security;

import org.springframework.security.crypto.bcrypt.*;

public class BcryptHashGenerator implements HashGenerator {
  private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  public String generate(String input) {
    return this.encoder.encode(input);
  }

  public boolean compare(String input, String hash) {
    return this.encoder.matches(input, hash);
  }
}
