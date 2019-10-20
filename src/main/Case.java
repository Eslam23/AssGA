
package main;
import java.io.*; 
import java.util.Random;

public class Case {
    
  int itemsNum;
    int Size;
    int [][]arr;
    int fitness=0;
    int []genes;

    public Case(int itemsNum, int size, int[][] arr) {
        
        fitness=0;
        
         this.itemsNum = itemsNum;
         Size = size;
         this.arr = arr;
    }
    
    public void print()
    {
        System.out.println(itemsNum+"\n"+Size);
        for(int j=0;j<itemsNum;j++)
            System.out.println(arr[j][0]+"  "+arr[j][1]);
    }

}
