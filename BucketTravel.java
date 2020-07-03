package dev.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BucketTravel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner br=new Scanner(new BufferedReader
                (new InputStreamReader(System.in)));
        int testcases=br.nextInt();
        for(int testcase=1;testcase<=testcases;testcase++){
        int routes=br.nextInt();
        int days=br.nextInt();
        int arr[]=new int[routes];
        for(int i=0;i<routes;i++){
        arr[i]=br.nextInt();
        }
        int n[]=new int[routes];
        System.out.print(arr[routes-1]);
        n[routes-1]=days-(days%arr[routes-1]);
        System.out.print(n[routes-1]);
        for(int i=routes-2;i>=0;i--){
        int p=days%arr[i];
        n[i]=days-p;
        while(n[i]>n[i+1]){
            n[i]=n[i]-arr[i];
        }
        System.out.println(n[i]);
        }
          for(int i=0;i<routes;i++){
                int positive=n[i]-n[0];
                while((n[i]-n[0])<0){
                n[0]=n[0]-arr[0];
                }
            }
        System.out.println("Case #"+testcase+": "+n[0]);    
        }
	}

}
