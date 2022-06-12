import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        System.out.println(bb(str));
    }
    
    public static boolean bb(String str){
        Stack<Character>st=new Stack<>();
        
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            
            if(ch=='(' ||ch=='{' ||ch=='['){
                st.push(ch);
            }
            else if(ch==')' ||ch=='}' || ch==']'){
                if(st.size()==0){
                    return false; //more closing brackets
                }
                if(ch==')'){
                    if(st.peek()!='('){
                        return false; //mismatch
                    }
                }
                else if(ch=='}'){
                    if(st.peek()!='{'){
                        return false; //mismatch
                    }
                }
                else{
                    if(st.peek()!='['){
                        return false; //mismatch
                    }
                }
                st.pop(); // if matches remove the opening bracket
            }
            else{
                //do nothing for other expressions
            }
        }
        
        if(st.size()>0){
            return false;
        }
        else{
            return true;
        }
    }

}