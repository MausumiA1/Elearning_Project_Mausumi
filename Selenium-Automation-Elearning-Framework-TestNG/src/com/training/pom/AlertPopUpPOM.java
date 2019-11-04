package com.training.pom;

import org.openqa.selenium.WebDriver;

public class AlertPopUpPOM {
	WebDriver driver ; 
	
	public AlertPopUpPOM(WebDriver driver){
		this.driver = driver;
	}
	
	public String getPopupText(){
	return (driver.switchTo().alert().getText());
	}
	
	public void acceptPopUp() {
		driver.switchTo().alert().accept();
	}
}
