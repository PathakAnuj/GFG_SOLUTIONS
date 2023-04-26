//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
	public static void main (String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
                
        int t=Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n=Integer.parseInt(in.readLine().trim());
            String s=in.readLine().trim();
            int q=Integer.parseInt(in.readLine().trim());
            query a[]=new query[q];
            for(int i=0;i<q;i++){
                String str=in.readLine().trim();
                String st[]=str.split(" ");
                if(st[0].trim().equals("1")){
                    a[i]=new query("1",st[1],st[2],"");
                }else{
                    a[i]=new query("2",st[1],st[2],st[3]);
                }
            }
            Solution ob=new Solution();
            ArrayList<Character> ans=ob.easyTask(n,s,q,a);
            for(char ch:ans){
                out.print(ch+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends



class Solution {
    static int seg[][];
    public static ArrayList<Character> easyTask(int n,String s,int q,query queries[])
    {
        seg=new int[4*n][26];
        char c[]=s.toCharArray();
        buildTree(c,0,0,n-1);
        ArrayList<Character> ans=new ArrayList<>();
        for(int i=0;i<q;i++){
            if(queries[i].type.equals("1")){
                int ind=Integer.parseInt(queries[i].a);
                char val=queries[i].b.charAt(0);
                ram(0,0,n-1,ind,val);
            }else{
                int l=Integer.parseInt(queries[i].a);
                int r=Integer.parseInt(queries[i].b);
                int k=Integer.parseInt(queries[i].c);
                int arr[]=query(0,0,n-1,l,r);
                for(int j=25;j>=0;j--){
                    for(int kk=0;kk<arr[j];kk++){
                        k--;
                        if(k==0){
                            ans.add((char)(j+'a'));
                        }
                    }
                }
            }
        }
        return ans;
    }
    public static void buildTree(char a[],int si,int ss,int se)
	{
		if(ss==se){
			seg[si][a[ss]-'a']++;
			return;
		}
		int mid=(ss+se)/2;
		buildTree(a,2*si+1,ss,mid);
		buildTree(a,2*si+2,mid+1,se);
        int a1[]=seg[2*si+1];
        int a2[]=seg[2*si+2];
        for(int i=0;i<26;i++){
            seg[si][i]=a1[i]+a2[i];
        }
	}
    public static void ram(int si,int ss,int se,int pos,char val)
	{
		if(ss==se){
            int in=0;
            for(int i=0;i<26;i++){
                if(seg[si][i]>=1){
                    in=i;
                    break;
                }
            }
            seg[si][in]--;
			seg[si][val-'a']++;
			return;
		}
		int mid=(ss+se)/2;
		if(pos<=mid){
			ram(2*si+1,ss,mid,pos,val);
		}else{
			ram(2*si+2,mid+1,se,pos,val);
		}
		int a1[]=seg[2*si+1];
        int a2[]=seg[2*si+2];
        for(int i=0;i<26;i++){
            seg[si][i]=a1[i]+a2[i];
        }
	}
    public static int[] query(int si,int ss,int se,int qs,int qe)
	{
		if(qs>se || qe<ss)return new int[26];
		if(ss>=qs && se<=qe)return seg[si];
		int mid=(ss+se)/2;
		int a1[]=query(2*si+1,ss,mid,qs,qe);
		int a2[]=query(2*si+2,mid+1,se,qs,qe);
		// return max(p1,p2);
        int ans[]=new int[26];
        for(int i=0;i<26;i++){
            ans[i]=a1[i]+a2[i];
        }
        return ans;
	}
}
/*In case the query is of type 1.
type=1
c=null
*/

/*In case the query is of type 2.
type=2
c=k
*/

class query
{
    String type;
    String a;
    String b;
    String c;
    public query(String type,String a,String b,String c)
    {
        this.type=type;
        this.a=a;
        this.b=b;
        this.c=c;
    }
}