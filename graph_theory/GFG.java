/* The function prints V space separated integers where 
    the ith integer denote the shortest distance of ith vertex
    from source vertex */
    import java.util.*;
    import java.io.*;
public class GFG{
static int findMin(int[] distance,boolean[] sptSet){
    int min = Integer.MAX_VALUE;
    int min_index = 0;
    for(int i=0;i<distance.length;i++){
        if(sptSet[i] == false && distance[i]<=min ){
            min = distance[i];
            min_index = i;
        }
        
    }
    return min_index;
}

static void dijkstra(int graph[][], int s,int V)
{
   //Your code here
   int[] distance = new int[V];
   boolean[] sptSet = new boolean[V];
   //set all distances to infinite
   for(int i=0;i<V;i++){
        distance[i] = Integer.MAX_VALUE;
        sptSet[i] = false;    
   }
   distance[s] = 0;
   
   for(int count=0;count<V;count++){ //traverse for all vertices
       int u = findMin(distance,sptSet);
       sptSet[u] = true;
       
       for(int i=0;i<V;i++){
           
           if((!sptSet[i]) && (graph[u][i]!=0) &&  distance[u]+graph[u][i]<distance[i])
            distance[i] = distance[u]+graph[u][i];
           
           
           
       }
       
   }
   for(int i=0;i<V;i++){
       System.out.println(distance[i]+" ");
   }
}
public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while(t-->0){
        
        int V = in.nextInt();
        int[][] graph = new int[V][V];
        for(int i = 0;i<V;i++){
            for(int j=0;j<V;j++)
            graph[i][j] = in.nextInt();
        }
        int src = in.nextInt();
        dijkstra(graph,src,V);
        
    }
}

}
