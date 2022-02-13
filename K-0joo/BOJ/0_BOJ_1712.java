import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int minus = 0;
        int quo = 0;
        int result = 0;
        
        if((C-B) <= 0){
            System.out.println(-1);
        } else{
            minus = C-B;
            quo = A/minus;
            result = quo + 1;
            System.out.println(result);
        }
    }
}
