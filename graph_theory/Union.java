import java.io.*;
import java.util.*;
import java.math.*;


public class Union{
	
	static int findParent(int parent[], int i){
	
		if(parent[i]==-1){
			return i;
		}
		return findParent(parent,parent[i]);
	}

	static void union(int[] parent, int x, int y)
	
	{
		int xset = findParent(parent,x);
		int yset = findParent(parent,y);
		parent[xset] = yset;	
	}
	
	static boolean isCyclic(int[][] graph){
	
		int parent[] = new int[3];
		for(int i=0;i<3;i++){
		parent[i] = -1;
		}
		
		for(int u=0;u<3;u++){
			for(int v=0;v<3;v++){
				if(graph[u][v] == 1){
				
					int x = findParent(parent, u);
					int y = findParent(parent, v);
					
					if(x==y){
						return true;
					}
					
					union(parent, x ,y);
				
				
				}
			}
		}
		return false;
	
	}


	public static void main(String args[]){
		int V = 3;
		int[][] graph = {{0,1,1},{1,0,1},{1,0,0}};
		
		if(isCyclic(graph)){
		System.out.println("cycle");
		}
		else{
		System.out.println("no cycle");
		}
		
		
	
	}
}
