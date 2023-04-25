//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [] seats = new int[m];
            for(int i = 0; i < m; i++){
                seats[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            boolean res = obj.is_possible_to_get_seats(n, m, seats);
            
            String _result_val = (res) ? "Yes" : "No";
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


public class Solution {
    public static boolean is_possible_to_get_seats(int n, int m, int[] seats) {
        for(int i = 0; i < m; i++) {
            if(seats[i] == 1) {
                if(i - 1 >= 0) {
                    seats[i - 1] = 2;
                }
                if(i + 1 < m && seats[i + 1] == 0) {
                    seats[i + 1] = 2;
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < m; i++) {
            if(seats[i] == 0) {
                cnt++;
                if(i - 1 >= 0) {
                    seats[i - 1] = 2;
                }
                if(i + 1 < m) {
                    seats[i + 1] = 2;
                }
            }
        }
        return cnt >= n;
    }
}

        
