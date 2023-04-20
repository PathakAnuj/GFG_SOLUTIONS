//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class code1 
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[]=in.readLine().trim().split(" ");
            String s2[]=in.readLine().trim().split(" ");

            Solution ob=new Solution();
            int ans=ob.prefixSuffixString(s1,s2);
            out.println(ans);

        }
        out.close();
    }
}
// } Driver Code Ends




//User function Template for Java


class Solution
{
    public int prefixSuffixString(String s1[],String s2[])
    {
        int count = 0;
        for(int i=0; i<s2.length; i++){
            String str = s2[i];
            int len = str.length();
            for(int j=0; j<s1.length; j++){
                String ramPot = s1[j];
                if(len <= ramPot.length()){
                    if(str.equals(ramPot.substring(0, len))){
                        count++;
                        break;
                    }
                    if(str.equals(ramPot.substring(ramPot.length() - len))){
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
}