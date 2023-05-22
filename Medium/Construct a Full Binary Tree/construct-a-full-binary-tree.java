//{ Driver Code Starts
//Initial Template for Java

import java.util.*;


class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}


class ConstructTree
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int pre[] = new int[n];
            int preM[] = new int[n];
            
            for(int i = 0; i < n; i++)
              pre[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preM[i] = sc.nextInt();
            
            Solution gfg = new Solution();  
           
            
            inorder(gfg.constructBTree(pre, preM, n));
            System.out.println();
            
        }
    }
    
    public static void inorder(Node root)
    {
        if(root == null)
         return;
         
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

// } Driver Code Ends




//User function Template for Java


class Solution
{
    int i = 0;
    public Node constructBTree(int pre[], int preM[], int n)
    {
         return util(pre, preM, n);
    }
    public Node util( int pre[], int preM[], int n)
    {
        if(i == n ) return null;
        int j = 0;
        for(;j<n;j++){
            if(preM[j] == pre[i]) break;
        }
         preM[j] = -1;
         Node root = new Node(pre[i++]);
        if(j == n-1 || preM[j+1] == -1)  return root;
        
         root.left = util( pre, preM, n);
         root.right = util( pre, preM, n);
         return root;
    }
    
}
// 7
// 0 1 3 4 2 5 6
// 0 2 6 5 1 4 3