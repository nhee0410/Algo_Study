import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        int hour = 0;
        int minutes = 0;
        int result = 0;
        
        if((B + C) >= 60){
            minutes = (B+C) % 60;
            hour = A + ((B+C)/60);
            
            if(hour >= 24){
                result = hour - 24;
            } else {
                result = hour;
            }
        } else {
            minutes = B + C;
            result = A;
        }
        System.out.print(result + " " + minutes);
    }
}
