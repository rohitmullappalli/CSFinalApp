package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Solutions {
    public int[] possibleSolutions(int gridSize) {
        int[] solutions = new int[(gridSize * gridSize) / 2];
        List<Integer> listXOdd = new ArrayList<>();
        List<Integer> listYOdd = new ArrayList<>();
        List<Integer> listXEven = new ArrayList<>();
        List<Integer> listYEven = new ArrayList<>();
        for(int i = 0; i < gridSize; i = i + 2) {
            listXEven.add(i);
            listYEven.add(i);
        }
        for (int k = 1; k < gridSize; k = k + 2) {
            listXOdd.add(k);
            listYOdd.add(k);
        }
    }
}
