import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Waits {
	
	static WebDriver driver;
	
	
  @Test 
  public void setUp() {
		
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver.get("http://automationpractice.com");
		//driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"))
.click();
		
        
        
      //Thread.sleep(3000);
        
        /*
         ** --- implicit waits---- **
        */
        /*
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	  
        driver.findElement(By.id("email_create")).sendKeys("aaa@gmail.com");
        driver.findElement(By.id("SubmitCreate")).click(); 
        
        String errorMsg = driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li")).getText();
        */
        
        
        
        /*
         ** --- Explicit waits---- **
         */
        
        
        WebDriverWait wait = new WebDriverWait(driver, 60);
	
        driver.findElement(By.id("email_create")).sendKeys("aaa@gmail.com");
        driver.findElement(By.id("SubmitCreate")).click();  
  
        
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create_account_error\"]/ol/li")));
    
       String errorMsg = driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li")).getText();
    
      // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"create_account_error\"]/ol/li")));
      
       	driver.get("http://automationpractice.com");
  
       	WebElement bestSellerButton = driver.findElement(By.xpath("//*[@id=\"home-page-tabs\"]/li[2]"));
       	wait.until(ExpectedConditions.attributeToBe(bestSellerButton,  "class", "active"));
  
  
  }
	
	
	

}
