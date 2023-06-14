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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends



//User function Template for Java
class Solution{
    static String longestPalin(String A){
        // code here
        int maxPalindrone=1;
        int start=0,end=1;
        for(int i=1;i<A.length()-1;i++){
            int length=0;
            int s=i-1,e=i+1;
            while(s>=0 && e<A.length() && A.charAt(s)==A.charAt(e)){
                length+=2;
                s--;
                e++;
            }
            if(maxPalindrone<length){
                maxPalindrone=length;
                start=s+1;
                end=e;
            }
        }
        for(int i=0;i<A.length()-1;i++){
            if(A.charAt(i)==A.charAt(i+1)){
                int length=2;
                int s=i-1,e=i+2;
                while(s>=0 && e<A.length() && A.charAt(s)==A.charAt(e)){
                    length+=2;
                    s--;
                    e++;
                }
            if(maxPalindrone<length){
                maxPalindrone=length;
                start=s+1;
                end=e;
            }
            }

        }
        return A.substring(start,end);
    }
}