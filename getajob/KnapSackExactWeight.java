import java.io.*;
import java.util.*;

public class KnapSackExactWeight {

    static void resolveTestCase(int [] price, int [] grams, int N, int X){
        int [][] K = new int[N+1][X+1];
        int W=X;
        for(int i=0;i<=N;i++){
            for(int w=0; w<=X; w++){
                if(i==0||w==0)
                    K[i][w]=0;
                else if(grams[i-1]<=w){
                    K[i][w] = Math.max(price[i-1] + K[i-1][w-grams[i-1]],  K[i-1][w]);
                    if(K[i][w]!=K[i-1][w]){
                        W-=grams[i-1];
                        System.out.println(W);
                    }
                        
                }
                else
                    K[i][w] = K[i-1][w];
            }
        }
        if(W==0)
            System.out.println(K[N][X]);
        else
            System.out.println("Got caught!");
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int X,N;
        Scanner scan = new Scanner(System.in);
        N=scan.nextInt();
        X=scan.nextInt();
        int [] price = new int[N];
        int [] grams = new int[N];
        for(int i=0;i<N;i++){
            price[i]=scan.nextInt();
            grams[i]=scan.nextInt();
        }
        resolveTestCase(price, grams, N, X);
    }
}