package com.hkjava.demo.democalculator.service;

import java.util.List;

public interface CalculatorService{
  /**
   * 
   * @return
   */
  List<String>getStrings();

  /**
   * 
   * @param x
   * @param y
   * @return
   */
   int add (int x,int y);

  /**
   * A method to substract x by y.
   * @param x
   * @param y
   * @return
   */
   int substract(int x, int y);

  /**
   * 
   * @param text
   * @return
   */
   String test(String abc);

   String test2(int y2);
}
