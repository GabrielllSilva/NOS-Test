package test.nos;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class registerNewUser {
	
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://login.nos.pt");
		//driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@After(order = 1)
	public void screenshot(Scenario scene) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target\\screenshot\\" + scene.getName() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	@After(order = 0) 
	public void closeWindow() { 
		 driver.quit();
	}
	
	
	@Given("^I am acess the nos website$")
	public void i_am_acess_the_nos_website(){		
				
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/a[1]")).click();
	}

	@And("^click on Registe-se$")
	public void click_on_Registe_se(){
		
		driver.findElement(By.xpath("/html/body/app-root/ng-component/div/authentication-username/div/div/div/div[1]/section[2]/div/span/a")).click();
		
	}

	@When("^fill the form for register$")
	public void fill_the_form_for_register(){
		
		driver.findElement(By.id("displayName-input")).click();
		driver.findElement(By.id("displayName-input")).sendKeys("Gabriel NOS");
		driver.findElement(By.id("phone")).click();
		driver.findElement(By.id("phone")).sendKeys("910340565");
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("gluiz37@gmail.com");
		driver.findElement(By.id("password-input")).click();
		driver.findElement(By.id("password-input")).sendKeys("535G@briel");
		driver.findElement(By.className("checkbox-indicator")).click();
		
	}

	@Then("^a new user must be register with success$")
	public void a_new_user_must_be_register_with_success(){
		
		driver.findElement(By.xpath("/html/body/app-root/ng-component/div/signup-landingpage/div/div/form/div[2]/input")).click();
		driver.findElement(By.xpath("/html/body/app-root/ng-component/div/signup-sendsms/div/div/div/div/div[2]/input")).click();
		
		
	}
}
