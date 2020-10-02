import java.io.*;
import java.util.*;

public class Proj5{
    public static void main(String[] args) throws FileNotFoundException {
        //open file
        Scanner s = new Scanner(new File("input5.txt"));
        //save data to array list
        final ArrayList<Integer> data = new ArrayList<Integer>();
        while (s.hasNext()) {
            if (s.hasNextInt()) {
                data.add(s.nextInt());
            }
        }
        //convert ArrayList to Integer[] object array
        Integer[] intData = data.toArray(new Integer[data.size()]);

        //lambda function
        Arrays.sort(intData, (Integer a, Integer b) -> {
            if(Math.abs(a) < Math.abs(b)){ return -1; }                          //returning -1 means don't swap if absolute value of a is less than absolute value of b
            if(Math.abs(a) > Math.abs(b)) {return 1; }                           //returning 1 means swap if absolute value of a is greater than absolute value of b
            if(a<b) {return -1;}                                                 //returning -1 means don't swap if a is already less than b
            if(a > b) {return 1;}                                                //returning 1 means swap if a is greater than b
            return 0;
        });

        //print out array
        System.out.println(Arrays.toString(intData));
    }
}