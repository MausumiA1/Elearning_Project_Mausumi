package com.training.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseCategoryListPOM {
	private WebDriver driver; 
	
	public CourseCategoryListPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Add category']")
	private WebElement addCategoryIcon; 
	
	@FindBy(xpath="//table[@class='data_table']//tr")
	private List<WebElement> RowCount; 
	
	@FindBy(xpath="//a/img[@title='Open this category']")
	private List<WebElement> categoryTitle;
	
	@FindBy(xpath="//td//img[@title='Delete this category']")
	private List<WebElement> deleteCategoryButton;
	
	
	
	public String deleteCategory() {
		
		String CategoryName=categoryTitle.get(1).getText();
		deleteCategoryButton.get(1).click();
		return CategoryName;
		
	}
	
	public List<String> getCategoryName(){
		ArrayList<String> CategoryName=new ArrayList<String>();
		for(int i=0;i<categoryTitle.size();i++) {
			CategoryName.add(categoryTitle.get(i).getText());
		}
		return CategoryName;
	}
	
	
	public void clickaddCategoryIcon() {
		this.addCategoryIcon.click(); 
	}
	
}
