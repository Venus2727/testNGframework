package com.techproed.tests;

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
import java.util.Collections;
import java.util.List;

public class HomeworkDay8 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

//    •Use Different Test Method for each Test Case
//    •Go to https://www.amazon.com/
    // •Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
    // •Print the first selected option and assert if it equals “All Departments”
    // •Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”
    // .(after you select you need to use get first selected option method)
    // •Print all of the dropdown options
    // •Print the the total number of options in the dropdown
    // •Check if Appliances is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
    // •BONUS: Check if the dropdown is in Alphabetical Order

    @Test
    public void Test1() throws InterruptedException {
        driver.get("https://www.amazon.com/");

        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Thread.sleep(3000);
        Select option = new Select(dropDown);
        //  System.out.println(option.getFirstSelectedOption().getText());
        //   Assert.assertEquals(option.getFirstSelectedOption().getText(),"All Departments");
        System.out.println(option.getOptions().get(0).getText());
        String firstOption = option.getOptions().get(0).getText();
        Assert.assertEquals(firstOption, "All Departments");

        //  Assert.assertTrue( option.getOptions().get(3).getText().equals("Amazon Devices"));
        option.selectByIndex(3);
        // String option4 = option.getOptions().get(3).getText();
        System.out.println(option.getFirstSelectedOption().getText());
        //  Assert.assertTrue(option4.equals("Amazon Devices"));
        Assert.assertTrue(option.getFirstSelectedOption().getText().equals("Amazon Devices"));

        List<WebElement> allOptions = option.getOptions();
//        for (WebElement each:allOptions) {
//            System.out.println(each.getText());
//
//        }
        for (int i = 0; i < allOptions.size(); i++) {
            System.out.println(option.getOptions().get(i).getText());

        }

        System.out.println("total number of option =" + allOptions.size());


        option.selectByVisibleText("Appliances");

        WebElement appliancesElement = driver.findElement(By.xpath("(//option)[7]"));
        System.out.println("appliancesElement = " + appliancesElement.getText());
        Assert.assertTrue(appliancesElement.isDisplayed());
        if (appliancesElement.isDisplayed()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }


        List<String> originalList = new ArrayList<String>();
        for (WebElement each : allOptions) {
            originalList.add(each.getText());

        }

      //  System.out.println(StringList);

        List<String> orderList = originalList;

        Collections.sort(orderList);
        System.out.println(orderList);
       if(originalList.equals(orderList)){
           System.out.println("alfabetic order");

       }else{
           System.out.println("not alfabetic order");
       }


    }
}