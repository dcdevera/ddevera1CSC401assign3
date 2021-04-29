
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
        //different arrays for testing
        int[] array = {1,2,1,1,3,1};
        int[] array2 = {2,4,5,5,5,6,1,5,7,5,5};
        int[] array3 = {6};
        System.out.println("Given array: ");
        for(int i = 0;i<array3.length;i++)
        {
            System.out.println(array3[i]);
        }
        System.out.println("Majority value in array: ");
        System.out.println(FindMajority(array3,0,array3.length-1));
    }
    //similar to problem 2
    public static int FindMajority(int[] A, int low, int high)
    {
        if(low == high) //case if start and end index are the same/ array length is 1
        {
            return A[low];
        }
        else
        {
            int z = (low+high)/2;//divide array with middle index
            int x = FindMajority(A,low,z);//left side
            int y = FindMajority(A,z+1,high);//right side
            int leftCount = 0;//for counting left side
            int rightCount = 0;//for counting right side
            if(x == y) //case if there is only one integer
            {
                return x;
            }
            else
            {
                //count both sides for majority
                //while loop causes infinite loop
                for(int i = z;i>low; i--)
                {
                    if(A[i] == x)
                    {
                        leftCount = leftCount+1;
                    }
                }
                for(int i = z+1;i<high;i++)
                {
                    if(A[i] == y)
                    {
                        rightCount = rightCount+1;
                    }
                }
                //compare both counts to array length/2
                if(leftCount > (A.length/2))
                {
                    return x;
                }
                else if(rightCount > (A.length/2))
                {
                    return y;
                }
                else
                {
                    return -1; //if neither x or y are the majority
                }
            }
        }
    }
}
