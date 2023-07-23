package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	WebDriver driver;
	
	  @Given("User should navigate the application login") public void
	  userShouldNavigate() { System.setProperty("webdriver.chrome.driver",  "D:\\chromedriver_win32\\chromedriver.exe"); 
	  ChromeOptions options=new ChromeOptions(); 
	  options.addArguments("--remote-allow-origins=*"); driver=new
	  ChromeDriver(options); driver.get("https://bookcart.azurewebsites.net/");
	  driver.manage().window().maximize(); }
	 
	
	@Given("User clicks on the login link")
	public void userClicksOnTheLoginLink() {
	   driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
	}

	/*
	 * @Given("User enters the username as Nancyleema") public void
	 * userEntersTheUsernameAsNancyleema() {
	 * driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys(
	 * "Nancyleema"); }
	 * 
	 * @Given("User enters the password as Tharun0911") public void
	 * userEntersThePasswordAsTharun0911() {
	 * driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(
	 * "Tharun0911"); }
	 */
	@When("User click on the login button")
	public void userClickOnTheLoginButton() {
	    driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/div[2]/div/mat-card/mat-card-content/form/mat-card-actions/button")).click();
	}
	@Then("login should be success")
	public void loginShouldBeSuccess() {
		WebElement textElement=driver.findElement(By.xpath(" //body/app-root[1]/app-nav-bar[1]/mat-toolbar[1]/mat-toolbar-row[1]/div[3]/button[3]/span[1]"));
		String text = textElement.getText();
		System.out.println("Nancyleema " + text);
	}
	
	@Given("User enters the username as {string}")
	public void userEntersTheUsernameAs(String username) {
		 driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys(username);
	}
	@Given("User enters the password as {string}")
	public void userEntersThePasswordAs(String password) {
		  driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(password);
	}


	
	

}
