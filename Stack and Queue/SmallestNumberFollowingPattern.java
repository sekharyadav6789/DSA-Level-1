import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    Stack<Integer>st=new Stack<>();
    
    int num=1;
    //Traverse over the string
    for(int i=0;i<str.length();i++){
        char ch=str.charAt(i);
        //if ch is i
        if(ch=='i'){
            st.push(num);
            num++;
            while(st.size()>0){
                System.out.print(st.pop());
            }
        }
        else{
        //if ch is d
        st.push(num);
        num++;
        }
    }
    st.push(num); //for last number push in the stack
    while(st.size()>0){
        System.out.print(st.pop());
    }
 }
}