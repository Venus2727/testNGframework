package com.techproed.Batch3SeleniumPractice.Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCase3 {

    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/");
        Thread.sleep(3000);
        WebElement singIn = driver.findElement(By.id("signin_button"));
        singIn.click();
        Thread.sleep(3000);
        WebElement userName = driver.findElement(By.id("user_login"));
        userName.sendKeys("username");
        Thread.sleep(3000);
        WebElement password = driver.findElement(By.xpath("//input[@name='user_password']"));
        password.sendKeys("password");
        Thread.sleep(3000);
        WebElement singINButton = driver.findElement(By.xpath("//input[@name='submit']"));
        singINButton.click();

    }
//  1. Go to http://zero.webappsecurity.com/
//            2. Click Sign in button
// 3. Enter login ( “username”)
// 4. Enter wrong password (“password.”)
// 5. Click Sign in button
//6. Go to Account Activity page
//7.Select Brokerage from account drop down menu
//8.Verify in the account dropdown menu Brokerage is selected
//9.Verify the drop down menu is following
//    { Savings, Checking, Savings, Loan, Credit Card, Brokerage}
    @Test
    public void test3() throws InterruptedException {

  WebElement accountActivity = driver.findElement(By.linkText("Account Activity"));
  accountActivity.click();
  Thread.sleep(3000);
  WebElement dropDown = driver.findElement(By.id("aa_accountId"));
        Select option = new Select(dropDown);
        Thread.sleep(3000);
        option.selectByVisibleText("Brokerage");
        System.out.println(option.getFirstSelectedOption().getText());
        Assert.assertTrue(option.getFirstSelectedOption().isDisplayed());

        List<String> expectedList = Arrays.asList("Savings", "Checking", "Savings", "Loan", "Credit Card", "Brokerage");
        List<WebElement> webList = option.getOptions();
        List<String> actualList = new  ArrayList<String>();

        for (WebElement each: webList) {
            actualList.add(each.getText());

        }
        System.out.println("actualList =" + actualList);
        Assert.assertEquals(actualList,expectedList);

    }


}
