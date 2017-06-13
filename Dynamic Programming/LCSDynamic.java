import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static String backtrack(int[][] table,int[] first, int[] second, int m, int n){
        int i=m,j=n;
        String s = "";
        while(i!=0 || j!=0){
          if(first[i-1] == second[j-1]){
               s =  first[i-1]+" "+s;
              i--;
              j--;
               
              
          }
            else if(table[i-1][j]>table[i][j-1]){
                i--;
            }
            else{
                j--;
            }
          
            if(i==0 || j==0)break;
            
        }
        
        return s;
    }
    static String dynamicLCS(int[] first, int[] second, int m, int n){
        
        int[][] table = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            table[i][0] = 0;
        }
        
        for(int i=0;i<n+1;i++){
            table[0][i] = 0;
        }
        
        
        
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(first[i-1] == second[j-1]){
                    table[i][j] = table[i-1][j-1]+1;
                    
                }
                else{
                    table[i][j] = Math.max(table[i-1][j],table[i][j-1]);
                }
            }
        }
        
         
        String s = backtrack(table,first,second, m,  n);
        return s;
        
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        
        int m = in.nextInt();
        int n = in.nextInt();
        int first[] = new int[m];
        int second[] = new int[n];
        for(int i=0;i<m;i++){
            first[i] = in.nextInt();
            
        }
        
        for(int i=0;i<n;i++){
            second[i] = in.nextInt();
            
        }
        
        
        String len = dynamicLCS(first,second,m,n);
       System.out.println(len);
        
        
    }
}
