package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsClass1 extends TestBase {

    @Test
    public void contextClickMethod() throws InterruptedException {
//        Create a class: ActionsClass1
//        Create a test method : contextClickMethod() and test the following scenario:
//        Given user is on the https://the-internet.herokuapp.com/context_menu
//        When use Right clicks on the box
//        Then verify the alert message is “You selected a context menu”
//        Then accept the alert
    driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        WebElement box = driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();
        Thread.sleep(3000);
    String actualAlertMessage =    driver.switchTo().alert().getText();
    String expectedAlertMessage = "You selected a context menu";
        Assert.assertEquals(actualAlertMessage,expectedAlertMessage);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

    }

}
