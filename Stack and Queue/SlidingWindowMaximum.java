import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    int []nge=new int[arr.length];
    nge[arr.length-1]=arr.length;
    Stack<Integer>st=new Stack<>();
    st.push(arr.length-1);
    //Traverse over the array
    for(int i=arr.length-2;i>=0;i--){
        while(st.size()>0 && arr[st.peek()]<=arr[i]){
            st.pop();
        }
        if(st.size()==0){
            nge[i]=arr.length;
        }
        else{
            nge[i]=st.peek();
        }
        st.push(i);
    }
    
    //Traverse over the array
    for(int i=0;i<=arr.length-k;i++){
        int j=i;
        while(nge[j]<i+k){
            j=nge[j];
        }
        System.out.println(arr[j]);
    }
 }
}
