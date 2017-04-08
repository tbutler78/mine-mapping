package com.tbutler78.minemapping.util;

/**
 * Created by butlert on 8/18/16.
 */
public class Test {

  public static void main(String args[]){
    Identity<String> idString = new Identity<>("abc");
    Identity<Integer> idInt = idString.map(String::length);
    System.out.print(idString);
  }
}
