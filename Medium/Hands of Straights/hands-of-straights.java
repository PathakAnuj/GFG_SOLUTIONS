//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            boolean ans = obj.isStraightHand(n, k, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends



// User function Template for Java

class Solution {
    static boolean isStraightHand(int N, int groupSize, int hand[]) {
        Map<Integer,Integer> map= new HashMap<>();
        Arrays.sort(hand);
        for(int ele:hand) map.put(ele,map.getOrDefault(ele,0)+1);
        for(int i=0;i<hand.length;i++)
        {
           
             if(map.get(hand[i])==0)continue;
            if(!isPossible(hand[i],map,groupSize))return false;
            
        }
        return true;
        
    }
    static boolean isPossible (int st, Map<Integer,Integer>map,int size)
    {
        for(int i=0;i<size;i++)
        {
            if(!map.containsKey(i+st)|| map.get(i+st)==0) return false;
            map.put(i+st,map.get(i+st)-1);
            
        }
        return true;
    }
}