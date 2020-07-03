package dev.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

import com.sun.corba.se.impl.orbutil.graph.Graph;

public class DijkastraAlgo {

	public class QueueNode{
	   int nodeId;
	   int distfromsrc;
	   public QueueNode(int nodeId,int dist){
		   this.nodeId=nodeId;
		   distfromsrc=dist;
	   }
	}
	class queueComparator implements Comparator<QueueNode>{
		public int compare(QueueNode x,QueueNode y){
			if(x.distfromsrc<y.distfromsrc){
				return -1; 
			}else if(x.distfromsrc>y.distfromsrc)
			{	
	          return 1;
			}
			return 0;
			}
	}
	static private class GraphNode{
		int nodeId;
		GraphNode next;
		int parentdist;
		public GraphNode(int id){
			nodeId=id;
			next=null;
		}
		public GraphNode(int id,int dist){
			nodeId=id;
			next=null;
			parentdist=dist;
		}
	}
	
	ArrayList<GraphNode> nodeList;
	public DijkastraAlgo(){
		nodeList=new ArrayList<GraphNode>();
	}
	
	public void addVertex(int id){
		GraphNode gp=new GraphNode(id);
		nodeList.add(gp);
	}
	
	public void addEdge(int id1,int id2,int dist){
		int i=0;
		for(;i<nodeList.size();i++){
			if(nodeList.get(i).nodeId==id1){
				break;
			}
		}
		if(i==nodeList.size()){
			return ;
		}
		GraphNode nd=nodeList.get(i);
		GraphNode nd1=new GraphNode(id2,dist);
		nd1.next=nd.next;
		nd.next=nd1;
	}
	public int[] findTheShortest(int srcId){
		PriorityQueue<QueueNode> qu=new PriorityQueue<QueueNode>(new queueComparator());
		
		boolean unvisited[]=new boolean[nodeList.size()];
		int parent[]=new int[nodeList.size()];
		int distance[]=new int[nodeList.size()];
		for(int i=0;i<nodeList.size();i++){
			unvisited[i]=true;
			distance[i]=Integer.MAX_VALUE;
			parent[i]=-1;
		}
		qu.add(new QueueNode(srcId, 0));
		while(!qu.isEmpty()){
			QueueNode currentnode=qu.remove();
			unvisited[currentnode.nodeId]=false;
			distance[currentnode.nodeId]=currentnode.distfromsrc;
			GraphNode currentgrpnode=findNode(currentnode.nodeId);
		    GraphNode neighnode=(currentgrpnode==null)? null:currentgrpnode.next;

		    while(neighnode!=null){
		    	if(unvisited[neighnode.nodeId]){
		    		if(distance[currentnode.nodeId]+neighnode.parentdist<distance[neighnode.nodeId]){
		    			int olddistance=distance[neighnode.nodeId];
			    		int newdistance=distance[currentnode.nodeId]+neighnode.parentdist;
			    		distance[neighnode.nodeId]=newdistance;
			    		parent[neighnode.nodeId]=currentnode.nodeId;
			    		updatequeue(qu,neighnode.nodeId,olddistance,newdistance);
		    		}
		    	}
		    	neighnode=neighnode.next;
		    }
		}
		return distance;
	}
	private void updatequeue(PriorityQueue<QueueNode> qu, int nodeId, int olddistance, int newdistance) {
		// TODO Auto-generated method stub
		Iterator<QueueNode> it=qu.iterator();
		boolean queueUpdated=false;
		while(it.hasNext()){
			QueueNode temp=it.next();
			if(temp.nodeId==nodeId){
				queueUpdated=true;
				temp.distfromsrc=newdistance;
				break;
			}
		}
		if(!queueUpdated){
			qu.add(new QueueNode(nodeId, newdistance));
		}
	}

	private GraphNode findNode(int currentnode) {
		// TODO Auto-generated method stub
		int i=0;
		for(;i<nodeList.size();i++){
			if(nodeList.get(i).nodeId==currentnode){
				break;
			}
		}
		return nodeList.get(i);
	}

	 public void printGraph()
	    {
	        for (int i = 0; i < nodeList.size(); i++)
	        {
	            GraphNode curr = nodeList.get(i);
	              
	            while (curr != null)
	            {
	                System.out.print(curr.nodeId+"("+curr.parentdist+")"+"->");
	                curr = curr.next;
	            }
	            System.out.print("Null");
	            System.out.println();
	        }
	   }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DijkastraAlgo graphObj = new DijkastraAlgo();
		 
        graphObj.addVertex(0);
        graphObj.addVertex(1);
        graphObj.addVertex(2);
        graphObj.addVertex(3);
        graphObj.addVertex(4);
        graphObj.addVertex(5);
        graphObj.addVertex(6);
          
        graphObj.addEdge(0,2,1);
        graphObj.addEdge(0,1,2);
         
        graphObj.addEdge(1,2,3);
         
        graphObj.addEdge(2,3,5);
        graphObj.addEdge(2,6,13);
         
        graphObj.addEdge(3,5,6);
        graphObj.addEdge(3,1,6);
        graphObj.addEdge(3,6,6);
         
        graphObj.addEdge(5,3,7);
         
        // find the shortest distance of all nodes from node '0'
        int[] distance = graphObj.findTheShortest(0);
          
        for (int i = 0; i < distance.length; i++)
        {
            if (distance[i] == Integer.MAX_VALUE)
            {
                System.out.println("vertex \'"+ i + "\' is unreachable from vertex '0'");
            }
            else
            {
                System.out.println("distance of vertex \'"+ i + "\' from vertex '0' is "+distance[i]);
            }
        } 
	}

}
