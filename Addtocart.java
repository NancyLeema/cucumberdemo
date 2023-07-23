package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Addtocart {
	WebDriver driver;
	@Given("User should navigate the application")
	public void userShouldNavigate() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.get("https://bookcart.azurewebsites.net/");
		driver.manage().window().maximize();
		}
	@Given("user should login as {string} and {string}")
	public void userShouldLoginAsAnd(String username, String password) {
		 driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		
		 driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys(username);
		 driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(password);
		 driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/div[2]/div/mat-card/mat-card-content/form/mat-card-actions/button")).click();
	    
	}
	@Given("user search a {string}")
	public void userSearchA(String string) throws InterruptedException {
WebElement search=driver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-toolbar/mat-toolbar-row/div[2]/app-search/form/input"));
	search.clear();
	search.sendKeys("Birthday Girl");
	Thread.sleep(1000);
	search.sendKeys(Keys.ENTER);

	driver.findElement(By.xpath("//*[@id=\"mat-option-17\"]/span")).click();
	
	   }
	@When("User add the book to the cart")
	public void userAddTheBookToTheCart() {
	   driver.findElement(By.xpath("/html/body/app-root/div/app-home/div/div[2]/div/div/app-book-card/mat-card/mat-card-content[2]/app-addtocart/button")).click();
	   }
	@Then("the cart badge should be updated")
	public void theCartBadgeShouldBeUpdated() {
		WebElement textElement=driver.findElement(By.xpath("//body/app-root[1]/app-nav-bar[1]/mat-toolbar[1]/mat-toolbar-row[1]/div[3]/button[1]/span[1]/mat-icon[1] "));
		String text = textElement.getText();
		Assert.assertEquals(Integer.parseInt(text)>0, true);
	}

}
