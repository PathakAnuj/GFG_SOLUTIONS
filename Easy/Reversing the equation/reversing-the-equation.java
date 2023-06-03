//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            String s;
            s = in.readLine().trim();
            
            Solution ob = new Solution();
            
            out.println(ob.reverseEqn(s));    
        }
        out.close();
    }
}
// } Driver Code Ends



//User function Template for Java
class Solution {
    String reverseEqn(String S) {
        StringBuilder sb = new StringBuilder();
        StringBuilder currentNumber = new StringBuilder();
        
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            
            if (Character.isDigit(c)) {
                currentNumber.append(c);
            } else {
                // Add the current number to the result
                if (currentNumber.length() > 0) {
                    sb.append(currentNumber.reverse());
                    currentNumber.setLength(0);
                }
                
                // Add the operator to the result
                sb.append(c);
            }
        }
        
        // Add the last number to the result
        if (currentNumber.length() > 0) {
            sb.append(currentNumber.reverse());
        }
        
        return sb.reverse().toString();
    }
}