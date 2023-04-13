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
            
            
            int[] color = IntArray.input(br, N);
            
            
            int[] radius = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.finLength(N, color, radius);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int finLength(int N, int[] color, int[] radius) {
    
        List<Integer> coloro = new ArrayList<>();
        List<Integer> radio = new ArrayList<>();
        for(int i=0; i<N; i++){
            coloro.add(color[i]);
            radio.add(radius[i]);
        }
        return recRemBalls(coloro,radio);
    }
    
    private static int recRemBalls(List<Integer> coloro, List<Integer> radio){
        boolean isRemoved = false;
        for(int i=0; i<coloro.size()-1; i++){
            if(coloro.get(i)==coloro.get(i+1) && radio.get(i)==radio.get(i+1)){
                coloro.remove(i);
                coloro.remove(i);
                radio.remove(i);
                radio.remove(i);
                isRemoved = true;
            }
        }
        if(isRemoved){
            return recRemBalls(coloro,radio);
        }
        return coloro.size();
    }
}
        
