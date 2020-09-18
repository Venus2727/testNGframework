package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsClass2 extends TestBase {

    @Test
    public void hoverOver() throws InterruptedException {
//        Create a class: ActionClass2
//        Create test method : hoverOver() and test the following scenario:
//        Given user is on the https://www.amazon.com/
//        When use click on “Your Account” link
//        Then verify the page title contains “Your Account”
//        Create another method: imageTest()
//        Hover over the Try Prime
//        And Verify the image displays.

        driver.get("https://www.amazon.com/");
        Actions actions = new Actions(driver);
        WebElement hoverOverElement = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(hoverOverElement).perform();
        WebElement yourAccount = driver.findElement(By.linkText("Your Account"));
        yourAccount.click();
        String expectedAccountTitle = "Your Account";
        String actualAccountTitle = driver.getTitle();
        Assert.assertTrue(actualAccountTitle.contains(expectedAccountTitle));
        Thread.sleep(3000);

    }

    @Test
    public void imageTest() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);
        WebElement primeElement = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(primeElement).perform();
    }


}
