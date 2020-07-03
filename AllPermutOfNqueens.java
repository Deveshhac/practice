package dev.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllPermutOfNqueens {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testcases=Integer.parseInt(br.readLine());
		for(int testcase=0;testcase<testcases;testcase++){
		    int sizeOfChess=Integer.parseInt(br.readLine());
		    int arr[][]=new int[sizeOfChess][sizeOfChess];
		   // int dup[]=new int[sizeOfChess];
		    solve_for(arr,0,sizeOfChess);
		}
		}
		public static boolean solve_for(int arr[][],int k,int sizeOfChess){
		    if(k>sizeOfChess-1){
		        printboard(arr,sizeOfChess);
		       return true;
		    }
		    boolean res=false;
		   for(int col=0;col<sizeOfChess;col++){
				if(is_Valid(arr,k,col)){
					arr[k][col]=1;
					res=solve_for(arr,k+1,sizeOfChess);
					arr[k][col] = 0;
				}
				
			}
		   return res;
			
		}
		
		public static boolean is_Valid(int arr[][],int row,int col){
		    for(int i=row-1;i>=0;i--){
		        if(arr[i][col]==1){
		            return false;
		        }
		    }
		    for (int i = row-1, j = col+1; i >= 0 && j < arr.length; i--, j++) {
				   if(arr[i][j] == 1){
				    return false;
				   }
				  }
		    for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
				   if(arr[i][j] == 1){
				    return false;
				   }
				  }
				 
				 
		    return true;
		}
	  static void printboard(int arr[][],int sizeOfChess){
		  System.out.print("[");   
		  for(int i=0;i<sizeOfChess;i++){
		            for(int j=0;j<sizeOfChess;j++){
		                if(arr[i][j]==1){
		               System.out.print(j+1+" "); 
		                }  
		            }
		              
		        }
		  System.out.print("] ");
		}

}
