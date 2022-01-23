//전체 상금의 22%를 제세공과금으로 납부하는 경우
//상금의 80%를 필요 경비로 인정받고, 나머지 금액 중 22%만을 제세공과금으로 납부하는 경우
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); //상금 금액
        
        double a = n - (n * 0.22);
        double b = (n*0.8) + (n*0.2) - ((n*0.2)*0.22);
        
        System.out.println((int)a);
        System.out.println((int)b);
    }
}
