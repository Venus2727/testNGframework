package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsClass4 extends TestBase {

    @Test
    public void scrollUpDown() throws InterruptedException {
//
//        Create a class: ActionClass4
//        Create test method : scrollUpDown()
//        Go to amazon
//        Scroll the page down
//        Scroll the page up

        driver.get("https://www.amazon.com/");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();
       Thread.sleep(3000);
       actions.sendKeys(Keys.ARROW_UP).perform();



    }


}
