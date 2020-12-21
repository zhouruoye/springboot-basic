package com.cest.math;

import org.apache.commons.math3.fitting.GaussianCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

public class CurveFittingTest {

    public static void main(String[] args) {
        WeightedObservedPoints obs = new WeightedObservedPoints();
        obs.add(0, 25);
        obs.add(1, 68);
        obs.add(2, 144);
        obs.add(3, 220);
        obs.add(4, 335);
        obs.add(5, 199);
        obs.add(6, 52);
        obs.add(7, 14);
        obs.add(8, 5);
        obs.add(9, 2);

        double[] parameters = GaussianCurveFitter.create().fit(obs.toList());
        for (double i : parameters) {
            System.out.println(i);
        }
    }
}
