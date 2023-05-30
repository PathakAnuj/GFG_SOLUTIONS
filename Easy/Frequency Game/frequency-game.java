//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

// Position this line where user code will be pasted.

// Driver class with main function
class GFG {
    // Main function
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        // Iterating over testcases
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            int arr[] = new int[n];

            String s[]=in.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            System.out.println(obj.LargButMinFreq(arr, n));
        }
    }
}
// } Driver Code Ends



// User function Template for Java

// Helper class to find largest number with minimum frequency
class Solution {
    public static int LargButMinFreq(int arr[], int n) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int minFreqCount=Integer.MAX_VALUE;
        int maxNumber=0;
        for(int ele:arr)map.put(ele,map.getOrDefault(ele,0)+1);
        for(int key:map.keySet()){
            int freq=map.get(key);
            if(freq<minFreqCount || (freq==minFreqCount&&maxNumber<key)){
                minFreqCount=freq;
                maxNumber=key;
            }
        }
        return maxNumber;
    }
}