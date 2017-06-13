import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
   
    static int findSum(int v[]){
        int sum = 0;
        for(int i=0;i<v.length;i++){
            sum = sum+v[i];
        }
        return sum;
    }
    
    static int findMax(int[] arr){
       int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max)
                max = arr[i];
        }
        return max;
    }
    
    static int solvePermuted(int arr[]){
        //int max = findMax(arr);
        //System.out.println(max);
        int index = 0;
        int v[] = new int[arr.length];
        v[0] = 1;
        for(int i=1;i<arr.length;i++){
            //if(arr[i]>=max){
              //  max = arr[i];
             //   index = i;
           // }
            int j=i;
            while(arr[j]<=arr[i]){
                if(j<i && arr[j]==arr[i])break;
                j--;
                if(j==-1)break;
            }
            
            v[i] = Math.abs(i-j);
            
            
        }
        int sum = findSum(v);
      //System.out.println(Arrays.toString(v) + " "+sum);
        return sum;
        
    }
    
    static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
         
        
    }
    static int factorial(int n){    
          if (n == 0)    
            return 1;    
          else    
            return(n * factorial(n-1));    
    }  
    static float findAvg(ArrayList<Integer> a){
        int sum = 0;
        for(int i=0;i<a.size();i++){
            sum = sum+a.get(i);
        }
        return (float)sum/(float)a.size();
        
    }
    static void permuteArray(int[] arr, int i, int n,int sum,ArrayList<Integer> a,int f){
        int j=0;
        if(i==n){
             //stem.out.println(Arrays.toString(arr));
           int s = solvePermuted(arr);
           sum = sum+s;
            a.add(s);
          if(a.size()==f){
              float avg = findAvg(a);
              System.out.println(String.format("%.2f",avg));
          }
            
        }
        else{
            for(j=i;j<=n;j++){
                swap(arr,i,j);
                permuteArray(arr, i+1,n,sum,a,f);
                swap(arr,i,j);
                
                
            }
            
            
        }
        
    }
    

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        for(int p=0;p<t;p++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = in.nextInt();
                
            }
            int f = factorial(arr.length);
            ArrayList<Integer> a = new ArrayList<Integer>();
            int sum = 0;
            permuteArray(arr, 0 , arr.length-1, sum,a,f);
            
            
        }
    }
}
