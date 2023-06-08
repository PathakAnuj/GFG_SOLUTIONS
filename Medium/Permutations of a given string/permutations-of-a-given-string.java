//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends




class Solution {
    public void recursivePermutaion(String up, String p, Set<String> res){
        if(p.isEmpty()){
            res.add(up);
            return;
        }
        for(int i =0; i<p.length();i++){
            char ch = p.charAt(i);
            recursivePermutaion(up+ch, p.substring(0,i)+ p.substring(i+1),res);
        }
    }
    public List<String> find_permutation(String S) {
        // Code here
        Set<String> res = new TreeSet<>();
        recursivePermutaion("",S,res);
        return new ArrayList<String>(res);
    }
}