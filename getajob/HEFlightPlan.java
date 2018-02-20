import java.util.Scanner;
import java.util.ArrayList;

class HEFlightPlan {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int N,M,T,C,X,Y;
        N = scan.nextInt();
        M = scan.nextInt();
        T = scan.nextInt();
        C = scan.nextInt();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for(int i = 0; i < M; i++){
            edges.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < M; i++){
            int u = scan.nextInt();
            int v = scan.nextInt();
            edges.get(u - 1).add(v - 1);
            edges.get(v - 1).add(u - 1);
        }
        System.out.println(edges.toString());
    }
}
