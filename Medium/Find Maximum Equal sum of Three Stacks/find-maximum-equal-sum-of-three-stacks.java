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
            
            int[] a = IntArray.input(br, 3);
            
            
            int[] S1 = IntArray.input(br, a[0]);
            
            
            int[] S2 = IntArray.input(br, a[1]);
            
            
            int[] S3 = IntArray.input(br, a[2]);
            
            Solution obj = new Solution();
            int res = obj.maxEqualSum(a[0],a[1],a[2], S1, S2, S3);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int maxEqualSum(int n1,int n2,int n3, int[] s1, int[] s2, int[] s3) {
        int sum1=0, sum2=0, sum3=0;
        for(int i=0;i<n1;i++) sum1+=s1[i];
        for(int i=0;i<n2;i++) sum2+=s2[i];
        for(int i=0;i<n3;i++) sum3+=s3[i];
        int i1=0, i2=0, i3=0;
        while(!(sum1==sum2 && sum2==sum3)) {
            if(sum1>=sum2 && sum1>=sum3) {
                if(i1>=n1) break;
                else sum1-=s1[i1++];
            }
            else if(sum2>=sum1 && sum2>=sum3) {
                if(i2>=n2) break;
                else sum2-=s2[i2++];
            }
            else if(sum3>=sum2 && sum3>=sum1) {
                if(i3>=n3) break;
                else sum3-=s3[i3++];
            }
            //System.out.println(sum1+" "+sum2+" "+sum3);
        }
        if(sum1==sum2 && sum2==sum3) return sum1;
        return 0;
    }
}
            
