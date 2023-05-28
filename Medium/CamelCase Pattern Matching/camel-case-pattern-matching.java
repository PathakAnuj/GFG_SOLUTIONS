//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String[] Dictionary=read.readLine().split(" ");
            String Pattern=read.readLine();
            Solution ob = new Solution();
            ArrayList <String> ans=ob.CamelCase(N,Dictionary,Pattern);
            for(String u:ans)
             System.out.print(u+" ");
            System.out.println(); 
        }
    }
}
// } Driver Code Ends



//User function Template for Java

class Solution{
    ArrayList<String> CamelCase(int n,String[] Dict,String Pat){
        //code here
        ArrayList<String> deban = new ArrayList<>();
        for(int i=0;i<n;i++){
            int cnt =0;
            for(int j=0;j<Dict[i].length() && cnt<Pat.length();j++){
                if(Dict[i].charAt(j) == Pat.charAt(cnt)){
                    cnt++;
                }
                else if(Dict[i].charAt(j) >= 'A' && Dict[i].charAt(j) <='Z'){
                    break;
                }
            }
            if(cnt == Pat.length())
                deban.add(Dict[i]);
        }
        if(deban.isEmpty())
            deban.add("-1");
        Collections.sort(deban);
        return deban;
    }
}