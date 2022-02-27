import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int max = -1000000;
        int min = 1000000;
        
        int N = sc.nextInt();
        int scan = 0;              
        
        for(int i = 0; i < N; i++){
            scan = sc.nextInt();
            
            if(min > scan){
                min = scan;
            } 
            
            if(max < scan){
                max = scan;
            }
        }
        
        System.out.println(min + " " + max);

    }
}
