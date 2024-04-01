package com.forum.providers.impl;

import com.forum.providers.JSONProvider;
import com.google.gson.Gson;

public class JSONProviderGoogleAdapter implements JSONProvider {
  private Gson jsonProvider = new Gson();

  public <T> T deserialize(String content, Class<T> format) {
    return this.jsonProvider.fromJson(content, format);
  }

  public String serialize(Object content) {
    return this.jsonProvider.toJson(content);
  }
}
