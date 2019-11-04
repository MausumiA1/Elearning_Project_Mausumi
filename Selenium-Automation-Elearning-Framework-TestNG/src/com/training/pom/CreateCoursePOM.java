package com.training.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCoursePOM {
	private WebDriver driver; 
	private WebElement langSelected;
	
	public CreateCoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="update_course_title")
	private WebElement title; 
	
	@FindBy(id="visual_code")
	private WebElement code;
	
	@FindBy(xpath="//button[@data-id='update_course_category_code']")
	private WebElement category;
	
	@FindBy(xpath="//a[@role='option']")
	private List<WebElement> allCategory;
	
	@FindBy(xpath="//div[contains(text(),'none')]")
	private WebElement selCategory;
	
	@FindBy(xpath="//span[@class='select2-selection__clear']")
	private WebElement clearTeacherField; 
	
	@FindBy(xpath="//input[@placeholder='Please select an option']")
	private WebElement teacher; 
	
	@FindBy(xpath="//li[@role='treeitem'][1]")
	private WebElement teacherSel; 
	
	@FindBy(id="department_name")
	private WebElement department; 
	
	@FindBy(id="department_url")
	private WebElement departmentURL;
	
	@FindBy(xpath="//button[@data-id='update_course_course_language']")
	private WebElement languageField;
	
	@FindBy(xpath="//a[@role='option']")
	private List<WebElement> language; 
	
	@FindBy(id="select2-update_course_course_template-container")
	private WebElement courseTemplate;
	
	@FindBy(xpath="//span[@class='select2-search select2-search--dropdown']")
	private WebElement courseTemplateText;
	
	@FindBy(xpath="//li[@class='select2-results__option'][1]")
	private WebElement courseTemplateSel;
	
	@FindBy(xpath="//input[@name='exemplary_content']")
	private WebElement demoCheck;
	
	@FindBy(xpath="//input[@name='visibility'][@value=3]")
	private WebElement courseAccessPublic;
	
	@FindBy(xpath="//input[@name='visibility'][@value=2]")
	private WebElement courseAccessOpen;
	
	@FindBy(xpath="//input[@name='visibility'][@value=1]")
	private WebElement courseAccessPrivate;
	
	@FindBy(xpath="//input[@name='visibility'][@value=0]")
	private WebElement courseAccessClosed;
	
	@FindBy(xpath="//input[@name='visibility'][@value=4]")
	private WebElement courseAccessHidden;
	
	@FindBy(xpath="//input[@name='subscribe'][@value=1]")
	private WebElement subscribeAllow;
	
	@FindBy(xpath="//input[@name='subscribe'][@value=0]")
	private WebElement subscribeother;
	
	@FindBy(xpath="//input[@name='unsubscribe'][@value=1]")
	private WebElement unsubscribeAllow;
	
	@FindBy(xpath="//input[@name='unsubscribe'][@value=0]")
	private WebElement unsubscribeNotAllow;
	
	@FindBy(id="disk_quota")
	private WebElement diskSpace;
	
	@FindBy(xpath="//input[@placeholder='Start to type, then click on this bar to validate tag']")
	private WebElement tags;
	
	@FindBy(id="//li[@role='treeitem'][1]")
	private WebElement tagSel;
	
	@FindBy(xpath="//input[@name='extra_special_course[extra_special_course]']")
	private WebElement special;
	
	@FindBy(id="extra_video_url")
	private WebElement videoURL;
	
	@FindBy(id="update_course_submit")
	private WebElement createCourseBtn;
	
	public void setTitle(String title) {
		this.title.clear();
		this.title.sendKeys(title);
	}
	
	public void setCode(String code) {
		this.code.clear(); 
		this.code.sendKeys(code); 
	}
	
	public WebElement getCategory(String category){
		this.category.click();
		for(int i=0;i<allCategory.size();i++) {
			if(this.allCategory.get(i).getText().equalsIgnoreCase(category))
			{
				selCategory=allCategory.get(i);
			}
			
		}
		return selCategory;
	}
	
	public void setCategory(WebElement category)
	{
		category.click();
	}
	
	public void setTeachers(String teacher) {
		this.clearTeacherField.click();
		this.teacher.clear(); 
		this.teacher.sendKeys(teacher); 
		this.teacherSel.click();
			
		}
	
	public void setDepartment(String department) {
		this.department.clear();
		this.department.sendKeys(department);
	}
	
	public void setDepartmentURL(String departmentURL) {
		this.departmentURL.clear(); 
		this.departmentURL.sendKeys(departmentURL); 
	}
	
	public WebElement getLang(String lang){
		languageField.click();
		for(int i=0;i<language.size();i++) {
			if(language.get(i).getText().equalsIgnoreCase(lang))
			{
				this.langSelected=language.get(i);
			}
			
		}
		return langSelected;
	}
	
	public void setLang(WebElement lang)
	{
		lang.click();
	}
	
	public void setCourseTemplate(String courseTemplate) {
		this.courseTemplate.clear(); 
		this.courseTemplate.click();
		this.courseTemplateText.sendKeys(courseTemplate); 
		this.courseTemplateSel.click();
	}
	
	public void checkFillWithDemo() {
		this.demoCheck.click(); 
	}
	
	public void selCourseAcess(String courseAccess) {
		String courseAcc=courseAccess.toLowerCase();
		if(courseAcc.contains("public"))
		{
			this.courseAccessPublic.click();
		}
		else if(courseAcc.contains("open"))
		{
			this.courseAccessOpen.click();
		}
		else if(courseAcc.contains("private"))
		{
			this.courseAccessPrivate.click();
		}
		else if(courseAcc.contains("closed"))
		{
			this.courseAccessClosed.click();
		}
		else if(courseAcc.contains("hidden"))
		{
			this.courseAccessHidden.click();
		}
	}
	
	public void subscriptionOptin(String subscription) {
		String subs=subscription.toLowerCase();
		if(subs.contains("allowed"))
		{
			this.subscribeAllow.click();
		}
		else if(subs.contains("this function is only available to trainers"))
		{
			this.subscribeother.click();
		}
	}
	
	public void unsubscriptionOptin(String unsubscription) {
		String unsubs=unsubscription.toLowerCase();
		if(unsubs.contains("allowed"))
		{
			this.unsubscribeAllow.click();
		}
		else if(unsubs.contains("not allowed"))
		{
			this.unsubscribeNotAllow.click();
		}
	}
	
	public void setDiskSpace(String diskSpace) {
		this.diskSpace.clear();
		this.diskSpace.sendKeys(diskSpace);
	}
	
	public void setTags(String tag) {
		this.tags.clear();
		this.tags.sendKeys(tag);
		this.tagSel.click();
	}
	
	public void checkSpecial() {
		this.special.click();
	}
	
	public void setVideoURL(String videoURL) {
		this.videoURL.clear();
		this.videoURL.sendKeys(videoURL);  
	}
	
	public void clickCreateCourseBtn() {
		this.createCourseBtn.click(); 
	}	

}
