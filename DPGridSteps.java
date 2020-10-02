import java.io.*;
import java.util.*;

public class Proj8{
	public static void main(final String[] args) throws FileNotFoundException {
        // open file and save values
        final Scanner s = new Scanner(new File("input8.txt"));
        final int n1 = s.nextInt();
        final int n2 = s.nextInt();

        //print out step count
        System.out.println(goal(n1, n2));
    }

    public static int goal(int n1, int n2){
		//create the array for the memoization
		int[][] arr = new int[n1+1][n2+1];							
		//fill array with 1
		for(int i = 0; i < n1+1; i++){				
            for(int j = 0; j <n2+1; j++ ){
                //using 1 as flag for memoization
                arr[i][j] = 1;
            }
		}
		//base case
		if(n1 <= 1 || n2 <= 1) return 1;
        
        //second case - if memo array has an answer
        if(arr[n1][n2] != 1) return arr[n1][n2];
        
        //initialize max number of steps needed to get to goal
        int maxWays = arr[0][0];

        //go through array to set number of ways to get to each position 
        for(int k = 1; k < n1; k++){
            for(int l = 1; l < n2; l++){
                arr[k][l] = (arr[k-1][l] + arr[k][l-1]);
                //if value in position is bigger than maxWays, it becomes the new max
                if(arr[k][l] > maxWays){
                    maxWays = arr[k][l];
                }
            }
        }

        //return the number of steps required to get to the goal
        return maxWays;
	}

}
