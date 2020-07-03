package dev.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

/*class Tree{
int data;
Tree left;
Tree right;
int hd;
 Tree(int data){
	this.data=data;
	this.left=null;
	this.right=null;
	this.hd=0;
}
}*/

public class BottomView {
	static Tree root;
	public static Tree insert(Tree root, int data) {
        if(root == null) {
            return (new Tree(data));
        } else {
            Tree cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner br=new Scanner(System.in);
    int size=br.nextInt();
    while(size >0){
    	int data = br.nextInt();
        root = insert(root, data);
        --size;
    }
    br.close();
    Map<Integer,Integer> lst=new HashMap<Integer,Integer>();
    Queue<Tree> qu=new LinkedList<Tree>();
    root.hd=0;
    qu.add(root);
    lst=bottomViewList(root,qu);
    for(Entry<Integer, Integer> mp:lst.entrySet()){
    	System.out.print(mp.getValue()+" ");
    }
	}
	private static Map<Integer, Integer> bottomViewList(Tree root2, Queue<Tree> qu) {
		// TODO Auto-generated method stub
		 Map<Integer,Integer> lst=new TreeMap<Integer,Integer>();
		while(!qu.isEmpty()){
			Tree qt=qu.remove();
			int data=qt.data;
			int vt=qt.hd;
			
			lst.put(vt,data);
			if(qt.left!=null){
				int pt=vt-1;
				qt.left.hd=pt;
				qu.add(qt.left);
			}
			if(qt.right!=null){
				int pt=vt+1;
				qt.right.hd=pt;
				qu.add(qt.right);
			}
		}
		
		return lst;
	}

}
