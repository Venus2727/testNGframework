package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleExample extends TestBase {

//    Create a new Class Tests package: WindowHandleExample
//    Given user is on the https://the-internet.herokuapp.com/windows
//    Then user verifies the text : “Opening a new window”
//    Then user verifies the title of the page is “The Internet”
//    When user clicks on the “Click Here” button
//    Then user verifies the new window title is “New Window”
//    Then user verifies the text:  “New Window”
//    When user goes back to the previous window and then verifies the title : “The Internet”

    @Test
    public void newWindowTest(){
        driver.get("https://the-internet.herokuapp.com/windows");
        String actualnewWindowText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(actualnewWindowText,"Opening a new window");
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
       // Assert.assertEquals(actualTitle,"The Internet");
        Assert.assertEquals(actualTitle,expectedTitle,"title is incorrect");
        String defaultWindow =driver.getWindowHandle();
        System.out.println("defaultWindow=" + defaultWindow);
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> allWindowHandle = driver.getWindowHandles();
        for (String eachHandle: allWindowHandle) {
            if(!(eachHandle.equals(defaultWindow))){
                driver.switchTo().window(eachHandle);

            }

        }

       // driver.switchTo().window()
        String actualNewPageTitle = driver.getTitle();
        String expectedNewPageTitle = "New Window";
        Assert.assertEquals(actualNewPageTitle,expectedNewPageTitle,"New page title is not equal");


        String expectedNewWindowText2 = "New Window";
      String actualNewWindowText2 =  driver.findElement(By.xpath("//h3")).getText();
      Assert.assertEquals(actualNewWindowText2,expectedNewWindowText2,"not match");

      driver.switchTo().window(defaultWindow);
      Assert.assertEquals(driver.getTitle(),"The Internet");


    }


}
