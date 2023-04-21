//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine());
            String s[]=in.readLine().trim().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long ans[]=ob.smallerSum(n,a);
            for(long i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long[] smallerSum(int n,int arr[])
    {
        int max=0;
        for(int i=0;i<n;i++)
          max=Math.max(max,arr[i]);
          
        long uper[]=new long[max+1];
          
          
         
         for(int i=0;i<n;i++){
             ++uper[arr[i]];
         }
         
         
         for(int i=2;i<uper.length;i++){
             uper[i]=uper[i]*i+uper[i-1];
         }
         
        long ans[]=new long[n];
        
        for(int i=0;i<n;i++){
            if(arr[i]>1)
            ans[i]=uper[arr[i]-1];
        }
        
        return ans;
    }
}