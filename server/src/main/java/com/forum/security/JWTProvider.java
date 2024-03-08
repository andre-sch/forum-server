package com.forum.security;

import com.forum.exceptions.domain.InvalidTokenException;

public interface JWTProvider {
  public String generate(String subject);
  public ParsedToken parse(String token) throws InvalidTokenException;
}
