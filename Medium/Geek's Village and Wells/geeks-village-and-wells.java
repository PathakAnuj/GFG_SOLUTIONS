//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Gfg {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int m=Integer.parseInt(s[1]);
            char c[][]=new char[n][m];
            for(int i=0;i<n;i++){
                s=in.readLine().trim().split(" ");
                for(int j=0;j<m;j++){
                    c[i][j]=s[j].charAt(0);
                }
            }
            Solution ob=new Solution();
            int ans[][]=ob.chefAndWells(n, m, c);

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    out.print(ans[i][j]+" ");
                }
                out.println();
            }
        }
        out.close();
    }
}
// } Driver Code Ends



//User function Template for Java
class Solution
{
   int dir[][] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
            
    public int[][] chefAndWells(int m,int n,char arr[][])
    {
        int res[][] = new int[m][n];
        for(int r[] : res) Arrays.fill(r, Integer.MAX_VALUE);
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(arr[i][j] == 'W'){
                    res[i][j] = 0;
                    q.add(new int[]{i, j, 0});
                }
            }
        }
        while(!q.isEmpty()){
            int tar[] = q.poll();
            for(int i = 0;i<4;i++){
                int r = tar[0]+dir[i][0],  c = tar[1]+dir[i][1]; 
                if(r>=0 && c>=0 && r<m && c<n && (arr[r][c] == 'H' || arr[r][c] == '.')){
                    if(res[r][c]>tar[2]+2){
                        res[r][c] = tar[2]+2;
                        q.add(new int[]{r, c, tar[2]+2});
                    }
                }
            }
        }
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                
                if(res[i][j] == Integer.MAX_VALUE) res[i][j] = -1;
                if(arr[i][j] == '.' || arr[i][j] == 'N'){
                    res[i][j] = 0;
                }
            }
        }
        return res;
        
    }
}