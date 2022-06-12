import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Integer>st1=new Stack<>();
    Stack<String>st2=new Stack<>();
    Stack<String>st3=new Stack<>();
    
    for(int i=exp.length()-1;i>=0;i--){
        char ch=exp.charAt(i);
        
        if(ch>='0' && ch<='9'){
            st1.push(ch-'0');
            st2.push(ch+"");
            st3.push(ch+"");
        }
        else{
            //evaluate
            int op1=st1.pop();
            int op2=st1.pop();
            char optr=ch;
            int ans=calculate(op1,op2,optr);
            st1.push(ans);
            
            //infix
            String o1=st2.pop();
            String o2=st2.pop();
            String a1='('+o1+optr+o2+')';
            st2.push(a1);
            
            //postfix
            String o11=st3.pop();
            String o22=st3.pop();
            String a2=o11+o22+optr;
            st3.push(a2);
        }
    }
    System.out.println(st1.peek());
    System.out.println(st2.peek());
    System.out.println(st3.peek());
 }
 
 public static int calculate(int op1,int op2,char optr){
     if(optr=='+'){
         return op1+op2;
     }
     else if(optr=='-'){
         return op1-op2;
     }
     else if(optr=='*'){
         return op1*op2;
     }
     else{
         return op1/op2;
     }
 } 
}