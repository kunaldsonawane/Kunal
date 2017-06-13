import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int lis(int[] arr, int n){
        int[] l = new int[n];
        
        for(int i=0;i<n;i++){
            l[i] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && l[i]<l[j]+1){
                    l[i] = l[j]+1;
                    
                }
            }
        }
        int max = 0;
       for(int i=0;i<n;i++){
            if(l[i]>max){
                max =l[i];
            }
       }
        return max;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
            
        }
        
        int len = lis(arr,n);
        System.out.println(len);
    }
}
