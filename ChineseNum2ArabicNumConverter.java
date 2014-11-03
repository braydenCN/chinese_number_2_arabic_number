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
		chieseDigit2AragicDigitMap.put('一', /* => */ 1);
		chieseDigit2AragicDigitMap.put('二', /* => */ 2);
		chieseDigit2AragicDigitMap.put('三', /* => */ 3);
		chieseDigit2AragicDigitMap.put('四', /* => */ 4);
		chieseDigit2AragicDigitMap.put('五', /* => */ 5);
		chieseDigit2AragicDigitMap.put('六', /* => */ 6);
		chieseDigit2AragicDigitMap.put('七', /* => */ 7);
		chieseDigit2AragicDigitMap.put('八', /* => */ 8);
		chieseDigit2AragicDigitMap.put('九', /* => */ 9);
	}

	/** A normalized Chinese number should be in format of:
	 * 一千一百一十一万一千一百一十一亿一千一百一十一万一千一百一十一个
	 * 
	 * rule1. no "十八", should be "一十八"; no "十万", "十亿".
	 * rule2。  ended with "亿, 万, 千, 百, 十, 个", eg, no "一千一".
	 * rule3. no "零";
	 * @param chineseNum original Chinese number
	 * @return A normalized Chinese number
	 */
	private String normalizeChineseNum(String chineseNum) {
		if(chineseNum.startsWith("十")){ // rule1
			chineseNum = "一" + chineseNum;
		}
		if(chineseNum.matches(".*[一二三四五六七八九]$")){ // rule2
			if(chineseNum.length() == 1){ // for case of "一"
				chineseNum += '个';
			}else {
				char needTocheck = chineseNum.charAt(chineseNum.length() - 2);
				if(needTocheck == '零') // for case of "一百零一"
					chineseNum += '个';
				else{
					switch(needTocheck){
					case '万': chineseNum += '千'; break;
					case '千': chineseNum += '百'; break;
					case '百': chineseNum += '十'; break;
					case '十': chineseNum += '个'; break;
					}
				}
			}
		}
		chineseNum = chineseNum.replaceAll("零", ""); // rule3
		return chineseNum;
	}
	
	public long convert(String chineseNum){
		chineseNum = normalizeChineseNum(chineseNum);
		long result = 0;
		long resultWithYi = 0;
		int curDigit = 0;
		for(char c : chineseNum.toCharArray()){
			switch(c){
			case '亿': 
				resultWithYi = (result + curDigit) * 1_0000_0000;
			    result = 0;
				curDigit = 0;
				break;
			case '万': 
				result = (result + curDigit) * 1_0000;
			    curDigit = 0;
			    break;
			case '千': 
				result += curDigit * 1000; 
				curDigit = 0;
				break;
			case '百': 
				result += curDigit * 100;  
				curDigit = 0;
				break;
			case '十': 
				result += curDigit * 10;   
				curDigit = 0;
				break;
			case '个': 
				result += curDigit;        
				break;
			default: 
				curDigit = chieseDigit2AragicDigitMap.get(c);
			}
		}
		return result + resultWithYi;
	}
	
}
