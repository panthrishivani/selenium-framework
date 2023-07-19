package SeleniumPractice.SeleniumFramework;

import java.time.Duration;
import java.util.List;

//import java.util.List;
//
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import SeleniumPractice.SeleniumFramework.pageobjects.LandingPage;
import SeleniumPractice.SeleniumFramework.pageobjects.productcatalog;

public class Praticeframeworkown {

	public static void main(String[] args) throws InterruptedException {
		 String productName="ZARA COAT 3";
      WebDriver driver =new ChromeDriver();
      driver.manage().window().maximize();  
  	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  	
  	
      LandingPage landingpage  =new LandingPage(driver);
      landingpage.urlgo();
      landingpage.applicationLogin("restapitest@yopmail.com", "Shivani@123");
      productcatalog procat=new productcatalog(driver);
      List<WebElement> products= procat.getProductList();
      procat.addProductToCart(productName);
      procat.gotocartpage();
      
      
      
      
//      driver.findElement(By.id("userEmail")).sendKeys("restapitest@yopmail.com");
//      driver.findElement(By.id("userPassword")).sendKeys("Shivani@123");
//      driver.findElement(By.id("login")).click(); 
//      List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//      
//      Thread.sleep(1000);
//       WebElement test111 = products.stream().filter(prod->prod.findElement(By.cssSelector("b"))
//    		   .getText().equals("IPHONE 13 PRO")).findFirst().orElse(null);
//       test111.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//       WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
//       wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
//       
      
      
//      driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
//       List<WebElement> carts =driver.findElements(By.cssSelector(".cartSection h3"));
//     Boolean match= carts.stream().anyMatch(cart->cart.getText().equalsIgnoreCase("IPHONE 13 PRO"));
//     Assert.assertTrue(match);
//
//     System.out.println("hhhh");
//     driver.findElement(By.cssSelector(".subtotal .btn ")).click();
//     driver.findElement(By.cssSelector("[placeholder='Select Country']")).click();
//     driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("India");
//     wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ta-results")));
//     
//     driver.findElement(By.cssSelector(".ta-item:nth-child(3)")).click();
//     driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();


     
     
       
      
      
	}

}
