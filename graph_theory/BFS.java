import java.util.*;
import java.io.*;
import java.math.*;

class Edge{

	int w;
	int weight;
	
	Edge(int w , int weight){
	
		this.w = w;
		this.weight = weight;
	}

}

class Graph{

	int V; // number of vertices
	LinkedList<Edge> adj[]; // array of adjacency lists
	
	Graph(int v){
	// Initialize graph
	V = v;
	adj = new LinkedList[v];
	
	for(int i=0;i<v;i++)
		adj[i] = new LinkedList<Edge>(); //create a neighbour list for each vertice
	
	}
	
	void addEdge(int v, int w, int weight){
	Edge e = new Edge(w,weight);
	adj[v].add(e);
	
	}
	
	
	void BFS(int s){
		int t  =s;
		int[] visited = new int[V];
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<visited.length;i++){
			visited[i]=-1;
		}
		
		visited[s]++;
		
		queue.add(s);
		
	
		
		while(!queue.isEmpty()){
			s = queue.poll();
			
			Iterator<Edge> i = adj[s].listIterator();	
		while(i.hasNext()){
		
			Edge n = i.next();
			
			if(visited[n.w]<0){
				//i.next().weight = n.weight+6;
				visited[n.w] = visited[s]+1;
				queue.add(n.w);
				//System.out.print(n.weight);
			
			}
		
		} 
	}
		for(int i=0;i<visited.length;i++){
		//System.out.println(visited[i]);
		
		}
	for(int i=0;i<visited.length;i++){
		if(visited[i]>= 0 && i!=t)
		System.out.println(6*(visited[i]));
		else if(visited[i]< 0)
		System.out.println(-1);
	}
	
	}
	
	
	public static void main(String args[]){
	
		  Scanner in = new Scanner(System.in);
        
        int q = in.nextInt();
        
        for(int t=0;t<q;t++){
            
            int n = in.nextInt();
            int m = in.nextInt();
            Graph g = new Graph(n);
            for(int i = 0;i< m;i++){
                int v = in.nextInt();
                int w = in.nextInt();
                g.addEdge(v-1,w-1,6);
                
            }
            int init = in.nextInt();
            g.BFS(init-1);
        }
	
	
	}


}
