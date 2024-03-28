package com.forum;

import com.forum.http.*;
import com.forum.exceptions.*;
import com.forum.endpoints.*;
import com.forum.routers.*;

public class Main {
  public static void main(String[] args) {
    HttpApp app = Application.getInstance();

    app.addExceptionHandler(new HttpExceptionHandlerImpl());

    new PermissionRouter(app).bindEndpoints();
    new RoleRouter(app).bindEndpoints();
    new UserRouter(app).bindEndpoints();
    new ContributionRouter(app).bindEndpoints();
    new CommentRouter(app).bindEndpoints();
    new PostRouter(app).bindEndpoints();
    new CategoryRouter(app).bindEndpoints();

    app.use("*", new UnavailableResource());

    new Management().insertSystemAdmin();
  }
}
