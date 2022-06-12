import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    // code
    Stack<Integer>opnd=new Stack<>();
    Stack<Character>optr=new Stack<>();
    
    //Traverse over the string
    for(int i=0;i<str.length();i++){
        char ch=str.charAt(i);
        
        if(ch=='('){
            optr.push(ch);//If opening bracket push in the operator stack
        }
        else if(ch>='0' && ch<='9'){
            opnd.push(ch-'0');//If operand the push in the operand stack
        }
        else if(ch==')'){ //If closing bracket pop until open bracket
            while(optr.peek()!='('){
                char op=optr.pop();
                int var2=opnd.pop();
                int var1=opnd.pop();
                int ans=operation(var1,var2,op);
                opnd.push(ans);
            }
            optr.pop(); //pop the opening bracket
        }
        else if(ch=='+' || ch=='-' ||ch =='*' ||ch=='/'){
            while( optr.size()>0  && optr.peek()!='(' && precedence(ch)<=precedence(optr.peek()) ){
                char op=optr.pop();
                int var2=opnd.pop();
                int var1=opnd.pop();
                int ans=operation(var1,var2,op);
                opnd.push(ans);
            }
            optr.push(ch);
        }
    }
    
    while(optr.size()>0){
        char op=optr.pop();
        int var2=opnd.pop();
        int var1=opnd.pop();
        int ans=operation(var1,var2,op);
        opnd.push(ans);
    }
    System.out.println(opnd.peek());
 }

public static int precedence(char ch){
    if(ch=='+' || ch=='-'){
        return 1;
    }
    else{
        return 2;
    }
}

public static int operation(int v1,int v2,char ch){
    if(ch=='+'){
        return v1+v2;
    }
    else if(ch=='-'){
        return v1-v2;
    }
    else if(ch=='*'){
        return v1*v2;
    }
    else{
        return v1/v2;
    }
}

}
