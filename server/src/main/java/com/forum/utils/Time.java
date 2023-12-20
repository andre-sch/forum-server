package com.forum.utils;

import java.util.Date;

public class Time {
  public static long now() {
    Date date = new Date();

    long timestamp_in_ms = date.getTime();
    long timestamp_in_seconds = timestamp_in_ms / 1000;

    return timestamp_in_seconds;
  }
}
