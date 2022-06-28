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

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static int max(Node node) {
    int m = Integer.MIN_VALUE;

    for (Node child : node.children) {
      int cm = max(child);
      m = Math.max(m, cm);
    }
    m = Math.max(m, node.data);

    return m;
  }

  public static int height(Node node) {
    int h = -1;

    for (Node child : node.children) {
      int ch = height(child);
      h = Math.max(h, ch);
    }
    h += 1;

    return h;
  }

  public static void traversals(Node node){
    System.out.println("Node Pre " + node.data);

    for(Node child: node.children){
      System.out.println("Edge Pre " + node.data + "--" + child.data);
      traversals(child);
      System.out.println("Edge Post " + node.data + "--" + child.data);
    }

    System.out.println("Node Post " + node.data);
  }

  public static void levelOrderLinewiseZZ(Node root){
    //1.Make Two Stacks
    Stack<Node>mainS=new Stack<>();
    Stack<Node>childS=new Stack<>();
    
    //2.Add root in the mainS
    mainS.push(root);
    int level=1; //pointer to trace the level
    
    //3. RPA -Remove Print Add
    while(mainS.size()>0 || childS.size()>0){
        //Remove
        Node node=mainS.pop();
        
        //Print
        System.out.print(node.data+" ");
        
        //Add
        //for odd levels push from left to right
        if(level%2==1){
            for(int i=0;i<node.children.size();i++){
                childS.push(node.children.get(i));
            }
        }
        //for even levels push from right to left
        else{
            for(int i=node.children.size()-1;i>=0;i--){
                childS.push(node.children.get(i));
            }
        }
        
        //when mainS is empty
        if(mainS.size()==0){
            mainS=childS; //make childS as mainS
            childS=new Stack<>(); //make childS as new Stack
            System.out.println(); //move to next line
            level++; //increase the level
        }
    }
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
    levelOrderLinewiseZZ(root);
  }

}