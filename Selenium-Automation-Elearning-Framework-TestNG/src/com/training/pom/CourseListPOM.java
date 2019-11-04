package com.training.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseListPOM {
	WebDriver driver ;
	public CourseListPOM(WebDriver driver) {
		this.driver= driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//table[@id='course-list']//tr")
		private List<WebElement> RowCount; 
		
		@FindBy(xpath="//td[@class='title']")
		private List<WebElement> CourseTitle;
		
		@FindBy(xpath="//td[@class='td_actions']//img[@title='Delete']")
		private List<WebElement> DeleteButton;
		
		
		
		public String deleteCourse() {
			
			String CourseName=CourseTitle.get(1).getText();
			DeleteButton.get(1).click();
			return CourseName;
			
		}
		
		public List<String> getCourseName(){
			ArrayList<String> CourseName=new ArrayList<String>();
			for(int i=0;i<CourseTitle.size();i++) {
				CourseName.add(CourseTitle.get(i).getText());
			}
			return CourseName;
		}

}
