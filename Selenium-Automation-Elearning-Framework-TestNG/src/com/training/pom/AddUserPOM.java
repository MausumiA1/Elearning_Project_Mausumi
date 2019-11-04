package com.training.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPOM {
	private WebDriver driver; 
	private WebElement selUser;
	private WebElement selCourse;
	
	public AddUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@name='UserList[]']/option")
	private List<WebElement> allUsers; 
	
	@FindBy(xpath="//select[@name='CourseList[]']/option")
	private List<WebElement> allCourses;	
	
	@FindBy(xpath="//button[@value='Add to the course(s) >>']")
	private WebElement addToCourseBtn; 
	
	public void selUserToAdd(String userToAdd){
		for(int i=0;i<allUsers.size();i++) {
			if(this.allUsers.get(i).getText().trim().equalsIgnoreCase(userToAdd))
			{
				this.selUser=allUsers.get(i);
				break;
			}
			
		}
		if(this.selUser != null){
			this.selUser.click();
		}
	}
	
	public void selCourseToAdd(String courseToAdd){
		for(int i=0;i<allCourses.size();i++) {
			System.out.println(allCourses.get(i)+ "-->" +allCourses.get(i).getText().trim());
			if(this.allCourses.get(i).getText().trim().equalsIgnoreCase(courseToAdd))
			{
				selCourse=allCourses.get(i);
				break;
			}
			
		}
		if(selCourse != null) {
			System.out.println(selCourse.getText());
			selCourse.click();
		}
	}
	
	public void clickAddUserToCourseBtn() {
		this.addToCourseBtn.click(); 
	}	

}
