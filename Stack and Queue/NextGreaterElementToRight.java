import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){
   Stack<Integer>st=new Stack<>();
   int []ans=new int[arr.length];
   
   /*st.push(arr[arr.length-1]);
   ans[arr.length-1]=-1;*/
   
   for(int i=arr.length-1;i>=0;i--){ //right to left
       
       //pop all the ssmaller elements.
       while((st.size()>0) && (st.peek()<arr[i])){
           st.pop(); //remove all smaller elements.
       }
       
       //update ans
       if(st.size()==0){
           ans[i]=-1;
       }
       else{
           ans[i]=st.peek();
       }
       
       //push current element in stack
       st.push(arr[i]);
   }
   return ans;

 }
}