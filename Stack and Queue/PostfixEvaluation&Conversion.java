import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Integer>str1=new Stack<>(); //evaluate
    Stack<String>str2=new Stack<>(); //infix
    Stack<String>str3=new Stack<>(); //prefix
    for(int i=0;i<exp.length();i++){
        char ch=exp.charAt(i);
        
        if(ch>='0' && ch<='9'){
            str1.push(ch-'0');
            str2.push(ch+"");
            str3.push(ch+"");
        }
        else{
            //evaluate
            int op2=str1.pop();
            int op1=str1.pop();
            char optr=ch;
            int ans=calculate(op1,op2,optr);
            str1.push(ans);
            
            //infix
            String o2=str2.pop();
            String o1=str2.pop();
            String a1=o1+optr+o2;
            str2.push('('+a1+')');
            
            //prefix
            String o22=str3.pop();
            String o11=str3.pop();
            String a2=optr+o11+o22;
            str3.push(a2);
        }
    }
        System.out.println(str1.peek());
        System.out.println(str2.peek());
        System.out.println(str3.peek());
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