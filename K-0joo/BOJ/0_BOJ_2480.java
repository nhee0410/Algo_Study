import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int[] num = new int[3];
        
        for(int i = 0; i < 3; i++){
            num[i] = sc.nextInt();
        }
        
        sc.close();
        
        int result = 0;
        
        int max = num[0];
        
        if(num[0] == num[1] && num[1] == num[2]){
            result = 10000 + num[0] * 1000;
        } else if(num[0] == num[1] || num[0] == num[2] || num[1] == num[2]){
            if(num[0] == num[1]){
                result = 1000 + num[0] * 100;
            } else if (num[0] == num[2]){
                result = 1000 + num[2] * 100;
            } else{
                result = 1000 + num[1] * 100;
            }
        } else{
        
            for(int i = 1; i < 3; i++){
                if(max < num[i])
                    max = num[i];
            }
            result = max * 100;
        }
        
        System.out.println(result);
        
    }
}
