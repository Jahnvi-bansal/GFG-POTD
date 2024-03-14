//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            char A[][] = new char[N][N];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().trim().split(" ");
                for (int j = 0; j < N; j++) A[i][j] = S[j].charAt(0);
            }
            Solution ob = new Solution();
            System.out.println(ob.largestSubsquare(N, A));
        }
    }
}
// } Driver Code Ends


class Solution {
    int largestSubsquare(int n, char a[][]) {
        // code here
        int side=0;
        int[][] v = new int[n][n];
        int[][] h = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (a[i][j] == 'X'){
                    v[i][j] = ((i==0)?1: v[i-1][j]+1);
                    h[i][j] = ((j==0)? 1: h[i][j-1]+1);
                }
            }
        }
        for(int i=n-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                int val = Math.min(v[i][j], h[i][j]);
                while (val>side){
                    if(v[i][j-val+1] >= val && h[i-val+1][j] >= val){
                        side=val;
                    }
                    val--;
                }
            }
        }
        return side;
    }
};