import java.io.*;
import java.util.*;

public class Proj7{
    public static void main(String[] args) throws FileNotFoundException{
        //open file
        final Scanner s = new Scanner(new File("input7.txt"));
        //add data to arrayList
        final ArrayList<Integer> data = new ArrayList<Integer>();
        while (s.hasNext()) {
            if (s.hasNextInt()) {
                data.add(s.nextInt());
            }
        }

        //convert arraylist to int array
        final int[] arr = new int[data.size()];
        for (int i = 0; i < data.size(); i++) {
            arr[i] = data.get(i).intValue();
        }

        //set max to first value in array
        int max = arr[0];
        for(int j = 0; j < arr.length; j++){
            //if index + array is bigger than max, this is new max
            //max is the furthest we can jump
            if((j + arr[j]) > max){
                max = (j + arr[j]);
            }
        }

        //if max is bigger than array size, we can make all the jumps
        if(max > arr.length){
            System.out.println("yes\n");
        }
        //else we can't
        else{
            System.out.println("no\n");
        }
    }
}