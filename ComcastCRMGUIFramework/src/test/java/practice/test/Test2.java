package practice.test;

import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class Test2 {
	@Test
	public void excelDataTest() throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		String data = eLib.getDataFromExcelFile("org", "TC001", "orgNumber");
		System.out.println(data);
		System.out.println(data);
	}
}
