package dev.practice;

import java.util.Scanner;


public class DetectLoop {
	static private class Linked{
		int data;
		Linked next;
		Linked(int data){
			this.data=data;
		}
	}
 static Linked head;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner br=new Scanner(System.in);
      int size=br.nextInt();
      head=null;
      for(int i=0;i<size;i++){
    	  int t=br.nextInt();
    	  Linked linked=new Linked(t);
    	  linked.next=head;
    	  head=linked;
      }
      Linked current=head,prev=head;
      if(head==null){
         System.out.print("No Loop Exists");
      }else    
       if(head.next==null){
    	   System.out.print("No Loop Exists");
       }else{
    	   while(current!=null && prev!=null && current.next!=null){
    	       current=current.next.next;
    	       prev=prev.next;
    	           if(current==prev){
    	               System.out.print(current.data);
    	               break;
    	           }
    	       }   
       }
       
	}

}
