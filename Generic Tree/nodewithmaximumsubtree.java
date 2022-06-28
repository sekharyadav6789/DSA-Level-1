import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
//   //Approach-1
//     static Node maxsumnode;
//     static int maxsum=Integer.MIN_VALUE;
//     public static int sum(Node node){
//         int ans=node.data;
        
//         for(Node child:node.children){
//             ans+=sum(child);
//         }
        
//         if(maxsum<ans){
//             maxsum=ans;
//             maxsumnode=node;
//         }
//         return ans;
//     }
//Approach-2
    public static Pair fun(Node node){
        Pair mp=new Pair();
        mp.sum+=node.data;
        
        for(Node child:node.children){
            Pair cp=fun(child);
            mp.sum+=cp.sum;
            if(cp.maxsum>mp.maxsum){
                mp.maxsum=cp.maxsum;
                mp.maxSumNode=cp.maxSumNode;
            }
        }
        
        if(mp.sum>mp.maxsum){
            mp.maxsum=mp.sum;
            mp.maxSumNode=node;
        }
        return mp;
    }
    public static class Pair{
        int sum;
        int maxsum;
        Node maxSumNode;
    }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    // write your code here
    // sum(root);
    // System.out.println(maxsumnode.data+"@"+maxsum);
    Pair p=fun(root);
    System.out.println(p.maxSumNode.data+"@"+p.maxsum);
  }

}