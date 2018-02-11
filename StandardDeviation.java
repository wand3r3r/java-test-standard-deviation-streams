// package com.StandardDeviation;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

class StandardDeviation {

  protected static Double calcSD(ArrayList<Integer> l){
    // calculate the standard deviaiton
    // First get mean of numbers
    Double m = l.stream()
      .mapToDouble((v) -> v.doubleValue())
      .average()
      .getAsDouble();
    // System.out.println(m);
    Double rawSum = l.stream()
      .reduce(0.0,
        (sum, v) -> sum += Math.pow(v.doubleValue() - m,2),
        (sum1, sum2) -> sum1 + sum2);
    // System.out.println(rawSum);
    Double sd = Math.sqrt(rawSum/(l.size()-1));
    System.out.println(sd);
    return sd;
  }

  public static void main(String[] args){
    //SecureRandom rand = new SecureRandom();
    Random rand = new Random();
    int size = 10000;
    int increment = 10;
    ArrayList<Integer> l = new ArrayList<Integer>(size);

    for(int i = 0; i<size; i++){
      l.add(new Integer(rand.nextInt()));
    }

    // get standard deviation values
    ArrayList<Double> sdlist = new ArrayList<Double>(size/increment);
    for(int i = 0; i < size/increment; i++){
      // get the first n 
      ArrayList<Integer> tmpl = new ArrayList<Integer>((i+1)*increment);
      for(int j = 0; j < (i+1)*increment; j++){
        tmpl.add(l.get(j));
      }
      Double d = StandardDeviation.calcSD(tmpl);
      sdlist.add(d);
    }
  }
};
