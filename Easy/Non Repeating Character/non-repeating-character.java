//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String s)
    {
        //Your code here
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(!mp.containsKey(s.charAt(i))){
                mp.put(s.charAt(i), 1);
            }else{
                mp.put(s.charAt(i), mp.get(s.charAt(i))+1);
            }
        }
        char ans = '$';
        for(int i=0; i<s.length(); i++){
            if(mp.get(s.charAt(i))==1){
                ans=s.charAt(i);
                break;
            }
        }
        return ans;
    }
}

