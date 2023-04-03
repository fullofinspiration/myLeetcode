package com.fullofinspiration.github.interview;

public class Singleton {
  private static volatile Singleton singleton;

  public Singleton get() {
    if (singleton == null) {
      synchronized (Singleton.class) {
        if (singleton == null) {
          singleton = new Singleton();
        }
      }
    }
    return singleton;
  }
}
