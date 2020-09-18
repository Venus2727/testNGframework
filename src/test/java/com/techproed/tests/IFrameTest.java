package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFrameTest extends TestBase {

    @Test
    public void iframeTest() throws InterruptedException {
//        Go to https://the-internet.herokuapp.com/iframe
//        Verify the Bolded text contains “Editor”
//        Locate the text box
//        Delete the text in the text box
//        Type “This text box is inside the iframe”
//        Verify the text Elemental Selenium text is displayed on the page
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement bolded = driver.findElement(By.xpath("//h3"));
        String boldedText = bolded.getText();
        Assert.assertTrue(boldedText.contains("Editor"));
     //   driver.switchTo().frame(0);
     //   driver.switchTo().frame("mce_0_ifr");
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeElement);

        Thread.sleep(3000);

        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        Thread.sleep(3000);
        textBox.sendKeys("This text box is inside the iframe");
      //  driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        String seleniumElementText = driver.findElement(By.xpath("//a[@target='_blank']")).getText();
     // String seleniumElementText=   seleniumElement.getText();
      Assert.assertTrue(seleniumElementText.equals("Elemental Selenium"));


    }


}
