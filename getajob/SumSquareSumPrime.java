import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SumSquareSumPrime {
    static int sieveLimit = 18*81;
    static int [] sieve = new int[sieveLimit+1];
    
    static void prepareSieve(){
        for(int i = 0; i< sieveLimit;i++){
            sieve[i]=0;
        }
        
        sieve[0]=-1;
        sieve[1]=-1;
        
        for(int factor = 2 ; factor*factor<=sieveLimit ; factor++){
            if(sieve[factor]==0){
                for(int j = factor; factor*j <= sieveLimit; j++){
                    sieve[factor*j] = -1;
                }
            }
        }

        for(int i = 0; i< sieveLimit;i++){
            System.out.println(i+"."+sieve[i]+" ");
        }
    }
    
    static void resolveTestCase(long A, long B){
        int sum=0, sumOfSquare=0, count=0;
        for(long i=A;i<=B;i++){
            while(i>0){
                sum += i%10;
                sumOfSquare += (i%10)*(1%10);
                i = i/10;
            }
            if(sieve[sum]==0 && sieve[sumOfSquare]==0){
                count++;
            }
        }
        //System.out.println(count);
    }
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        prepareSieve();
        int T;
        long A,B;
        Scanner scan = new Scanner(System.in);
        T = scan.nextInt();
        for(int i=0;i<T;i++){
            A=scan.nextLong();
            B=scan.nextLong();
            //resolveTestCase(A,B);
        }
    }
}