import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Prims {
    static int n;
    static int MAX;
    static int findMin(int[] keySet, boolean[] mstSet){
        
        int min = MAX,min_index=0;
        for(int i=0;i<n;i++){
            if(keySet[i]<min && mstSet[i] == false){
                
                min = keySet[i];
                min_index = i;
                
            }
        }
        return min_index;
    }
    static int primsMST(int[][] graph, int src){
        boolean[] mstSet = new boolean[n];
        int[] parent = new int[n];
        int[] keySet = new int[n];
        
        for(int i=0;i<n;i++){
            mstSet[i] = false;
            keySet[i] = MAX;
            
        }
        keySet[src] = 0;
        parent[src] = 0;
        for(int count=0;count<n;count++){
            int u = findMin(keySet,mstSet);
            mstSet[u] = true;
            for(int v=0;v<n;v++){
                
                if(graph[u][v]>0 && mstSet[v] == false && graph[u][v]<keySet[v]){
                    keySet[v] = graph[u][v];
                    parent[v] = u;
                }
                
            }
            
        }
        int sum = 0;
        for(int i=1;i<n;i++){
          sum = sum+graph[i][parent[i]];
            
        }
        
        return sum;
        
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        MAX = 9999999;
        n = in.nextInt();
        int m = in.nextInt();
        int graph[][] = new int[n][n];
        for(int i=0;i<m;i++){
            int u = in.nextInt()-1;
            int v = in.nextInt()-1;
            int w = in.nextInt();
            
            graph[u][v] = w;
            graph[v][u] = w;            
            
        }
        int src = in.nextInt()-1;
        System.out.println(src);
       int res = primsMST(graph,src);
        System.out.println(res);
    }
}
