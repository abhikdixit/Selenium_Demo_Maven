package com.selenium.maven;

import org.testng.annotations.DataProvider;


public class ApplicationTestData {

	@DataProvider(name="Login")
	public Object[][] getDataFromDataprovider(){

		return new Object[][] {

			{"abhinay.dixit@hotmail.com", "test@1234"},
			{"jha199624@gmail.com", "testing" },
			{"harikaeco@gmail.com", "Selenium@1" }

		};
	}
	
	//-------------------------------------------- This is to read Excel Data------------

	@DataProvider(name = "LoginData")
	public Object[][] Authentication() throws Exception{
		ReadExcel excel = new ReadExcel();
		Object[][] testObjArray = excel.getExcelData("D:\\F Drive\\Selenium Training Data\\workspace\\Selenium_Demo_Maven\\YourLogo.xls","SignIn");
		System.out.println(testObjArray);
		return testObjArray;

	}

}
