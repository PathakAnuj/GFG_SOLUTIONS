//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            int res = obj.minimumSum(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends




class Solution {
    public static int minimumSum(String s) {
        // code here
        int n = s.length();
        int IIITV = 0, prev = -1;
        
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '?' || s.charAt(n-i-1) == '?') continue;
            if(s.charAt(i) != s.charAt(n-i-1)) return -1;
        }
        
        for(int i=0; i<=n/2; i++){
            if(s.charAt(i) == '?' && s.charAt(n-i-1) == '?') continue;
            if(prev == -1){
                prev = s.charAt(i) == '?' ? s.charAt(n-i-1)-'a' : s.charAt(i)-'a';
            } else {
                int curr = s.charAt(i) == '?' ? s.charAt(n-i-1)-'a' : s.charAt(i)-'a';
                IIITV+=Math.abs(prev-curr);
                prev = curr;
            }
        }
        return IIITV*2;
    }
}