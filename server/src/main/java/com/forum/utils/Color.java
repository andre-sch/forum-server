package com.forum.utils;

import java.util.Random;

public class Color {
  public static String getRandom() {
    Random random = new Random();

    int base = 16;
    int numberOfDigits = 6;
    int inclusiveUpperBound = (int) Math.pow(base, numberOfDigits);
    int exclusiveUpperBound = inclusiveUpperBound + 1;

    int randomInteger = random.nextInt(exclusiveUpperBound);

    return String.format("%06x", randomInteger);
  }

  public static String prependHash(String hexCode) {
    return String.format("#%s", hexCode);
  }
}
