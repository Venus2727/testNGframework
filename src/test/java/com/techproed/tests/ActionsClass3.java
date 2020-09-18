package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsClass3 extends TestBase {

    @Test
    public void keysUpDown1(){
//        Create a class: ActionClass3
//        Create test method : keysUpDown()
//        Go to google
//        Send iPhone X prices => convert small letter capital vice versa.
//        Highlight the search box by double clicking
        driver.get("https://google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        Actions actions =new Actions(driver);
        actions.keyDown(searchBox, Keys.SHIFT).
                sendKeys("iPhone X prices").keyUp(searchBox,Keys.SHIFT).perform();

    }


}
