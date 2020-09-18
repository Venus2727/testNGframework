package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class uploadFileTest extends TestBase {

    @Test
    public void uploadFileMethod(){
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        String pathOfFile = "C:/Users/Gurbet27/Desktop/FLOWER. IMG.jpg";
        chooseFile.sendKeys(pathOfFile);
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement fileUploadTextElement = driver.findElement(By.xpath("//h3"));
        String actualFileUploadText =fileUploadTextElement.getText();
        String expectedText = "File Uploaded!";
        Assert.assertEquals(actualFileUploadText,expectedText);


    }


}
