//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function template for JAVA
class Solution {
    // Function to find the minimum index of a character in str that is also present in patt.
    public static int minIndexChar(String str, String patt) {
        boolean[] present = new boolean[256]; // Assuming ASCII characters
        
        for (int i = 0; i < patt.length(); i++) {
            present[patt.charAt(i)] = true;
        }
        
        for (int i = 0; i < str.length(); i++) {
            if (present[str.charAt(i)]) {
                return i;
            }
        }
        
        return -1;
    }
}




//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
		    t--;
		    
		    String s1=sc.next();
		    String s2=sc.next();
		    
		    int res = new Solution().minIndexChar(s1, s2);
		    System.out.println(res);
		}
	}
}

// } Driver Code Ends