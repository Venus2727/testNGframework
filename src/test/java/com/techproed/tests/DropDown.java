package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;


public class DropDown {
    //Create a class name : DropDown
//Go to https://the-internet.herokuapp.com/dropdown
//1.Select and Print Option 1 using index
//2.Select and Print Option 2 by value
//3.Select and Print default value by visible text
//4.Print all dropdown values
//5.Find the size of the dropdown,
// Print true if there are 4 elements in the dropdown. Print false otherwise.
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void dropDownTest() throws InterruptedException {
        WebElement dropDownElement= driver.findElement(By.id("dropdown"));
        Select drop1 = new Select(dropDownElement);
        drop1.selectByIndex(1);
     Thread.sleep(3000);
        //2.Select and Print Option 2 by value
     //   drop1.selectByValue("2");

    }

  @Test
    public void selectValueDDown() throws InterruptedException {
        WebElement drop2element =driver.findElement(By.id("dropdown"));
        Select options = new Select(drop2element);
        Thread.sleep(3000);
        options.selectByValue("2");

  }

  @Test
  public void selectByVisible() throws InterruptedException {
        WebElement drop2element = driver.findElement(By.id("dropdown"));
        Select option =new Select(drop2element);
        Thread.sleep(3000);
        option.selectByVisibleText("Option 1");
  }

  @Test
  public void printAllValue() throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropdownElement);
        Thread.sleep(3000);
      List<WebElement> allOption = options.getOptions();
      for (WebElement option: allOption) {
          System.out.println(option.getText());
      }
  }

  @Test
  public void dropdownSizeTest(){
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select option = new Select(dropdownElement);
       int actualSizeDropDown = option.getOptions().size();
      Assert.assertEquals(actualSizeDropDown,4,"this expected is not equal to actual");

  }
  @Test
  public void getFirstSelectedOptionTest(){
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropdownElement);
       String firstSelectedOption= options.getFirstSelectedOption().getText();
      System.out.println("firstSelectedOption: " + firstSelectedOption);

  }


  @AfterMethod
    public void tearDown(){
        driver.close();
  }


}
