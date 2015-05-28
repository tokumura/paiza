package paiza;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_CheckDigit {
	
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_of_cards = Integer.parseInt(br.readLine());
        
        ArrayList<String> card_list = new ArrayList<String>();
        
        for(int i = 0; i < num_of_cards; i++) {
            card_list.add(br.readLine());
        }
        
        for(String cn : card_list) {
            String disit = ShowCheckDisit(new StringBuilder(cn).reverse().toString());
            System.out.println(disit);
        }
	}
	
	/*
	 * チェックディジッド表示
	 */
	public static String ShowCheckDisit(String card_num) throws Exception {
		// 偶数
        int idx = 1;
        int even_total = 0;
        for(int i = 1; i <= 8; i++) {
        	String number = card_num.substring(idx, idx + 1);
        	int number_doubled = Integer.parseInt(number) * 2;
        	if (number_doubled >= 10) {
        		int ones = Integer.parseInt(String.valueOf(number_doubled).substring(0, 1));
        		int tens = Integer.parseInt(String.valueOf(number_doubled).substring(1, 2));
        		even_total = even_total + ones + tens;
        	} else {
        		even_total += number_doubled;
        	}
        	idx += 2;
        }
        
        // 奇数
        idx = 0;
        int odd_total = 0;
        for(int i = 0; i < 8; i++) {
        	String number = card_num.substring(idx, idx + 1);

        	if (number.equals("X")) {
        		idx += 2;
        		continue;
        	}
        	
        	odd_total += Integer.parseInt(number);
        	idx += 2;
        }
        
        // Xの値
        int total = even_total + odd_total;
        int disit = 0;
        int rest = total % 10;
        if (rest != 0) {
        	disit = 10 - rest;
        }
        
        return String.valueOf(disit);
	}

}
