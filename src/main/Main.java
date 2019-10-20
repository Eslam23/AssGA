
package main;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Main {
 public static void readf(String filepath) throws IOException, NullPointerException {
        int CasesNum,itemsNum,Size;
        int [][] arr;
        Case []cases;
        Scanner file = new Scanner(new File(filepath));
        int i;
        CasesNum = file.nextInt();
        cases=new Case[CasesNum];
        for (int k = 0; k < CasesNum; k++) {
            itemsNum = file.nextInt();
            Size = file.nextInt();
            arr = new int[itemsNum][2];
            for (int j = 0; j < itemsNum; j++) {
                i = file.nextInt();
                arr[j][0] = i;
                i = file.nextInt();
                arr[j][1] = i;
            }
            cases[k]=new Case(itemsNum,Size,arr);
            cases[k].print();
        }
    }
    public static void main(String[] args) throws IOException {
        //chromosome x= new chromosome();
        String filepath="input_example.txt";
        readf(filepath);
        int [][]arr=new int[2][2];
        arr[0][0]=3;
        arr[0][1]=2;
        arr[1][0]=3;
        arr[1][1]=2;
        
         Case cc=new Case(3,10,arr);
        chromosome c=new chromosome(2);
        System.out.println(c.calcFitness(arr));
        
    }
}