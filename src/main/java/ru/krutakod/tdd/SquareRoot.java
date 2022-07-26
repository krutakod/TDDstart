package ru.krutakod.tdd;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class SquareRoot {

    public double[] squareRoot(double a, double b, double c, double eps) {
        if (abs(a) < eps) {
            throw new IllegalArgumentException("Parameter a mustn't to be 0");
        }
        double[] result;
        double D = b * b - 4 * a * c;

        if (D < -eps) {
            result = new double[0];
        } else if (D > eps) {
            result = new double[]{(-b + sqrt(D)) / (2 * a), (-b - sqrt(D)) / (2 * a)};
        } else if (abs(D) < eps) {
            result = new double[]{(-b) / (2 * a)};
        } else {
            throw new ArithmeticException("Wow , you are so crazyyy like as you had broke math ＼(￣▽￣)／");
        }

        return result;
    }

}