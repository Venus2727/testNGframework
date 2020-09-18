package com.techproed.Batch3SeleniumPractice.Day4;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCase1 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        /*
        Go to http://zero.webappsecurity.com/
 2. Click Sign in button
 3. Enter login ( “username”)
 4. Enter wrong password (“password”)
 5. Click Sign in button
6. Go to Pay Bills page
7. Click Purchase Foreign Currency
8. Select Eurozone from currency drop dawn menu
9. Verify the Euro zone is selected
10. Verify the List Options is following {Select One, Australia (dollar),
Canada (dollar),Switzerland (franc),China (yuan),Denmark (krone),Eurozone (euro),
Great Britain (pound),Hong Kong (dollar),Japan (yen),Mexico (peso),Norway (krone),
New Zealand (dollar),Sweden (krona),Singapore (dollar),Thailand (baht)}
         */
        driver.get("http://zero.webappsecurity.com/");
        Thread.sleep(3000);
        WebElement singin = driver.findElement(By.id("signin_button"));
        singin.click();
        Thread.sleep(3000);
        WebElement login = driver.findElement(By.id("user_login"));
        login.sendKeys("username");
        Thread.sleep(3000);
        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("password");
        Thread.sleep(3000);
        WebElement singinSubmit = driver.findElement(By.xpath("(//input)[4]"));
        singinSubmit.click();
        WebElement payBill = driver.findElement(By.linkText("Pay Bills"));
        payBill.click();
        WebElement foreingCurrency = driver.findElement(By.linkText("Purchase Foreign Currency"));
        foreingCurrency.click();
        Thread.sleep(3000);
        WebElement dropDown = driver.findElement(By.id("pc_currency"));
        Thread.sleep(3000);
        Select options = new Select(dropDown);
      //  options.selectByVisibleText("Eurozone (euro)");
        options.selectByIndex(6);

      //  WebElement eurozone = driver.findElement(By.xpath("(//option[@value='EUR']"));
      //    Assert.assertTrue(eurozone.isSelected());

        String actualSelectedOption = options.getFirstSelectedOption().getText();
        String expectedOption = "Eurozone (euro)";
        Assert.assertEquals(actualSelectedOption,expectedOption);

        List<String> expectedListOptions = Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)");
        System.out.println(expectedListOptions);
        List<WebElement> listOption = options.getOptions();
        List<String> actualListOptionText = new ArrayList<>();
        for (WebElement element:listOption) {
            actualListOptionText.add(element.getText());

        }
        System.out.println(actualListOptionText);
        Assert.assertEquals(expectedListOptions,actualListOptionText);


    }


}
