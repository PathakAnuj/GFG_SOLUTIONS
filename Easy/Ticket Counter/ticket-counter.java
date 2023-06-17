//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int k=Integer.parseInt(s[1]);
            Solution ob=new Solution();
            out.println(ob.distributeTicket(n,k));
        }
        out.close();
    }
}
// } Driver Code Ends



//User function Template for Java
class Solution {
    public static int distributeTicket(int n,int k)
    {
        int left=1,right=n;
        
        
        while(left<right){
            int counter = k;
            
            while(left<right && counter>0) {
                left++;
                counter--;
            }
            counter=k;
            while(right>left && counter>0){
                right--;
                counter--;
            }
        }
        
        return left;
    }
}