package com.techproed.Batch3SeleniumPractice.Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1 {

    WebDriver driver;
    @BeforeMethod
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://facebook.com");

    }
/*
1. Go to "https://facebook.com"
2. Click create new account button


3. Enter a name firstName input box
4. Enter a surname surName input box
5. Enter an email into email input box
6. Re-enter the same email into email input box
7. Enter a new password
8. Select a day
9. Select a moth
10. Select a year
11. Select a gender
12. Verify the gender is selected and verify the other gender is not selected.
 */



   @Test
   public  void testCase() throws InterruptedException {

      // 2. Click create new account button
       WebElement newAccount = driver.findElement(By.id("u_0_2"));
       newAccount.click();
       Thread.sleep(3000);
       WebElement firstName = driver.findElement(By.id("u_1_b"));
       firstName.sendKeys("tester");
       Thread.sleep(3000);
       WebElement lastName = driver.findElement(By.id("u_1_d"));
       lastName.sendKeys("qa");
       Thread.sleep(3000);
       WebElement email = driver.findElement(By.id("u_1_g"));
       email.sendKeys("tester@ga.com");
       Thread.sleep(3000);
   WebElement againEmailEnter = driver.findElement(By.id("u_1_j"));
   againEmailEnter.sendKeys("tester@ga.com");
   Thread.sleep(3000);
   WebElement password = driver.findElement(By.id("password_step_input"));
   password.sendKeys("key1234");
   Thread.sleep(3000);
   WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
       Select option = new Select(day);
       option.selectByValue("19");
    Thread.sleep(3000);
    WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
    Select optionMonth = new Select(month);
    optionMonth.selectByIndex(5);
    Thread.sleep(3000);
    WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
    Select optionYear = new Select(year);
    optionYear.selectByValue("1990");
    Thread.sleep(3000);
    WebElement gender = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
    gender.click();
    Assert.assertTrue(gender.isSelected());
    Thread.sleep(3000);
    WebElement female = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
       Assert.assertFalse(female.isSelected());
       Thread.sleep(3000);


   }




  @AfterMethod
    public void tearDown(){
       driver.close();
  }




}
