
package main;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class chromosome {
    int fitness = 0;
    int[] genes;
   String filepath;

    public chromosome(int itemNum) {
        Random rn = new Random();
        genes=new int[itemNum];

        //Set genes randomly for each individual
        for (int i = 0; i <itemNum; i++) {
            genes[i] = Math.abs(rn.nextInt() % 2);
        }
        
        fitness = 0;
    }
    public int calcFitness(int [][]arr) {

        fitness = 0;
        for (int i = 0; i <genes.length ; i++) {
            if (genes[i] == 1) {
                fitness+=arr[i][1];
            }
            
        }
        return fitness;
    }

    
}