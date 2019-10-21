
package main;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class chromosome
{
     int [] genes;
    public chromosome(int size)
    {
        genes=new int[size];
        Random rn = new Random();
        for (int i = 0; i <size; i++) {
            genes[i] = Math.abs(rn.nextInt() % 2);
        }
    }


    public void print()
    {
        for(int i=0;i<genes.length;i++)
            System.out.print(genes[i]+"  ");

    }
}
