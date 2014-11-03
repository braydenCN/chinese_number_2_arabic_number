package com.brayden.chi2ara;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChineseNum2ArabicNumConverterTest {
	@Test
	public void test1(){
		ChineseNum2ArabicNumConverter converter = new ChineseNum2ArabicNumConverter();
		assertEquals(11L, converter.convert("ʮһ"));
	}
	
	@Test
	public void test2(){
		ChineseNum2ArabicNumConverter converter = new ChineseNum2ArabicNumConverter();
		assertEquals(1_1000L, converter.convert("һ��һ"));
	}
	
	@Test
	public void test3(){
		ChineseNum2ArabicNumConverter converter = new ChineseNum2ArabicNumConverter();
		assertEquals(10_0100L, converter.convert("ʮ����һ��"));
	}
	
	@Test
	public void test4(){
		ChineseNum2ArabicNumConverter converter = new ChineseNum2ArabicNumConverter();
		assertEquals(1_0001_0000L, converter.convert("һ����һ��"));
	}
		
	@Test
	public void test5(){
		ChineseNum2ArabicNumConverter converter = new ChineseNum2ArabicNumConverter();	
		assertEquals(101_0101_0101L, converter.convert("һ����һ����һ����һ����һ����һ"));
	}
		
	@Test
	public void test6(){
		ChineseNum2ArabicNumConverter converter = new ChineseNum2ArabicNumConverter();	
		assertEquals(1234_5678_9012_3456L, converter.convert("һǧ������ʮ������ǧ������ʮ���ھ�ǧ��һʮ������ǧ�İ���ʮ��"));
	}
	
	@Test
	public void test7(){
		ChineseNum2ArabicNumConverter converter = new ChineseNum2ArabicNumConverter();
		assertEquals(1L, converter.convert("һ"));
	}
	
	@Test
	public void test8(){
		ChineseNum2ArabicNumConverter converter = new ChineseNum2ArabicNumConverter();
		assertEquals(10L, converter.convert("ʮ"));
	}
	
	@Test
	public void test9(){
		ChineseNum2ArabicNumConverter converter = new ChineseNum2ArabicNumConverter();
		assertEquals(10_0000_0000L, converter.convert("ʮ��"));
	}
	
	@Test
	public void test10(){
		ChineseNum2ArabicNumConverter converter = new ChineseNum2ArabicNumConverter();
		assertEquals(100L, converter.convert("һ��"));
	}
}
