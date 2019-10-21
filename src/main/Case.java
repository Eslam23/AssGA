
package main;
import java.util.Random;

public class Case
{
    private int itemsNum;
    private int Size;
    private int [][]arr;
    private chromosome [] chromosomes;
    private chromosome [] selected;
    double pm;

    public Case(int itemsNum, int size, int[][] arr) {
        this.itemsNum = itemsNum;
        Size = size;
        this.arr = arr;
        chromosomes=new chromosome[itemsNum];
        selected=new chromosome[itemsNum/2];
        for (int i=0;i<itemsNum;i++)
            chromosomes[i]=new chromosome(itemsNum);
        for (int i=0;i<itemsNum/2;i++)
            selected[i]=new chromosome(itemsNum);

    }
    public int getItemsNum() {
        return itemsNum;
    }

    public void setItemsNum(int itemsNum) {
        this.itemsNum = itemsNum;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public int[][] getArr() {
        return arr;
    }

    public void setArr(int[][] arr) {
        this.arr = arr;
    }
    public int calFitness(int index)
    {
        int fitness=0;
        int weight=0;
        for(int i=0;i< itemsNum;i++)
        {
            weight+=chromosomes[index].genes[i]*arr[i][0];
            fitness+=chromosomes[index].genes[i]*arr[i][1];
        }
        if (weight>Size)
            return -1;
        else
            return fitness;
    }
    public void selection()
    {
        //selection using roulette wheal
        int [] prop=new int[itemsNum+1];
        int total=0;
        for(int i=0;i<itemsNum;i++)
            total+=calFitness(i);
        prop[0]=0;
        for(int i=1;i<itemsNum+1;i++)
            prop[i]=(prop[i-1]+calFitness(i))/total;
        for(int i=0;i<itemsNum/2;i++)
        {
            Random rn = new Random();
            double porp1=Math.abs(rn.nextDouble()%1);
            for(int j=0;j<itemsNum+1;j++)
            {
                if(porp1>=prop[j]&&porp1<prop[j+1])
                    selected[i]=chromosomes[j];
            }
        }
    }
    public void crossover()
    {
        Random rn = new Random();
        for(int x=0;x<selected.length;x+=2){
            //Select a random crossover point
            int crossOverPoint = rn.nextInt(selected[0].genes.length);
            //Swap values among parents
            for (int i =crossOverPoint; i <selected[0].genes.length; i++) {
                int temp = selected[x].genes[i];
                selected[x].genes[i] = selected[x+1].genes[i];
                selected[x+1].genes[i] = temp;

            }
        }

    }
    public void mutation() {
        Random rn = new Random();
        for (int x = 0; x < selected.length; x++) {
            for (int y = 0; y < selected[x].genes.length; y++) {
                double chek_pro = Math.random();
                System.out.println(chek_pro);
                if (chek_pro > pm) {
                    System.out.println("here");
                    if (selected[x].genes[y] == 0) {
                        selected[x].genes[y] = 1;

                    } else
                        selected[x].genes[y] = 0;
                } else {
                    continue;
                }
            }
        }
    }
    public void print()
    {
        for(int j=0;j<itemsNum/2;j++)
        {
            selected[j].print();
            System.out.print("|");
        }
    }

}
