//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends





//User function Template for Java

class Solution
{
    public int closedIslands(int[][] matrix, int N, int M)
    {
        // Code here
         int count = 0;
        for (int i = 0; i < N; i++) {
            dfs(matrix, i, 0);
            dfs(matrix, i, M - 1);
        }
        for (int j = 0; j < M; j++) {
            dfs(matrix, 0, j);
            dfs(matrix, N - 1, j);
        }
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (matrix[i][j] == 1) {
                    if (dfs(matrix, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    private boolean dfs(int[][] matrix, int row, int col) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
            return false;
        }
        if (matrix[row][col] != 1) {
            return true; 
        }
        matrix[row][col] = -1;
        boolean closed = true;
        closed &= dfs(matrix, row + 1, col);
        closed &= dfs(matrix, row - 1, col);
        closed &= dfs(matrix, row, col + 1);
        closed &= dfs(matrix, row, col - 1);
        return closed;
    }
}