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
 
    // int len=1;
    // int area=0;
    // // considering each element over the array
    // for(int i=0;i<n;i++){
    //     //in forward direction
    //     for(int j=i+1;a[j]>=a[i] && j<n;j++){
    //         len+=j-i;
    //     }
    //     //in backward direction
    //     for(int j=i-1;a[j]>=a[i] && j>=0;j--){
    //         len+=i-j;
    //     }
    //     //finding the maximum area
    //     area=Math.max(area,(len*a[i]));
    // }
    // System.out.println(area);
    
    int []rb=new int[arr.length]; //nsm index from right
    Stack<Integer>st=new Stack<>();
    st.push(arr.length-1);
    rb[arr.length-1]=arr.length;
    
    //traverse over the array
    for(int i=arr.length-2;i>=0;i--){
        while(st.size()>0 && arr[i]<=arr[st.peek()]){
            st.pop();
        }
        if(st.isEmpty()){
            rb[i]=arr.length;
        }
        else{
            rb[i]=st.peek();
        }
        st.push(i);
    }
    
    int []lb=new int[arr.length]; //nsm index from left
    Stack<Integer>st1=new Stack<>();
    st.push(0);
    lb[0]=-1;
    
    //traverse over the array
    for(int i=1;i<arr.length;i++){
        while(st.size()>0 && arr[i]<=arr[st.peek()]){
            st.pop();
        }
        if(st.isEmpty()){
            lb[i]=-1;
        }
        else{
            lb[i]=st.peek();
        }
        st.push(i);
    }
    int area=0; 
    for(int i=0;i<arr.length;i++){
        int width=rb[i]-lb[i]-1;
        int length=arr[i];
        area=Math.max(area,(width*length));
    }
    
    System.out.println(area);   
 }
}