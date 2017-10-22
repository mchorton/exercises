/**
 * Given an array of length n, find the minimum sum of k consecutive values 
 *  example: array = [1, 2, 3, 4, 5];
 *           k = 2
 ***/


import java.io.*;
import java.util.*;

class AdobeInterview {
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] array = new int[] {5, 1, 2, 3, -8, 0, 4, 5};
        int k = 2;
        
        // sum value initialized
        int sum = 0;
        
        // find sum of first set of k values (array[0]:array[k-1]) 
        for (int i = 0; i < k; i++) {
            sum += array[i];
        }
        
        int testMinSum = 0;
        
        // iterate through subsequent k subsets of array, looking for minimum
        // increment starting index by 1 for each array sum to test
        int idx = 1;
        while (idx < array.length - k) {
            for (int subIdx = idx; subIdx - idx < k; subIdx++) {
                testMinSum += array[subIdx];
            }
            if (testMinSum < sum) {
                sum = testMinSum;
            }
            testMinSum = 0;
            idx++;
        }
        
        // website! (still a WIP) 
        // https://etcadinfinitum.github.io/
        
        

        System.out.println(sum);
    }
}

