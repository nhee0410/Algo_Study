import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int hap = 0;
        int result = 0;
        
        for(int i = 0; i < 5; i++){
            int j = sc.nextInt();
            
            if(j < 40){
                hap += 40;
            } else {
                hap += j;
            }
        }
        
        result = hap/5;
        System.out.println(result);
    }
}
