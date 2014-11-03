package com.brayden.chi2ara;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChineseNum2ArabicNumConverterTest {
	@Test
	public void test1(){
		ChineseNum2ArabicNumConverter converter = new ChineseNum2ArabicNumConverter();
		assertEquals(11L, converter.convert("十一"));
	}
	
	@Test
	public void test2(){
		ChineseNum2ArabicNumConverter converter = new ChineseNum2ArabicNumConverter();
		assertEquals(1_1000L, converter.convert("一万一"));
	}
	
	@Test
	public void test3(){
		ChineseNum2ArabicNumConverter converter = new ChineseNum2ArabicNumConverter();
		assertEquals(10_0100L, converter.convert("十万零一百"));
	}
	
	@Test
	public void test4(){
		ChineseNum2ArabicNumConverter converter = new ChineseNum2ArabicNumConverter();
		assertEquals(1_0001_0000L, converter.convert("一亿零一万"));
	}
		
	@Test
	public void test5(){
		ChineseNum2ArabicNumConverter converter = new ChineseNum2ArabicNumConverter();	
		assertEquals(101_0101_0101L, converter.convert("一百零一亿零一百零一万零一百零一"));
	}
		
	@Test
	public void test6(){
		ChineseNum2ArabicNumConverter converter = new ChineseNum2ArabicNumConverter();	
		assertEquals(1234_5678_9012_3456L, converter.convert("一千二百三十四万五千六百七十八亿九千零一十二万三千四百五十六"));
	}
	
	@Test
	public void test7(){
		ChineseNum2ArabicNumConverter converter = new ChineseNum2ArabicNumConverter();
		assertEquals(1L, converter.convert("一"));
	}
	
	@Test
	public void test8(){
		ChineseNum2ArabicNumConverter converter = new ChineseNum2ArabicNumConverter();
		assertEquals(10L, converter.convert("十"));
	}
	
	@Test
	public void test9(){
		ChineseNum2ArabicNumConverter converter = new ChineseNum2ArabicNumConverter();
		assertEquals(10_0000_0000L, converter.convert("十亿"));
	}
	
	@Test
	public void test10(){
		ChineseNum2ArabicNumConverter converter = new ChineseNum2ArabicNumConverter();
		assertEquals(100L, converter.convert("一百"));
	}
}
