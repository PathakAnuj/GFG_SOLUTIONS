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
            
            
            int[] B = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.solve(N, A, B);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long solve(int N, int[] A, int[] B) {
        long sumo = 0,ans=0;
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        ArrayList<Integer> d = new ArrayList<>();
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<N;i++){
            sumo+=(A[i]-B[i]);
            if(A[i]%2!=0)a.add(A[i]);
            else b.add(A[i]);
            if(B[i]%2!=0)c.add(B[i]);
            else d.add(B[i]);
        }
        if(sumo!=0 || a.size()!=c.size())return -1;
        for(int i=0;i<a.size();i++){
            ans+=(Math.abs(a.get(i)-c.get(i))/2);
        }
        for(int i=0;i<b.size();i++){
            ans+=(Math.abs(b.get(i)-d.get(i))/2);
        }
        return ans/2;
    }
}
        