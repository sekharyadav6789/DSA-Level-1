import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        
        Stack<Integer>st=new Stack<>();
        
        for(int idx=0;idx<arr.length;idx++){
            st.push(idx);
        }
        
        while(st.size()!=1){
            int i=st.pop();
            int j=st.pop();
            
            //i knows j
            if(arr[i][j]==1){
                st.push(j); //i can't be celebrity
            }
            //i doesn't know j
            else{
                
                st.push(i); //j can't be celebrity
            }
            
        }
        int c=st.pop();
        //verify
        for(int i=0;i<arr.length;i++){
            if(i==c){
                continue;
            }
            if(arr[c][i]==1 || arr[i][c]==0){
                System.out.println("none");
                return;
            }
        }
        System.out.println(c);
    }
}