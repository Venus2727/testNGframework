package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {

//    Go to https://the-internet.herokuapp.com/javascript_alerts
//    Create setUp method
//    Create 3 test methods:
//  acceptAlert() => click on the first alert, verify the text “I am a JS Alert” , click OK ,
//    and Verify “You successfuly clicked an alert”
// dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel," +
//        " and Verify “You clicked: Cancel”
//sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”, type “Hello Word”,
//    click OK, and Verify “You entered: Hello Word”
  WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void acceptAlert() throws InterruptedException {
        WebElement firstButtom = driver.findElement(By.xpath("(//button)[1]"));
        firstButtom.click();
        Thread.sleep(3000);
     String actualfirstAlertText =   driver.switchTo().alert().getText();
     //String expectedFirstAlertText = "I am a JS Alert";
      Thread.sleep(3000);
        Assert.assertEquals(actualfirstAlertText,"I am a JS Alert");
      driver.switchTo().alert().accept();
      Thread.sleep(3000);

      WebElement resultElement = driver.findElement(By.xpath("//p[@id='result']"));
         String actualResultText = resultElement.getText();
         Assert.assertEquals(actualResultText,"You successfuly clicked an alert");

    }
    // dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel," +
//        " and Verify “You clicked: Cancel”
    @Test
    public  void dismissAlertTest(){
        WebElement secondButton = driver.findElement(By.xpath("(//button)[2]"));
        secondButton.click();
        String actualSecondText=   driver.switchTo().alert().getText();
        Assert.assertEquals(actualSecondText,"I am a JS Confirm");
        driver.switchTo().alert().dismiss();
        WebElement resultElement = driver.findElement(By.xpath("//p[@id='result']"));
       String actualResultText =  resultElement.getText();
       Assert.assertEquals(actualResultText,"You clicked: Cancel");
    }
    //sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”, type “Hello Word”,
//    click OK, and Verify “You entered: Hello Word”
    @Test
    public void sendKeysAlertTest(){
        WebElement thirdElement = driver.findElement(By.xpath("(//button)[3]"));
        thirdElement.click();
       String actualThirdText =   driver.switchTo().alert().getText();
       Assert.assertEquals(actualThirdText,"I am a JS prompt");
       driver.switchTo().alert().sendKeys("Hello World");
       driver.switchTo().alert().accept();
       WebElement resultElement = driver.findElement(By.xpath("//p[@id='result']"));
      String actualResultText = resultElement.getText();
      Assert.assertEquals(actualResultText,"You entered: Hello World");

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }



}
