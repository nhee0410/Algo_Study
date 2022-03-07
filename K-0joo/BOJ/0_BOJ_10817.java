import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        int second = 0;
        
        if(A >= B){
            
            if(A >= C){
                
                if (B >= C){
                    second = B;
                } else {
                    second = C;
                }
                
            }else {
                second = A;
            }    
            
        } else {
            
            if( B >= C){
                
                if(A >= C){
                    second = A;
                } else {
                    second = C;
                }
                
            } else {
                second = B;
            }
        }
        System.out.println(second);
    }
}
