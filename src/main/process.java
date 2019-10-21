package main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class process
{

    private String filepath;
    private int CasesNum,itemsNum,Size;
    private int [][] arr;
    private Case []cases;
    public process()
    {
        filepath="C:\\Users\\moham\\IdeaProjects\\untitled2\\src\\test";
    }
    public  void readfile(String filepath) throws IOException, NullPointerException {

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
        }
    }

    public void run() throws IOException {
        readfile(filepath);
        for (int i=0;i<cases.length;i++)
        {
            cases[i].print();
            for (int j=0;j<cases[i].getItemsNum()/2;j++)
                System.out.print(cases[i].calFitness(j)+"           ");
            System.out.println();
        }

    }
}
