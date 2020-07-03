package dev.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class LongestPathTwonodes {
static class Pair{
	int to;
	int distance;
	public Pair(int to,int distance){
		this.to=to;
		this.distance=distance;
	}
}
 static int maxlength;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner br=new Scanner(System.in);
      int nodes=br.nextInt();
      int edges=br.nextInt();
      ArrayList<ArrayList<Pair>> lst=new ArrayList<ArrayList<Pair>>();
      for(int i=0;i<=nodes;i++){
    	  lst.add(i, new ArrayList<Pair>());
      }
      
      for(int i=0;i<edges;i++){
    	  int from=br.nextInt();
    	  int to=br.nextInt();
    	  int length=br.nextInt();
    	  
    	  lst.get(from).add(new Pair(to,length));
    	  lst.get(to).add(new Pair(from,length));
      }
      //System.out.println(lst.toString());
       maxlength=0;
      for(int i=1;i<=nodes;i++){
    	 int visited[]=new int[nodes+1];
    	 longestpath(lst,visited,i,0);
      }
      System.out.print(maxlength);
	}
	private static void longestpath(ArrayList<ArrayList<Pair>> lst, int[] visited, int src, int prevlength) {
		// TODO Auto-generated method stub
		visited[src]=1;
		int curlength=0;
		ArrayList<Pair> list=lst.get(src);
		for(int i=0;i<list.size();i++){
			if(visited[list.get(i).to]==0){
				curlength=prevlength+list.get(i).distance;
				longestpath(lst, visited, list.get(i).to, curlength);
			}
			if(maxlength<curlength){
				maxlength=curlength;
			}
			curlength=0;
		}
	}

}
