package com.forum.security.impl;

import com.forum.security.HashProvider;
import org.springframework.security.crypto.bcrypt.*;

public class HashProviderBCryptAdapter implements HashProvider {
  private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  public String hash(String input) {
    return this.encoder.encode(input);
  }

  public boolean equals(String input, String hash) {
    return this.encoder.matches(input, hash);
  }
}
