import java.util.*;

public class Main{
    public static void main(String[] args){
    
        Scanner sc = new Scanner(System.in);
        
        int sangduck = sc.nextInt();
        int jungduck = sc.nextInt();
        int haduck = sc.nextInt();
        int cola = sc.nextInt();
        int sida = sc.nextInt();
        
        int minJuice = 0;
        int minBurger = 0;
        int result = 0;
        
        if(sangduck < jungduck){
            if(sangduck < haduck){
                minBurger = sangduck;
            } else{
                minBurger = haduck;
            }
        } else {
            if(jungduck < haduck){
                minBurger = jungduck;
            } else {
                minBurger = haduck;
            }
        }
        
        if(cola < sida){
            minJuice = cola;
        } else{
            minJuice = sida;
        }
        
        result = minJuice + minBurger - 50;
        
        System.out.println(result);
    }
}
