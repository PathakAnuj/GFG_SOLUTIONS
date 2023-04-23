//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java



class Solution{
	int [] nearestSmallestTower(int [] arr){
		//Write your code here
		  int n = arr.length;
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>(); // store index
        int a[] = new int[n];
        int b[] = new int[n];
        int ans[] = new int[n];
        
        for(int i=0; i<n; i++)  //smaller on left
        {
            int ramcurr = arr[i];
            list.add(ramcurr);
            while(st.size()>0 && st.peek()>=ramcurr)
                st.pop();
            if(st.isEmpty())
                a[i] = -1;
          else
                a[i] = list.lastIndexOf(st.peek());
                
               
              st.push(ramcurr);
        }
        
        list.clear();
        st.clear();
        
            for(int i=n-1; i>=0; i--)  //smaller on right
        {
            int ramcurr = arr[i];
            list.add(ramcurr);
            while(st.size()>0 && st.peek()>=ramcurr)
                st.pop();
            if(st.isEmpty())
                b[i] = -1;
            else
                b[i] = n-list.lastIndexOf(st.peek())-1;
              st.push(ramcurr);
              
             
        }
        
    //     for(int x : a)
    //         System.out.print(x+" ");
    //     System.out.println();
    //         for(int x : b)
    //         System.out.print(x+" ");
    //     System.out.println();
      
        
        for(int i=0; i<n; i++)
        {
            if(a[i]==-1 && b[i]==-1){
                ans[i]=-1; continue;}
                
          else if(a[i]==-1){
                ans[i] = b[i]; continue;}
                
          else if(b[i] == -1){
                ans[i] = a[i]; continue;}
               
               int d1 = Math.abs(i-a[i]);
               int d2 = Math.abs(i-b[i]);
               if(d1 == d2)
               {
                   if(arr[a[i]] < arr[b[i]])
                        ans[i] = a[i];
                  else if(arr[a[i]] > arr[b[i]])
                        ans[i] = b[i];
                  else
                  {
                      ans[i] = a[i];
                  }
               }
               else if(d1<d2)
               {
                   ans[i] = a[i];
               }
               else
                    ans[i] = b[i];
            
        }
        return ans;
	}
}