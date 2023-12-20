package com.forum;

import com.forum.http.*;
import com.forum.http.impl.Javalin.*;
public class Main {
  public static void main(String[] args) {
    HttpServer server = new JavalinServer();
    HttpApp app = server.start(4000);

  }
}
