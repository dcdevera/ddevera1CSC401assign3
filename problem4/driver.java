
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
        //creates random array with size inputted by user
        Scanner input = new Scanner(System.in);
        int size;
        int rand;
        //asks user to enter array size
        System.out.println("Enter size of array:");
        size = input.nextInt();
        //displays random generated array
        System.out.println("Initial Array:");
        int[] array = new int[size];
        for(int i = 0;i<size;i++)
        {
            //makes the contents of the array be a range of (-size,size)
            array[i] = -size + (int)(Math.random()*((size-(-size))+1));
            System.out.println(array[i]);
        }
        System.out.println("Number of inversions:");
        System.out.println(InversionCount(array));
        System.out.println("Sum of max subarray:");
        System.out.println(MaxSub(array,0,array.length-1));
    }
    //counts the number of inversion
    public static int InversionCount(int[]A)
    {
        int x = 0;
        for(int i = 0;i<A.length-1;i++)
        {
            for(int j = 0;j<A.length;j++)
            {
                if(A[i] > A[j])
                {
                    x++;
                }
            }
        }
        return x;
    }
    //determines the maximum subarray
    public static int MaxSub(int[] A, int low, int high)
    {
        if(low == high)//case if array is size 1
        {
            return A[low];
        }
        else
        {
            int z = (low+high)/2;//sets middle index
            
            int x = MaxSub(A,low,z);//left side
            int y = MaxSub(A,z+1,high);//right side
            //compares return value from SubCross and compares it to largest value of MaxSub
            //returns the largest value of the two
            return Math.max(Math.max(MaxSub(A,low,z),MaxSub(A,z+1,high)),SubCross(A,low,high,z));
        }
    }
    //adds crossing subarray then returns the largest value
    public static int SubCross(int[] A, int low, int high, int mid)
    {
        int x = 0;//used for adding values
        int left = 0;//final sum of left side
        for(int i = mid;i>=low;i--)
        {
            x = x + A[i];
            if(x > left)
            {
                left = x;
            }
        }
        int y = 0;//used for adding values
        int right = 0;//final sum of right side
        for(int i = mid+1;i<=high;i++)
        {
            y = y + A[i];
            if(y > right)
            {
                right = y;
            }
        }
        //compares both sides added with maximum of left or right, then returns largest of the two
        return Math.max(left+right,Math.max(left,right));
    }
}
