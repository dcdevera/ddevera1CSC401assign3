
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
        //attempted to use random array, got out of bounds error, using pre-filled array
        int[] array = {1, 5, 9, 12, 16, 19, 23, 33}; //array needs to be sorted to work
        int[] array2 = {2, 6, 8, 11, 15, 20};
        int[] array3 = {3, 7, 19, 20, 34};
        int key = 12;
        System.out.println("Given array:");
        for(int i = 0;i<array.length;i++)
        {
          System.out.println(array[i]);   
        }
        //change array and key for different outputs
        System.out.println("Index of key value: ");
        System.out.println(NewBinarySearch(array, key, 0, array.length));
    }
    
    public static int NewBinarySearch(int[] A, int key, int low, int high)
    {
        //if start index is larger than end index
        if(low > high)
        {
            return -1;
        }
        else
        {
            int x = low + ((high - low)/3); //lower array index
            int y = high - ((high - low)/3);    //higher array index
        
            if(key == A[x]) //if lower array index equals key
            {
                return x;
            }
            else if(key == A[y])    //if higher array index equals key
            {
                return y;
            }
            else if(key < A[x]) //if key is less than lower array index
            {
                return NewBinarySearch(A, key, low, x-1);
            }
            else if(key > A[y]) //if key is greater than higher array index
            {
                return NewBinarySearch(A, key, y+1, high);
            }
            else //this else searches the middle array
            {
                return NewBinarySearch(A, key, x-1, y+1);
            }
        }
    }
}


