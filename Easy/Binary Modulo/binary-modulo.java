//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			String s = str[0];
			int m = Integer.parseInt(str[1]);
			Solution obj = new Solution();
			System.out.println(obj.modulo(s,m));
		}
	}
}

// } Driver Code Ends

class Solution{
	int modulo(String s, int m) {
		int value = convertBinary(s, m);
		return value%m;
	}
	
	int convertBinary(String s, int m){
	    int index = 1;
	    int ramresult = 0;
	    
	    for(int i=s.length()-2; i>=0; i--){
	        index = ((index)%m * (2)%m)%m;
	        
	        if(s.charAt(i)=='1'){
	            ramresult= ((ramresult%m) + (index%m))%m;
	        }
	    }
	    
	    if(s.charAt(s.length()-1)=='1'){
	        ramresult+=1;
	    }
	    
	    return ramresult;
	}
}