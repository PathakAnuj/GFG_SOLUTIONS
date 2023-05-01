//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends



class Solution {
    static int majorityElement(int a[], int size)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Count the occurrences of each element in the array
        for (int i = 0; i < size; i++) {
            int key = a[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        
        // Check if any element appears more than N/2 times
        int majority = -1;
        for (int key : map.keySet()) {
            if (map.get(key) > size / 2) {
                majority = key;
                break;
            }
        }
        
        return majority;
    }
}
