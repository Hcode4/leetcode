package org.hyz.problem.common;

import java.util.Arrays;

public class SolutionSort {

    public static void bubbleSort(int[] array) {

        for(int i = 0; i < array.length; i++) {
            for(int j = i; j < array.length; j++) {
                if(array[i] > array[j]) {
                    int swap = array[i];
                    array[i] = array[j];
                    array[j] = swap;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] array = {2,3,4,1,19,11};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }


}
