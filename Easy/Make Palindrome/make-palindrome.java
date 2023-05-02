//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            boolean res = obj.makePalindrome(n, arr);
            
            String _result_val = (res) ? "YES" : "NO";
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends




class Solution {
    public static boolean makePalindrome(int n, String[] arr) {
        Map<String, Integer> counts = new HashMap<>();
        for (String s : arr) {
            counts.put(s, counts.getOrDefault(s, 0) + 1);
            counts.put(new StringBuilder(s).reverse().toString(), counts.getOrDefault(new StringBuilder(s).reverse().toString(), 0) + 1);
        }
        int oddCount = 0;
        for (int count : counts.values()) {
            if (count % 2 == 1) {
                oddCount++;
                if (oddCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
        