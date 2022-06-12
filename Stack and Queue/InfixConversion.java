import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<String>str1=new Stack<>(); //prefix
    Stack<String>str2=new Stack<>(); //postfix
    
    Stack<Character>st=new Stack<>(); //operator
    
    for(int i=0;i<exp.length();i++){
        char ch=exp.charAt(i);
        if(ch>='a' && ch<='z'){
            str1.push(ch+"");
            str2.push(ch+"");
        }
        else if(ch=='('){
            st.push(ch);
        }
        else if(ch==')'){
            while(st.peek()!='('){
                //prefix
                String op2=str1.pop();
                String op1=str1.pop();
                char optr=st.pop();
                String ans=optr+op1+op2;
                str1.push(ans);
                
                //postfix
                String o2=str2.pop();
                String o1=str2.pop();
                String a=o1+o2+optr;
                str2.push(a);
            }
            st.pop(); //remove close bracket from stack
        }
        else if(ch=='+' ||ch=='-' || ch=='*' ||ch=='/'){
            while(st.size()>0 && precedence(st.peek())>=precedence(ch)){
                //prefix
                String op2=str1.pop();
                String op1=str1.pop();
                char optr=st.pop();
                String ans=optr+op1+op2;
                str1.push(ans);
                        
                //postfix
                String o2=str2.pop();
                String o1=str2.pop();
                String a=o1+o2+optr;
                str2.push(a);
            }
            st.push(ch); //add that operator in the stack
        }
        else{
            //ignore
        }
    }
    
    while(st.size()!=0){
        //prefix
        String op2=str1.pop();
        String op1=str1.pop();
        char optr=st.pop();
        String ans=optr+op1+op2;
        str1.push(ans);
                        
        //postfix
        String o2=str2.pop();
        String o1=str2.pop();
        String a=o1+o2+optr;
        str2.push(a);
    }
    System.out.println(str2.peek());  //postfix
    System.out.println(str1.peek()); //prefix
 }
 
 public static int precedence(char ch){
     if(ch=='+' || ch=='-'){
         return 1;
     }
     else if(ch=='*' || ch=='/'){
         return 2;
     }
     else{
         return 0;
     }
 } 
}
