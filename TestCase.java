package dubdubai;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase {
	private WebDriver driver;
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&'*+\\/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    @BeforeMethod
    public void launchbrowser() {
    	
    	WebDriverManager.chromedriver().setup();
    	driver =new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https:z3t0c9.csb.app/");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
	 @Test
	 //validate the email
	 public void testValidEmail() throws InterruptedException {
		 		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("uiswaryaa@gmail.com");
		 		Thread.sleep(2000);
		 		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pass123");
		 		Thread.sleep(2000);
		 		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		 		String enteredEmail = driver.findElement(By.xpath("//input[@value='uiswaryaa@gmail.com']")).getAttribute("value");
		 		Assert.assertTrue(enteredEmail.matches(EMAIL_REGEX));
	 }
 @Test
 //validate the password field
 public void test_valid_password() throws InterruptedException {
	 		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("uiswaryaa@gmail.com");
	 		Thread.sleep(2000);
	 		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pass12345");
	 		Thread.sleep(2000);
	 		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	 		 String passwordFieldType =driver.findElement(By.xpath("//input[@type='password']")).getAttribute("type");
	 		 Assert.assertEquals(passwordFieldType, "password");
 }
 
@Test
//invalidate the email field
public void test_invalid_email() throws InterruptedException {
			driver.findElement(By.xpath("//input[@type='text']")).clear();
	 		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("iswaryagmail.com");
	 		Thread.sleep(2000);
	 		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pass1234");
	 		Thread.sleep(2000);
	 		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	 		String enteredEmail = driver.findElement(By.xpath("//input[@value='iswaryagmail.com']")).getAttribute("value");
	 		Assert.assertTrue(enteredEmail.matches(EMAIL_REGEX));
}
@Test
//invalidate password field
public void test_invalid_password() throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("uiswaryaa@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		 String passwordFieldType =driver.findElement(By.xpath("//input[@type='password']")).getText();
		 Assert.assertTrue(passwordFieldType.contains("Invalid password"));
		 
}	
@Test
//valid the submit button
public void test_submit_null_email() throws InterruptedException {
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys();
			Thread.sleep(2000);
	 		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pass12345");
	 		Thread.sleep(2000);
	 		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	 		String text = driver.findElement(By.xpath("//input[@type='text']")).getText();
	 		Assert.assertNotNull(text);
	 	
}
@Test
//valid the submit button
public void test_submit_null_password() throws InterruptedException {
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys("uiswaryaa@gmail.com");
			Thread.sleep(2000);
	 		driver.findElement(By.xpath("//input[@type='password']")).sendKeys();
	 		Thread.sleep(2000);
	 		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	 		String text = driver.findElement(By.xpath("//input[@type='password']")).getText();
	 		Assert.assertNotNull(text);
	 	
}
@AfterMethod
public void close() {
	driver.close();
}
}
