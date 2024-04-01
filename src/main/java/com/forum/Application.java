package com.forum;

import com.forum.http.*;
import com.forum.http.impl.Javalin.*;

public class Application {
  private static HttpApp instance;

  private Application() {}

  public static HttpApp getInstance() {
    if (instance == null) {
      HttpServer server = new JavalinServer();
      instance = server.start(4000);
    }

    return instance;
  }
}
