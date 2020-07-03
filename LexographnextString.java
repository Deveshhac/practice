package dev.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LexographnextString {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       //int n=Integer.parseInt(br.readLine());
       String st=br.readLine();
       int n=st.length();
       int posswapto=n-1,posswapfrom=-1;
       StringBuilder t=new StringBuilder();
       char[] ch=st.toCharArray();
       if(n==1){
    	  System.out.println(st);
       }else{
    	   for(int i=ch.length-2;i>=0;i--){
        	   if(ch[posswapto]>ch[i]){
        		   posswapfrom=i;
        		  break;
        	   }
           }
    	   if(posswapfrom==-1){
    		   System.out.println(-1);
    	   }else{
    		   char temp=ch[posswapto];
    		   ch[posswapto]=ch[posswapfrom];
    		   ch[posswapfrom]=temp;
    		  Arrays.sort(ch,posswapfrom+1,posswapto+1);
    		   for(int i=0;i<ch.length;i++){
    		   t.append(ch[i]);
    		   }
    		   }
    	   }
       System.out.println(t.toString());
       
       
	}

}
