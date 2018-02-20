import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MicrosoftTreeDia {

    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int getMaxLength(Node n){
        if(n == null)
            return 0;
        int lh = height(n.left);
        int rh = height(n.right);
        System.out.println("H:"+n.data+" "+lh + " " + rh);
        int ld = getMaxLength(n.left);
        int rd = getMaxLength(n.right);
        System.out.println("D:"+n.data+" "+ld + " " + rd);
        return Math.max(lh + rh, Math.max(ld,rd));
    }

    static int height(Node n){
        if(n == null)
            return 0;
        return 1 + Math.max(height(n.left),height(n.right));
    }
    
    static int GetLongestPathInTree(String inputSeq) {
        String edges = inputSeq.substring(1,inputSeq.length()-1);
        String [] edge = edges.split("\\) \\(");
        HashMap<Integer,Node> nodes = new HashMap<Integer,Node>();
        for(String s:edge){
            String [] data = s.split(",");
            int d1 = Integer.parseInt(data[0]);
            Node n1 = nodes.get(d1);
            if(n1 == null){
                Node tmp = new Node(d1);
                nodes.put(d1,tmp);
            }
                
            int d2 = Integer.parseInt(data[1]);
            Node n2 = nodes.get(d2);
            if(n2 == null){
                Node tmp = new Node(d2);
                nodes.put(d2,tmp);   
            }
            n1 = nodes.get(d1);
            if(n1.left == null)
                n1.left = nodes.get(d2);
            else
                n1.right = nodes.get(d2);
        }
        Node n1 = nodes.get(1);
        return getMaxLength(n1);
    }


    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int res;
        String _inputSeq;
        try {
            _inputSeq = in.nextLine();
        } catch (Exception e) {
            _inputSeq = null;
        }
        res = GetLongestPathInTree(_inputSeq);
        System.out.println(res);
    }
}