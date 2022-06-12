import java.io.*;
import java.util.*;

public class Main {

  public static class MinStack {
    Stack<Integer> data;
    int min;

    public MinStack() {
      data = new Stack<>();
    }

    int size() {
      return data.size();
    }

    void push(int val) {
      //If stack is empty
      if(data.size()==0){
          data.push(val);
          min=val;
      }
      else {//If stack is not empty
          
          //If value is smaller than min.
          if(val<min){
              int fake_value=val+(val-min);
              data.push(fake_value);
              min=val;
          }
          else{
              //If value is greater than or equal to min
              data.push(val);
          }
      }
    }

    int pop() {
      if(data.size()==0){
          System.out.println("Stack underflow");
          return -1;
      }
      
      //If stack is not empty
      if(data.peek()<min){
          //case of fake value
          int org_value=min;
          int fake_value=data.pop();
          int prev_min=org_value+org_value-fake_value;
          min=prev_min;
          return org_value;
      }
      else{
          return data.pop();
      }
    }

    int top() {
      if(data.size()==0){
          System.out.println("Stack underflow");
          return -1;
      }
      
      //If stack is not empty
      if(data.peek()<min){
          //case of fake value
          int org_value=min;
          return org_value;
      }
      else{
          return data.peek();
      }
    }

    int min() {
      return min;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MinStack st = new MinStack();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      } else if (str.startsWith("min")) {
        int val = st.min();
        if (val != -1) {
          System.out.println(val);
        }
      }
      str = br.readLine();
    }
  }
}
