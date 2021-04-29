
/**
 * Write a description of class driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class driver
{
    public static void main(String[] args)
    {
        //array filled with random integers
        int[] array = new int[10];
        //max range of integer is 20 for testing
        for(int i = 0;i < array.length;i++)
        {
            array[i] = (int)(Math.random()*20);
            System.out.println(array[i]);
        }
        //prints out the largest integer in the array
        System.out.println("Largest integer found in array:");
        System.out.println(FindLargest(array,0,array.length-1));
    }
    
    public static int FindLargest(int[] A, int low, int high)
    {
        if(low == high) //if low and high are the same number
        {
            return A[low]; //return value of of index low
        }
        else
        {
            int z = (low+high)/2; //sets an index on the middle of the array
            
            int x = FindLargest(A,low,z); //searches left side of array
            int y = FindLargest(A,z+1,high);//searches right side of array
            
            //compares largest integers on both sides
            if(x > y)   //if left side is larger, return left side
            {
                return x;
            }
            else        //else return right side
            {
                return y;
            }
        }
    }
}
