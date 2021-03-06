package com.WholeSuiteGeneration.app.testClasses;

import java.util.EmptyStackException;

public class TestStack {
  int[] values;
  int size = 0;

  public TestStack() {
    values = new int[10];
  }

  public void push(int x) {
    if (size >= values.length) {
      resize();
    }
    if (size < values.length) {
      values[size++] = x;
    }
  }

  public int pop() {
    if (size > 0) {
      return values[size--];
    } else {
      throw new EmptyStackException();
    }
  }

  public void show() {
    for (int i = 0; i < values.length; ++i) {
      System.out.println(values[i]);
    }
  }

  public void resize() {
    int[] tmp = new int[values.length * 2];
    for (int i = 0; i < values.length; ++i) {
      tmp[i] = values[i];
    }
    values = tmp;
  }
}
