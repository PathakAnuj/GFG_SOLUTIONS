//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter out=new PrintWriter(System.out);
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
	            int k=Integer.parseInt(br.readLine());
    	    	Node root = buildTree(s);
        	    Solution ob=new Solution();
                int ans=ob.goodSubtrees(root,k);
                out.println(ans);
                    t--;
            
            }
            out.close();
    }
}
// } Driver Code Ends



//User function Template for Java

class Solution
{
    static class pair{
        boolean[] arr;
        int count;
        pair(boolean[] arr , int c){
            this.arr = arr;
            this.count = c;
        }
    }
    
    public static int goodSubtrees(Node root,int k)
    {
        return solve(root , k).count;
    }
    
    public static pair solve(Node root , int k){
        if(root == null){
            return new pair(new boolean[26] , 0 );
        }
        
        pair l = solve(root.left , k);
        pair r = solve(root.right , k);
        int currCount = 0;
        l.arr[root.data] = true;
        for(int i=1; i<=25; i++){
            l.arr[i] = l.arr[i] || r.arr[i];
            if(l.arr[i])
              currCount++;
        }
        currCount = currCount <= k ? 1 : 0;
        return new pair(l.arr , currCount + l.count + r.count);
    }
    
    

}