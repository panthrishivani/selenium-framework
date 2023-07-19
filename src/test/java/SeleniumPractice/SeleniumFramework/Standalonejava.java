package SeleniumPractice.SeleniumFramework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

public class Standalonejava {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("restapitest@yopmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Shivani@123");
         driver.findElement(By.id("login")).click();
         Thread.sleep(1000);
         System.out.println(driver.findElement(By.xpath("(//h5)[1]")).getText());
         List<WebElement> product = driver.findElements(By.cssSelector(".mb-3"));
         Thread.sleep(1000);
         WebElement prop = product.stream().filter(productlist->
         productlist.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL"))
         .findFirst().orElse(null);
         prop.findElement(By.cssSelector(".card-body button:last-of-type")).click();

         WebDriverWait Wait=new WebDriverWait(driver,Duration.ofSeconds(10));

		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		// check the loader is invisible or not
		Wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		// VALIDATE IF THE ADDED ITEM IS PRESNT IN CART PAGE OR NOT.
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		// Match added product with each item of cart . steam() k sath filter ki jgh anyMatch bhi use kr skte h , ye true/false return krega
		Boolean isProductMatch = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
		Assert.assertTrue(isProductMatch); 

		// check if added product match with cart item 
		
		driver.findElement(By.cssSelector(".totalRow button ")).click(); // click on checkout page
		
		// Search data by search box
		
		Actions a  = new Actions(driver); // entery text by Actions class, Actions class keyboard/mouse k event ko handle krti h
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click(); // select india from search result
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");		
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action__submit")));
		driver.findElement(By.cssSelector(".action__submit")).click();
		String successMessage = driver.findElement(By.cssSelector(".hero-primary")).getText(); // get text of thanku page
		Assert.assertTrue(successMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER.")); // check if thankyiu message received or not.
		// agr console m text small m h or DOM m capital  m to  equalsIgnoreCase use kr skte h .
		
		
         
	
				
 
	}

}



