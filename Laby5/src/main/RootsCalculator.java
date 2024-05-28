package main;

import java.util.*;
import java.lang.Math;
public class RootsCalculator {
    public static List<Double> calculate_roots(double a, double b, double c) {
        List<Double> roots = new ArrayList<Double>();
        if (a!=0) {
            Double delta = b * b - 4 * a * c;
            if (delta > 0) {
                Double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                Double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                roots.add(x1);
                roots.add(x2);
            } else if (delta == 0) {
                Double x = -b / (2 * a);
                roots.add(x);
            }
        }
        else {
            if (b!=0){
                Double x = -c/b;
                roots.add(x);
            }
            else {
                if (c==0){
                    Double inf = Double.POSITIVE_INFINITY;
                    roots.add(inf);
                }
            }
        }
        System.out.println(roots);
        return roots;
    }

    public static void main (String[] args){
    }
}
