//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
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
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.findMaxSubsetSum(N, A);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends




class Solution {
    public static long[][] dp = new long[100001][2];

    static long f(int n, int[] A, boolean prev) {
        if (n == 0) return 0;
        if (dp[n][prev ? 1 : 0] != -1) return dp[n][prev ? 1 : 0];
        long take = 0;
        long not_take = 0;
        if (!prev) {
            take = A[n - 1] + f(n - 1, A, true);
            not_take = Long.MIN_VALUE;
        } else {
            take = A[n - 1] + f(n - 1, A, true);
            not_take = f(n - 1, A, false);
        }
        return dp[n][prev ? 1 : 0] = Math.max(take, not_take);
    }

    public static long findMaxSubsetSum(int N, int[] A) {
        Arrays.fill(dp[0], 0);
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        return Math.max(f(N, A, true), f(N, A, false));
    }
}
        
        
