//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
    
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
	    Complete obj = new Complete();
		obj.precompute();    	
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [][] = new int[M][2];
		    for(int i = 0;i<M;i++){
	            line = br.readLine();
		        String[] elements = line.trim().split("\\s+");
		        arr[i][0] = Integer.parseInt(elements[0]);
		        arr[i][1] = Integer.parseInt(elements[1]);    
	        }
            int ans = obj.helpSanta(N, M, arr);
            System.out.println(ans);
    	    
		}
	}
}




// } Driver Code Ends




//User function Template for Java

 

class Complete{
   
   static int k = 0;
   static int max = 1000005;
   static ArrayList<Integer> primes = new ArrayList<>();
   
   public static void sieveOfEratosthenes() {
       boolean[] sieve = new boolean[max];
       for(int p =0;p<max;p++) {
           sieve[p] = true;
       }
       for(int p = 2;p*p<max;p++) {
           if(sieve[p] == true) {
               for(int i = p*p; i<max; i+=p) {
                   sieve[i] = false;
               }
           }
       }
       for(int i =2;i<max;i++) {
           if(sieve[i] == true) {
               primes.add(i);
           }
       }
   }
   

   public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis,
   Stack<Integer> st) {
       vis[node] = true;
       k++;
       for(int x : adj.get(node)) {
           if(!vis[x]) {
               dfs(x, adj, vis, st);
           }
       }
       st.add(node);
   }
   
   public static void precompute () {
       sieveOfEratosthenes();
   }
   public static int helpSanta (int n, int m, int g[][]) {
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
       boolean[] vis = new boolean[n+1];
       Stack<Integer> st = new Stack<>();
       
       for(int i =0;i<=n;i++) {
           adj.add(new ArrayList<Integer>());
           adjT.add(new ArrayList<Integer>());
       }
       

       for(int i =0; i<m; i++) {
           adj.get(g[i][0]).add(g[i][1]);
           adj.get(g[i][1]).add(g[i][0]);
       }

       for(int i =1;i<=n;i++) {
           if(!vis[i]) {
               dfs(i, adj, vis, st);
           }
       }

       vis = new boolean[n+1];
       int count = 0;
       k=0;
       while(!st.isEmpty()) {
           int t = st.pop();
           if(!vis[t]) {
               dfs(t, adj, vis, new Stack<Integer>());
               count = Math.max(k, count);
               k=0;
           }
       }
       if(count == 1) return -1;
       return primes.get(count-1);
   }
}

 

 