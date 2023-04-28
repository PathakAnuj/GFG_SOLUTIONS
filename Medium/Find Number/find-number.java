//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            long n=Long.parseLong(in.readLine());
            Solution ob=new Solution();
            out.println(ob.findNumber(n));
        }
        out.close();
    }
}

// } Driver Code Ends





//User function Template for Java
//User function Template for Java
class Solution
{
    public long findNumber(long N)
    {
		long[] v = { 9, 1, 3, 5, 7 };
	    long anuj = 0;
	    while (N > 0) {
	      anuj = anuj * 10 + v[(int)(N % 5)];
	      if (N % 5 == 0) {
	        N = N / 5;
	        N--;
	      }
	      else
	        N /= 5;
	    }
	    Queue<Long> q = new ArrayDeque<>();
	    while (anuj > 0) {
	      q.add(anuj % 10);
	      anuj /= 10;
	    }
	    while (!q.isEmpty()) {
	      anuj = anuj * 10 + q.peek();
	      q.remove();
	    }
	    return anuj;
    }
}