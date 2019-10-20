
package main;
import java.io.File;
import java.io.IOException;
import java.util.Random;
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
 static void crossover(chromosome arr[]) {
        Random rn = new Random();
    for(int x=0;x<arr.length;x+=2){
        //Select a random crossover point
        int crossOverPoint = rn.nextInt(arr[0].genes.length);
        //Swap values among parents
        for (int i =crossOverPoint; i <arr[0].genes.length; i++) {
            int temp = arr[x].genes[i];
            arr[x].genes[i] = arr[x+1].genes[i];
            arr[x+1].genes[i] = temp;

        }
        }

    }
 static void mutation(chromosome arr[],double pm) {
        Random rn = new Random();
        for(int x=0;x<arr.length;x++){
            for(int y=0;y<arr[x].genes.length;y++){
             double chek_pro = Math.random();
             System.out.println(chek_pro);
             if(chek_pro>pm){
                 System.out.println("here");
                 if (arr[x].genes[y] == 0){
                     arr[x].genes[y] = 1;
                    
                 }
                 else
                     arr[x].genes[y] = 0;
             }
             else{
                 continue;
             }
            }
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
        for(int i=0;i<2;i++)
            System.out.print(c.genes[i]);
        System.out.println(c.calcFitness(arr,3));
        
        chromosome[] solution = new chromosome[10];
        //Initialize population
        for (int i = 0; i <10; i++) {
            solution[i] = new chromosome(4);
        }
        for (int i = 0; i <10; i++) {
            for(int t=0;t<4;t++){
                
              System.out.print(solution[i].genes[t]);
              //System.out.println(solution[i].calcFitness(arr,5));    
            }
           System.out.println();
           //int r=solution[i].calcFitness(arr, 3);
        }
        
        crossover(solution);
        for (int i = 0; i <10; i++) {
            for(int t=0;t<4;t++){
                
              System.out.print(solution[i].genes[t]);
              //System.out.println(solution[i].calcFitness(arr,5));    
            }
           System.out.println();
           //int r=solution[i].calcFitness(arr, 3);
        }
        mutation(solution,0.5);
        for (int i = 0; i <10; i++) {
            for(int t=0;t<4;t++){
                
              System.out.print(solution[i].genes[t]);
              //System.out.println(solution[i].calcFitness(arr,5));    
            }
           System.out.println();
           //int r=solution[i].calcFitness(arr, 3);
        }
        
        //System.out.print(solution[0].calcFitness(arr));
        //System.out.print(solution[1].calcFitness(arr));
        //for (int i = 0; i <10; i++) {
          //  for(int t=0;t<4;t++){
                
            //  System.out.print(solution[i].genes[t]);
              //System.out.println(solution[i].calcFitness(arr));    
        //}
          //  System.out.println();
            //System.out.println(solution[i].calcFitness(arr));
        //}
        
        
    }
}