//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String str;
            str = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.stringMirror(str);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String stringMirror(String str) {
        // code here
        char l=str.charAt(0);
        StringBuilder tmp=new StringBuilder(),ans=new StringBuilder(),ram=new StringBuilder();
        tmp.append(str.charAt(0));
        for(int i=1;i<str.length();i++)
        {
            if(str.charAt(i)<l)
            {
                l=str.charAt(i);
                tmp.append(l);
            }
            else break;
        }
        ans.append(tmp);
        tmp.reverse();
        ans.append(tmp);
        tmp=new StringBuilder();
        tmp.append(str.charAt(0));
        l=str.charAt(0);
        for(int i=1;i<str.length();i++)
        {
            if(str.charAt(i)<=l)
            {
                l=str.charAt(i);
                tmp.append(l);
            }
            else break;
        }
        ram.append(tmp);
        tmp.reverse();
        ram.append(tmp);
        if(ans.toString().compareTo(ram.toString())<=0){
            return ans.toString();
        }
        else
        {
            return ram.toString();
        }
    }
}    