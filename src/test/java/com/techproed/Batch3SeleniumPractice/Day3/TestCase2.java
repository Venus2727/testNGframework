package com.techproed.Batch3SeleniumPractice.Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
//    Go to “http://webdriveruniversity.com/Popup-Alerts/index.html”
//            2. Click CLICK ME of JavaScript Alert
// 3. Get the pop up text
// 4. Verify the Message is “I am an alert box!“
//            5. Accept the pop up


 @Test
 public void alert1() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        Thread.sleep(3000);
     WebElement jAlert = driver.findElement(By.id("button1"));
     jAlert.click();
     Thread.sleep(3000);
    String actualAlertText = driver.switchTo().alert().getText();
     Assert.assertEquals(actualAlertText,"I am an alert box!");
     Thread.sleep(3000);
     driver.switchTo().alert().accept();

 }

//    Write these code in test case 2 class
//1. Go to “http://webdriveruniversity.com/Popup-Alerts/index.html”
//            2. Click CLICK ME of JavaScript Confirm Box
//3. Get the pop up text
// 4. Verify the Message is “Press a button“ (the message is worng but I
//    want to complete my test case)
//            5. Dismiss the pop up
//6. Verify the “You pressed Cancel!” is displayed
//7. Use the dependsOnMethods accorting to alert1

 @Test(dependsOnMethods = "alert1")
 public void alert2(){
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        WebElement jConfirmAlert = driver.findElement(By.id("button4"));
        jConfirmAlert.click();
     Alert alert = driver.switchTo().alert();
     String actualConfirmText =  alert.getText();
     SoftAssert softAssert = new SoftAssert();
     softAssert.assertEquals(actualConfirmText,"Press a button");
     alert.dismiss();
     WebElement display = driver.findElement(By.xpath("//p[@id='confirm-alert-text']"));
   softAssert.assertTrue(display.isDisplayed());


     softAssert.assertAll();

 }



 @AfterMethod
    public void tearDown(){
       // driver.close();
 }





}
