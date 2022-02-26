import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNextInt()){
            int A = sc.nextInt();
            int B = sc.nextInt();
            
            int result = 0;
            
            result = A + B;
            
            System.out.println(result);
        }
    }
}
