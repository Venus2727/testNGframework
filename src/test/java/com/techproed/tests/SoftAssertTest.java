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
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test
    public void hardAssertTest(){
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        String exceptedGmailText = "gmail";
       String actualGmailText=  gmailLink.getText();
       Assert.assertEquals(actualGmailText,exceptedGmailText);

        WebElement imagesLink = driver.findElement(By.linkText("Images"));
        String expectedImagesLinkText = "Images";
      String actualImagesLinkText=  imagesLink.getText();
      Assert.assertEquals(actualImagesLinkText,expectedImagesLinkText);


        WebElement singinLink = driver.findElement(By.linkText("Sign in"));
        String expectedSinginLinkText = "Sing in";
       String actualSinginLinkText = singinLink.getText();
       Assert.assertEquals(actualSinginLinkText,expectedSinginLinkText);

    }

    @Test
    public void softAssertTest(){
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));

        String expectedGmailLinkText = "gmail";
        String actualGmailLinkText =  gmailLink.getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualGmailLinkText,expectedGmailLinkText);


        WebElement imagesLink = driver.findElement(By.linkText("Images"));
        String expectedImageLinkText = "Images";
      String actualImageLinkText =  imagesLink.getText();
      softAssert.assertEquals(actualImageLinkText,expectedImageLinkText);

        WebElement singinLink = driver.findElement(By.linkText("Sign in"));
        String expectedSinginLinkText = "sing in";
      String actualSinginLinkText=  singinLink.getText();
      softAssert.assertEquals(actualSinginLinkText,expectedSinginLinkText);

      softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }


}
