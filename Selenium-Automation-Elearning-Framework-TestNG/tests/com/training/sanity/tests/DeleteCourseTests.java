package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.training.generics.ScreenShot;
import com.training.pom.AdminPOM;
import com.training.pom.AlertPopUpPOM;
import com.training.pom.CourseCategoryListPOM;
import com.training.pom.CourseListPOM;
import com.training.pom.LoginPOM;
import com.training.pom.PostLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class DeleteCourseTests {

	private WebDriver driver; 
	private String baseUrl; 
	private LoginPOM loginPOM;
	private AdminPOM admin;
	private PostLoginPOM postLoginPOM;
	private CourseListPOM courseList;
	private AlertPopUpPOM popUp;
	public SoftAssert as;
	private static Properties properties; 
	private ScreenShot screenShot; 


	@DataProvider(name="inputs")
	public Object[][] getData() {
		return new Object[][] {
			{"admin", "admin@123"}
		};
	}

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		admin = new AdminPOM(driver);
		postLoginPOM = new PostLoginPOM(driver);
		courseList = new CourseListPOM(driver);
		popUp=new AlertPopUpPOM(driver);
//		as = new SoftAssert();
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test(dataProvider="inputs")
	public void testMethod1(String userName, String password) throws InterruptedException {
		as = new SoftAssert();
		loginPOM.sendUserName(userName);
		loginPOM.sendPassword(password);
		loginPOM.clickLoginBtn();
		postLoginPOM.clickAdminBtn();
		admin.clickCourseList();
		screenShot.captureScreenShot();
		String deleted=courseList.deleteCourse();
		System.out.println("Deleted Course : "+deleted);
		popUp.acceptPopUp();
		try{
			as.assertEquals(deleted.trim(), "Sample004");
//	 Assert.assertEquals(deleted.trim(), "Sample004");
		}
		catch(Exception e)
		{
			System.out.println("The Error is : " + e.getMessage());
		}
		System.out.println("hi");
		screenShot.captureScreenShot();
	}}
