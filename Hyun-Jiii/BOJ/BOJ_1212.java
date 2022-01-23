//문제
//8진수가 주어졌을 때, 2진수로 변환하는 프로그램을 작성하시오.

//입력
//첫째 줄에 8진수가 주어진다. 주어지는 수의 길이는 333,334을 넘지 않는다.

//출력
//첫째 줄에 주어진 수를 2진수로 변환하여 출력한다. 수가 0인 경우를 제외하고는 반드시 1로 시작해야 한다.

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();
        int sum = 0;
        int len= s.length();
        StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			String a = Integer.toBinaryString(s.charAt(i)-'0');
			if(a.length()==2 && i!=0) a="0"+a;
			else if(a.length()==1 && i!=0) a="00"+a;
			
			sb.append(a);
		}
		
		
		System.out.println(sb);
        
        
    }
}
