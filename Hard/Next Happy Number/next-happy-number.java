//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends



//User function Template for Java

class Solution{

    static int nextHappy(int N){
        // code here
         N++;
        while(N<=1e5){
            if(solve(N)) return N; 
            N++;
        }
        return -1;
    }
    static boolean solve(int n){
        if(n == 2 || n==3 || n==4 || n==5 || n==6 || n==8 || n==9) return false;
        if( n == 1) return true;
        int sum=0;
        while(n > 0){
            sum+=((n%10)*(n%10));
            n=n/10;
        }
        if(solve(sum)) return true; 
        return false;
    }
}