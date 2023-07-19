package SeleniumPractice.SeleniumFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ResuableComponents.Resuablecode;

public class LandingPage extends Resuablecode{
	WebDriver driver;
	public  LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		 PageFactory.initElements(driver,this);
		
		
	}
	@FindBy(id="userEmail")
	WebElement useremail;
	@FindBy(id="userPassword")
	WebElement password;
	@FindBy(id="login")
	WebElement submit;
	
	
	
	public void applicationLogin(String email,String Paasword) {
		useremail.sendKeys(email);
		password.sendKeys(Paasword);
		submit.click();
		
		
	}
	public void urlgo() {
    driver.get("https://rahulshettyacademy.com/client");
	}
	



}

