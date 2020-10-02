import java.io.*;
import java.util.*;

public class Proj4{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input4.txt"));
        int wtmax = s.nextInt();
        //fill values arraylist
        final ArrayList<Integer> val = new ArrayList<Integer>();
        while (s.hasNext()) {
            if (s.hasNextInt()) {
                val.add(s.nextInt());
            }
        }
        //fill weights arraylist
        final ArrayList<Integer> wt = new ArrayList<Integer>();
        while(s.hasNext()){
            if(s.hasNextInt()){
                wt.add(s.nextInt());
            }
        }
        //convert value arraylist to int array
        final int[] value = new int[val.size()+1];
        for (int i = 0; i < 3; i++) {
            value[i] = val.get(i).intValue();
        }
        //convert weight arraylist to int array
        final int[] weight = new int[wt.size()+1];
        for(int j = 4; j < (weight.length-1); j++){
            weight[j] = wt.get(j).intValue();
        }
    
        System.out.println(knapsack(value, weight, weight.length-1, wtmax));
    }

    public static int knapsack(int value[], int weight[], int totitem, int wmax){
        //memo array
        int[] key = new int[value.length]; 
        
        //filling memo array
        Arrays.fill(key, -1);

        //recursive kick off
        return helper(key, value, weight, totitem, wmax, 0);
    }

    public static int helper(int key[], int value[], int weight[], int wmax, int totitem, int index){
        //if we go out of bounds or the total weight is 0, return 0. this is the base case
        if(index >= value.length || wmax ==0) return 0;
        
        //second case: if key has an answer at the index, return the answer
        if(key[index] != -1) return key[index];

        //recursive calls
        if(wmax-weight[index] < weight[index]) {
            key[index] = helper(key, value, weight, wmax - weight[index], totitem, index+1);
        }
        else{
            key[index] = Math.max(value[index] + helper(key, value, weight, wmax - weight[index], totitem, index+1),
                                helper(key, value, weight, wmax - weight[index], totitem, index+1));
        }
        return key[index];
    }
}