package com.forum.providers;

public interface JSONProvider {
  public String serialize(Object content);
  public <T> T deserialize(String content, Class<T> format);
}
