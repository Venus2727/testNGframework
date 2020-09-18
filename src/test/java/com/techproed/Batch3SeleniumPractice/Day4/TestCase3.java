package com.techproed.Batch3SeleniumPractice.Day4;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestCase3 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
//        1.Go to http://webdriveruniversity.com/IFrame
//        2.Click the Our Products button
//        3.Click Cameras product
//        4.Print the message from popup
//        5.Click the close button

        driver.get("http://webdriveruniversity.com/IFrame");
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframeElement);

        WebElement ourProduct = driver.findElement(By.linkText("Our Products"));
        ourProduct.click();
        WebElement cameras = driver.findElement(By.xpath("(//p[@class='sub-heading'])[2]"));
        cameras.click();
        Thread.sleep(3000);

        WebElement massage = driver.findElement(By.xpath("//h4"));
        Thread.sleep(3000);
        String massageText = massage.getText();
        Thread.sleep(3000);
        System.out.println("massageText = " + massageText);

        WebElement closeButton = driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]"));
        closeButton.click();






    }
}
