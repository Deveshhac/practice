package dev.practice;

import java.io.*;
import java.util.*;

public class Longestpalindrome {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testcases=Integer.parseInt(br.readLine());
		for(int test=0;test<testcases;test++){
		 String str=br.readLine();
		 List<String> list=new ArrayList<String>();
		 for(int i=2;i<str.length();i++){
		     for(int j=0;j<str.length()-2;j++){
		         String s=str.substring(j,j+i);
		         StringBuffer sp=new StringBuffer(s);
		         StringBuffer s1=sp.reverse();
		         if(s.equals(s1)){
		             list.add(s);
		         }
		     }
		     
		 }
		 System.out.println(list);

	}

}
}
