package dev.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*class Node{
	  int key;
	 //List<Node> neighbours;
	  public Node(int key){
	   this.key=key;
	  }
	}*/



/*class Graph
{
	//boolean directed;
	Map<Node,LinkedList<Node>> neighbours;
	
	 public Graph(boolean key){
	   //this.directed=key;
		neighbours = new HashMap();
	}
	
}*/

public class BFSGRAPH {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   Scanner br=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
   
   int vertices = br.nextInt();
   int edges=br.nextInt();
   List<ArrayList<Integer>> map=new ArrayList();
  for(int i=0;i<vertices;i++){
	  //Node nd=new Node(i);
	  map.put(nd,new ArrayList<Node>());
  }
   
   for(int i=0;i<edges;i++){
	   int source=br.nextInt();
	   int destination=br.nextInt();
	   if(map.containsKey(source)){
		  // Node des=new Node(destination);
		   map.get(source).add(des);
	   }
   }
   
   
   
   
   }
   
   
	
}





