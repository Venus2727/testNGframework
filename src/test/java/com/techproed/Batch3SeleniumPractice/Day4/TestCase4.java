package com.techproed.Batch3SeleniumPractice.Day4;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase4 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

//        1.Go to http://webdriveruniversity.com/Actions
//        2.Hover over the Me First
//        3.Click Link 1
//        4.Print the popup message
//        5.Accept the popup
//        6.Click and hold
//        7.Get the text click and hold
//        Double click to the double click me

        driver.get("http://webdriveruniversity.com/Actions");
        WebElement hoverOverElement = driver.findElement(By.className("dropbtn"));
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        actions.moveToElement(hoverOverElement).perform();
        WebElement link1 = driver.findElement(By.linkText("Link 1"));
        link1.click();
     String popUpMassage =   driver.switchTo().alert().getText();
        System.out.println("popUpMassage = " + popUpMassage);
        driver.switchTo().alert().accept();

        WebElement clickHoldElement = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickHoldElement).perform();
        String clickHoldMassage = clickHoldElement.getText();
        System.out.println("clickHoldMassage = " + clickHoldMassage);
        Thread.sleep(3000);

        WebElement doubleClickElement = driver.findElement(By.xpath("//h2"));
        actions.doubleClick(doubleClickElement).perform();
        
        // this is new subject git
        // what happned godd

        // i am learning fast
        
        // dont confisued
        


      // what kind of learning






    }
}
