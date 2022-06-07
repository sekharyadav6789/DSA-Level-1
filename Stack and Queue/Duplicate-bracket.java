import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        System.out.println(db(str));
    }
    
    public static boolean db(String str){
        Stack<Character>st=new Stack<>();
        
        //Traverse over the string
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==')'){
                //check if opening bracket is present just before the closing bracket.
                if(st.peek()=='('){
                    return true;
                }
                else{
                    while(st.peek()!='('){
                        st.pop();
                    }
                    st.pop(); //'(' remove karna ke liya
                }
            }
            else{
                st.push(str.charAt(i));
            }
        }
        return false;
    }

}