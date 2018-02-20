import java.util.*;

public class Main{
    
    static boolean [] special = new boolean[101];
    
    static void check(String s1, int n){
        char [] arr = s1.toCharArray();
        boolean flaga = true;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='0'){
                flaga=false;
                break;
            }
        }
        boolean flagb = true;
        if(n>3){
            for(int i=1;i<arr.length-1;i++){
                if(arr[i]=='1' && arr[i-1]=='0' && arr[i+1]=='0'){
                    flagb=false;
                    break;
                }
            }
        }
        int count=0,prevCount=-1;
        boolean flagc = true;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='1'){
                count++;
            }
            else{
                if(prevCount >= count){
                    flagc = false;
                    break;
                }
                prevCount = count;
                count = 0;
            }
        }

        if(flaga||flagb||flagc){
            special[n-1] = true;
            System.out.println(n + " " + s1 + " " + flaga + " " + flagb + " " + flagc);
        }
    }
    
    static void createArray(){
        int max = 101,min=1;
        Deque<String> q = new ArrayDeque<String>();
        q.add("1");
        while(min <= max){
            String s1 = q.remove();
            check(s1,min);
            String s2 = s1;
            q.add(s1+"0");
            q.add(s2+"1");
            min++;
        }
    }
    
    static void resolve(int n, int m){
        int count = 0;
        for(int i=n-1;i<=m-1;i++){
            if(special[i]==true){
                //System.out.println(i+1);
                count++;
            }
        }
        System.out.println(count);
    }
    
    public static void main(String [] args){
        for(int i=0;i<special.length;i++){
            special[i] = false;
        }
        createArray();
        /*for(int i=0;i<special.length;i++){
            System.out.println((i+1) + " " + special[i]);
        }*/
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i=0;i<t;i++){
            int n = scan.nextInt(), m = scan.nextInt();
            resolve(n,m);
        }
    }
}