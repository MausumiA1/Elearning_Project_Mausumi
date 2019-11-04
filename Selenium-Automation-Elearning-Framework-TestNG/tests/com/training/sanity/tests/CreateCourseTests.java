package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminPOM;
import com.training.pom.AlertPopUpPOM;
import com.training.pom.CourseListPOM;
import com.training.pom.CreateCoursePOM;
import com.training.pom.LoginPOM;
import com.training.pom.PostLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CreateCourseTests {
	private WebDriver driver; 
	private String baseUrl; 
	private LoginPOM loginPOM;
	private AdminPOM admin;
	private PostLoginPOM postLoginPOM;
	private CreateCoursePOM createCourse;
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
		createCourse= new CreateCoursePOM(driver);
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
	public void testMethod1(String userName, String password) {
		
		loginPOM.sendUserName(userName);
		loginPOM.sendPassword(password);
		loginPOM.clickLoginBtn();
		postLoginPOM.clickAdminBtn();
		admin.clickCreateCourse();
		createCourse.setTitle("testing");
		createCourse.setCode("tes");
		WebElement cat=createCourse.getCategory("Selenium (QA)");
		createCourse.setCategory(cat);
		createCourse.setTeachers("reva");
		WebElement lang=createCourse.getLang("English");
		createCourse.setLang(lang);
		createCourse.clickCreateCourseBtn();
		screenShot.captureScreenShot();
		
	}

}
