package com.forum.utils;

import java.util.Date;

public class Time {
  public static int now() {
    Date date = new Date();

    long timestampInMs = date.getTime();
    long timestampInSeconds = timestampInMs / 1000;

    return (int) timestampInSeconds;
  }
}
