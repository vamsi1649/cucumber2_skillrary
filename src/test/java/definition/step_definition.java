package definition;

import java.io.File;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class step_definition {
	
	public static String url="https://demoapp.skillrary.com/login.php?type=login";
	 
	WebDriver driver;
	
	@Given("I should go to the login page")
	public void i_should_go_to_the_login_page() {
	
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			WebDriverManager.chromedriver().setup();
	}
	@And("Enter the username {string}")
	public void enter_the_username(String string) {
		//JavascriptExecutor js = ((JavascriptExecutor)driver);
		//js.executeScript("document.getElementById('email').value='admin'");
	    WebElement email =	driver.findElement(By.name("email"));
	    javascript_util.passingValuesUsingJS(email, string, driver);	
	}
	@And("Enter the password {string}")
	public void enter_the_password(String string) {
		//JavascriptExecutor js = ((JavascriptExecutor)driver);
		//js.executeScript("document.getElementById('password').value='admin'");
		 WebElement psd= driver.findElement(By.name("password"));
		 javascript_util.passingValuesUsingJS(psd, string, driver);	
	}
	@And("Click on the login button")
	public void click_on_the_login_button() {
		//JavascriptExecutor js = ((JavascriptExecutor)driver);
		//js.executeScript("document.getElementById('last').click()");
		WebElement login = driver.findElement(By.xpath("//*[@id='last']"));
		javascript_util.clickElementByJS(login, driver);
	}
	@Then("I should see the username as {string}")
	public void i_should_see_the_username_as(String string) {
		String k= driver.getTitle();
		  Assert.assertEquals(string, k);
	}
	@And("Click on the username")
	public void click_on_the_username() throws IOException {
		//JavascriptExecutor js = ((JavascriptExecutor)driver);
		//js.executeScript("document.getElementsByClassName('user-image')[0].click()");
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://Users//LENOVO//Desktop//scrshot//homepage.png"));
		WebElement usr = driver.findElement(By.xpath("//a[@class='dropdown-toggle']//img[1]"));
		javascript_util.clickElementByJS(usr, driver);
	}
	@And("Click on the signout")
	public void click_on_the_signout() {
		//JavascriptExecutor js = ((JavascriptExecutor)driver);
		//js.executeScript("document.getElementsByClassName('btn btn-default btn-flat')[1].click()");
	   WebElement sgn =driver.findElement(By.linkText("Sign out"));
	   javascript_util.clickElementByJS(sgn, driver);
	}
	@Then("I should go skillrary homepage as {string}")
	public void i_should_go_skillrary_homepage_as(String string) {
		String k= driver.getTitle();
		  Assert.assertEquals(string, k);
	}
		
	}
