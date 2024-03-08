package com.forum.security;

import java.time.Instant;
import com.forum.exceptions.domain.InvalidTokenException;
import com.forum.utils.Time;

import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import io.github.cdimascio.dotenv.Dotenv;

public class JWTProviderAuth0Adapter implements JWTProvider {
  private Algorithm algorithm;

  public JWTProviderAuth0Adapter() {
    Dotenv environment = Dotenv.load();
    String secret = environment.get("TOKEN_GENERATION_SECRET");

    this.algorithm = Algorithm.HMAC256(secret);
  }

  public String generate(String subject) {
    return JWT.create()
      .withSubject(subject)
      .withIssuer("forum.com")
      .withExpiresAt(Instant.ofEpochSecond(Time.afterOneHour()))
      .sign(algorithm);
  }

  public ParsedToken parse(String token) throws InvalidTokenException {
    JWTVerifier verifier = JWT.require(algorithm)
      .withIssuer("forum.com")
      .build();

    try {
      ParsedToken forumToken = new ParsedToken();
      DecodedJWT auth0Token = verifier.verify(token);

      // todo: diff message for expiration

      forumToken.subject = auth0Token.getSubject();
      return forumToken;
    } catch (JWTVerificationException exception) {
      throw new InvalidTokenException("invalid token");
    }
  }
}
