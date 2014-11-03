package com.brayden.chi2ara;
import java.util.HashMap;
import java.util.Map;

/**
 * Convert Chinese number to Arabic number.
 * Only for Simplified Chinese.
 * Only for numbers in [0 - 9999_9999_9999_9999]
 * @author Brayden Zhang
 *
 */
public class ChineseNum2ArabicNumConverter {
	
	private static Map<Character, Integer> chieseDigit2AragicDigitMap = new HashMap<>();

	static{
		chieseDigit2AragicDigitMap.put('һ', /* => */ 1);
		chieseDigit2AragicDigitMap.put('��', /* => */ 2);
		chieseDigit2AragicDigitMap.put('��', /* => */ 3);
		chieseDigit2AragicDigitMap.put('��', /* => */ 4);
		chieseDigit2AragicDigitMap.put('��', /* => */ 5);
		chieseDigit2AragicDigitMap.put('��', /* => */ 6);
		chieseDigit2AragicDigitMap.put('��', /* => */ 7);
		chieseDigit2AragicDigitMap.put('��', /* => */ 8);
		chieseDigit2AragicDigitMap.put('��', /* => */ 9);
	}

	/** A normalized Chinese number should be in format of:
	 * һǧһ��һʮһ��һǧһ��һʮһ��һǧһ��һʮһ��һǧһ��һʮһ��
	 * 
	 * rule1. no "ʮ��", should be "һʮ��"; no "ʮ��", "ʮ��".
	 * rule2��  ended with "��, ��, ǧ, ��, ʮ, ��", eg, no "һǧһ".
	 * rule3. no "��";
	 * @param chineseNum original Chinese number
	 * @return A normalized Chinese number
	 */
	private String normalizeChineseNum(String chineseNum) {
		if(chineseNum.startsWith("ʮ")){ // rule1
			chineseNum = "һ" + chineseNum;
		}
		if(chineseNum.matches(".*[һ�����������߰˾�]$")){ // rule2
			if(chineseNum.length() == 1){ // for case of "һ"
				chineseNum += '��';
			}else {
				char needTocheck = chineseNum.charAt(chineseNum.length() - 2);
				if(needTocheck == '��') // for case of "һ����һ"
					chineseNum += '��';
				else{
					switch(needTocheck){
					case '��': chineseNum += 'ǧ'; break;
					case 'ǧ': chineseNum += '��'; break;
					case '��': chineseNum += 'ʮ'; break;
					case 'ʮ': chineseNum += '��'; break;
					}
				}
			}
		}
		chineseNum = chineseNum.replaceAll("��", ""); // rule3
		return chineseNum;
	}
	
	public long convert(String chineseNum){
		chineseNum = normalizeChineseNum(chineseNum);
		long result = 0;
		long resultWithYi = 0;
		int curDigit = 0;
		for(char c : chineseNum.toCharArray()){
			switch(c){
			case '��': 
				resultWithYi = (result + curDigit) * 1_0000_0000;
			    result = 0;
				curDigit = 0;
				break;
			case '��': 
				result = (result + curDigit) * 1_0000;
			    curDigit = 0;
			    break;
			case 'ǧ': 
				result += curDigit * 1000; 
				curDigit = 0;
				break;
			case '��': 
				result += curDigit * 100;  
				curDigit = 0;
				break;
			case 'ʮ': 
				result += curDigit * 10;   
				curDigit = 0;
				break;
			case '��': 
				result += curDigit;        
				break;
			default: 
				curDigit = chieseDigit2AragicDigitMap.get(c);
			}
		}
		return result + resultWithYi;
	}
	
}
