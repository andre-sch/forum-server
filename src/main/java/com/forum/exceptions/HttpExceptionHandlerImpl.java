package com.forum.exceptions;

import com.forum.http.*;

public class HttpExceptionHandlerImpl implements HttpExceptionHandler {
  ExceptionMapper exceptionMapper = new ExceptionMapper();

  public void handle(
    HttpRequest request,
    HttpResponse response,
    Exception domainException
  ) {
    var httpException = this.exceptionMapper.map(domainException);
    response.status(httpException.code);
    response.json(httpException);
  }
}
