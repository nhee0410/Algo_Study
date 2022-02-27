import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();

        int result = 0;
        
        for(int i = 1; i <= T; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            
            result = A+B;
            System.out.println("Case #" + i + ":" + " " + result);
        }
    }
}
