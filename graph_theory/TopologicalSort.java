import java.util.*;
import java.io.*;

class TopologicalSort{


	static int V;
	static int graph[][];
	static void topSort(int v, boolean visited[], Stack stack){
			visited[v] = true;
			for(int i=0;i<V;i++){
				if(graph[v][i]!=0 && visited[i]==false){
					topSort(i,visited,stack);
				}
			}
			stack.push(v);
	}
	static void topologicalSort(){
		Stack stack = new Stack();
		boolean[] visited = new boolean[V];
		for(int i=0;i<V;i++){
			visited[i] = false;
		}
		for(int v=0;v<V;v++){
			if(visited[v]==false){
			
				topSort(v,visited,stack);
			}
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+" ");
		}
		
		
	
	}
	public static void main(String args[]){
		V=6;
		
		graph = new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,1,0,0},{0,1,0,0,0,0},{1,1,0,0,0,0},{1,0,1,0,0,0}};
		
		topologicalSort();
		
	
	}




}
