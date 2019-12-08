package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solutions {
    private List<Integer> listXOdd = new ArrayList<>();
    private List<Integer> listYOdd = new ArrayList<>();
    private List<Integer> listXEven = new ArrayList<>();
    private List<Integer> listYEven = new ArrayList<>();

    public int[] possibleSolutions(int gridSize) {
        for (int i = 0; i < gridSize; i = i + 2) {
            listXEven.add(i);
            listYEven.add(i);
        }
        for (int k = 1; k < gridSize; k = k + 2) {
            listXOdd.add(k);
            listYOdd.add(k);
        }
    }

    public int[] randomSolution() {
        int[] a = new int[] { 1, 2}; //1 is odds, 2 is evens
        int[] solution = new int[2];
        double b = Math.floor(Math.random() * a.length);
        int c = (int) b;
        int d = a[c];
        if (d == 1) {
            Random rand = new Random();
            int randomX = listXOdd.get(rand.nextInt(listXOdd.size()));
            int randomY = listYOdd.get(rand.nextInt(listYOdd.size()));
            solution[0] = randomX;
            solution[1] = randomY;
            return solution;
        } else {
            Random random = new Random();
            int randomX = listXEven.get(random.nextInt(listXOdd.size()));
            int randomY = listYEven.get(random.nextInt(listYOdd.size()));
            solution[0] = randomX;
            solution[1] = randomY;
            return solution;
        }
    }
}
