package ResuableComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Resuablecode {
		WebDriver driver;
		public  Resuablecode(WebDriver driver) {
			this.driver=driver;		
			By ProductBY=By.cssSelector(".mb-3");
			 PageFactory.initElements(driver,this);

		
		
		
		}
		@FindBy(css="[routerlink*='cart']")
			WebElement cartHeader;

		public void WaittoAppear(By findBy){
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
//			its is not a webelemtn webelemnt start from driver.fingelelment its just a by locator
			
		}
		public void waitForElementToDisappear(WebElement ele) throws InterruptedException
//		driver dor ccss selector .ng-animate tha  thats y we use webelemtn
		{
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.invisibilityOf(ele));

		}
		public void gotocartpage() {
//	      driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
			cartHeader.click();
		}
}

	

