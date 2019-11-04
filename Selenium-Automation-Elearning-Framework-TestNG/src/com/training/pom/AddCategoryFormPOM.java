package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategoryFormPOM {
	private WebDriver driver; 
	
	public AddCategoryFormPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='code']")
	private WebElement categoryCode;
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement categoryName;
	
	@FindBy(xpath="//input[@name='auth_course_child'][@value='TRUE']")
	private WebElement allowCourseToCategory;
	
	@FindBy(xpath="//input[@name='auth_course_child'][@value='FALSE']")
	private WebElement notAllowCourseToCategory;
	
	@FindBy(id="course_category_submit")
	private WebElement addCategoryBtn;
	
	
	public void setCategoryCode(String categoryCode) {
		this.categoryCode.clear(); 
		this.categoryCode.sendKeys(categoryCode);
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName.clear(); 
		this.categoryName.sendKeys(categoryName);
	}
	
	public void selAllowCourseToCategory(String isAllowedCategory) {
		if(isAllowedCategory.equalsIgnoreCase("yes")){
			this.allowCourseToCategory.click();
		}
		
		else if(isAllowedCategory.equalsIgnoreCase("no"))
		{
			this.notAllowCourseToCategory.click();
		}
	}
	
	public void clickAddCategory() {
		this.addCategoryBtn.click();
	}
	
}
