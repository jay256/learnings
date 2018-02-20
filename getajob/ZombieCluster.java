import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ZombieCluster {

/*
     * Complete the function below.
     */
	static boolean isSafe(int M[][], int row, int col,
                   boolean visited[][], int n)
    {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < n) &&
               (col >= 0) && (col < n) &&
               (M[row][col]==1 && !visited[row][col]);
    }

    static void DFS(int [][] matrix, int i, int j, boolean [][] visited, int n){
    	System.out.println(i+" "+j);
    	for(int p=0;p<n;p++){
            for(int q=0;q<n;q++){
                System.out.print(visited[p][q]+" ");   
            }
            System.out.println();
        }
        int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
        visited[i][j] = true;
        for (int k = 0; k < 8; ++k)
            if (isSafe(matrix, i + rowNbr[k], j + colNbr[k], visited, n) )
                DFS(matrix, i + rowNbr[k], j + colNbr[k], visited, n);
    }

    static int zombieCluster(String[] zombies) {
        int result=0;
        int n = zombies.length;
        int [][] matrix = new int[n][n];
        boolean [][] visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = Integer.parseInt("" + zombies[i].charAt(j));
                visited[i][j]=false;
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
            	System.out.println("matrix["+i+"]["+j+"]"+":"+matrix[i][j]+" "+"visited["+i+"]["+j+"]"+":"+visited[i][j]);
                if(matrix[i][j]==1 && visited[i][j]==false){
                	System.out.println("Adding connected component"+i+" "+j);
                    DFS(matrix,i,j,visited,n);
                    result++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int res;
        int zombies_size = 0;
        zombies_size = Integer.parseInt(in.nextLine().trim());

        String[] zombies = new String[zombies_size];
        for(int i = 0; i < zombies_size; i++) {
            String zombies_item;
            try {
                zombies_item = in.nextLine();
            } catch (Exception e) {
                zombies_item = null;
            }
            zombies[i] = zombies_item;
        }

        res = zombieCluster(zombies);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}
