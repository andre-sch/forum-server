package com.forum.utils;

import java.util.Date;

public class Time {
  public static int now() {
    Date date = new Date();

    long timestamp_in_ms = date.getTime();
    long timestamp_in_seconds = timestamp_in_ms / 1000;

    return (int) timestamp_in_seconds;
  }
}
