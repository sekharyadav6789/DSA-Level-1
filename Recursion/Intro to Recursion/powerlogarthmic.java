import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int x=scn.nextInt();
        int n=scn.nextInt();
        int result=power(x,n);
        System.out.println(result);
    }

    public static int power(int x, int n){
        //base case
        if(n==0)
        {
            return 1;
        }
        int xpnby2=power(x,n/2);
        int xpn=xpnby2*xpnby2;
        if(n%2 !=0) //odd case
        {
            xpn=xpn*x;
        }
        return xpn;
    }

}