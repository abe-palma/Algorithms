import java.io.*;
import java.util.*;

public class Proj6{
    public static void main(final String[] args) throws FileNotFoundException {
        // open file
        final Scanner s = new Scanner(new File("input6.txt"));
        final int n = s.nextInt();

        //print out step count
        System.out.println(steps(n));
    }

    public static int steps(int n){
		//create the array for the memoization
		int[] arr = new int[n+1];							
		//fill array with -1
		for(int i = 0; i < n+1; i++){				//using -1 as flag. memoization.
			arr[i] = -1;
		}
		//recursive kick-off
		return helper(n, arr);
	}
	
	public static int helper(int n, int[] arr){
		//base case
		if(n <= 1) return 1;
		//second case - if memo array has an answer
		//if it has an answer, then we don't have to recurse!
		if(arr[n] != -1) return arr[n];
		
		//recursive calls
		arr[n] = helper(n-1, arr) + helper(n-2, arr);			//filling array at pos n with sum of two prev nums.
		return 	arr[n];						
	}

}