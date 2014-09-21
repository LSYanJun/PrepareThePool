package edu.stevens.ssw567.ywu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;


public class DataCheckTest extends TestCase{
	DataCheck dc = new DataCheck();
	public DataCheckTest(){
		
	}
	@Before
	public void setUp()throws Exception{
	}
	@After
	public void tearDown() throws Exception{
	}
	@Test
	public void testIsValidNumber(){
		
		String str1 = "1.2 6 8 10 ywu29";
		String str2 = "12 -6 8 10 ywu29";
		String str3 = "12 6 abc 10 ywu29";
		String str4 ="12 6 8 * ywu29";
		String str5 = "12 6 8 10 ywu29";
		boolean flag1 = dc.Check(str1);
		boolean flag2 = dc.Check(str2);
		boolean flag3 = dc.Check(str3);
		boolean flag4 = dc.Check(str4);
		boolean flag5 = dc.Check(str5);
		assertEquals(false,flag1);
		assertEquals(false,flag2);
		assertEquals(false,flag3);
		assertEquals(false,flag4);
		assertEquals(true,flag5);
		System.out.println("valid number test completed");
		
	}
	@Test
	public void testIsAmountCorrect(){
		String str1 = "12 6 8 10 ywu29 abcd";
		String str2 = "12 6 8 10";
		String str3 = "12 6 8 10 ywu29";
		boolean flag1 = dc.Check(str1);
		boolean flag2 = dc.Check(str2);
		boolean flag3 = dc.Check(str3);
		assertEquals(false,flag1);
		assertEquals(false,flag2);
		assertEquals(true,flag3);
		System.out.println("amount of number test completed");
	}
	@Test
	public void testIsGreaterNumber(){
		String str1 = "6 12 8 10 ywu29";
		String str2 = "12 6 8 10 ywu29";
		String str3 = "12 6 10 8 ywu29";
		String str4 = "6 12 10 8 ywu29";
		boolean flag1 = dc.Check(str1);
		boolean flag2 = dc.Check(str2);
		boolean flag3 = dc.Check(str3);
		boolean flag4 = dc.Check(str4);
		assertEquals(false,flag1);
		assertEquals(false,flag3);
		assertEquals(false,flag4);
		assertEquals(true,flag2);
		System.out.println("greater number test completed");
	}
	@Test
	public void testBeyondLimit(){
		String str1 = "1200 6 8 10 ywu29";
		String str2 = "12 600 8 10 ywu29";
		String str3 ="12 6 800 10 ywu29";
		String str4 = "12 6 8 1000 ywu29";
		String str5 = "12 6 8 10 ywu29";
		boolean flag1 = dc.Check(str1);
		boolean flag2 = dc.Check(str2);
		boolean flag3 = dc.Check(str3);
		boolean flag4 = dc.Check(str4);
		boolean flag5 = dc.Check(str5);
		assertEquals(false,flag1);
		assertEquals(false,flag2);
		assertEquals(false,flag3);
		assertEquals(false,flag4);
		assertEquals(true,flag5);
		System.out.println("beyond limits test completed");
	}

}
