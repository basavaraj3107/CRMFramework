package practice.test;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsTest {
	@BeforeSuite
	public void bs2() {
		System.out.println("BS2");
	}

	@BeforeSuite
	public void bs1() {
		System.out.println("BS1");
	}

	@AfterSuite
	public void as1() {
		System.out.println("AS1");
	}

	@AfterSuite
	public void as2() {
		System.out.println("AS2");
	}

	@Test
	public void test1() {
		System.out.println("TEST1");
	}

	@Test
	public void test2() {
		System.out.println("TEST2");
	}

	@BeforeClass
	public void bc1() {
		System.out.println("BC1");
	}

	@BeforeClass
	public void bc2() {
		System.out.println("BC2");
	}

	@AfterClass
	public void ac1() {
		System.out.println("AC1");
	}

	@AfterClass
	public void ac2() {
		System.out.println("AC2");
	}

	@BeforeMethod
	public void bm1() {
		System.out.println("BM!");
	}

	@BeforeMethod
	public void bm2() {
		System.out.println("BM2");
	}

	@AfterMethod
	public void am1() {
		System.out.println("AM1");
	}

	@AfterMethod
	public void am2() {
		System.out.println("AM2");
	}
	
	@BeforeTest
	public void bt() {
		System.out.println("BT");
	}
	@AfterTest
	public void at() {
		System.out.println("AT");
	}
}
