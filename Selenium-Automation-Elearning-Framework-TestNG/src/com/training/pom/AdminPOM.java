package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPOM {
	private WebDriver driver; 
	
	public AdminPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Course list')]")
	private WebElement courseList; 
	
	@FindBy(xpath="//a[contains(text(),'Create a course')]")
	private WebElement createCourse;
	
	@FindBy(xpath="//a[contains(text(),'Add users to course')]")
	private WebElement addUser;
	
	@FindBy(xpath="//a[contains(text(),'Courses categories')]")
	private WebElement courseCatagories;
	
	public void clickCourseList() {
		this.courseList.click(); 
	}
	
	public void clickCreateCourse() {
		this.createCourse.click();
	}
	public void clickAddUserToCourse() {
		this.addUser.click(); 
	}
	
	public void clickCourseCategories(){
		this.courseCatagories.click();
	}
}
