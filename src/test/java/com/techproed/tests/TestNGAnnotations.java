package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGAnnotations {

//    1. create a method: setUp using @BeforeMethod annotation and
//    print "This is BeforeMethod"
//     2. Create a method: tearDown using @AfterMethod annotation and
//     print "This is @AfterMethod"
//    3. Create 3 TEST METHODS: test1,test2,test3,test4 and
//    print "Test1", "Test2", "Test3","Test4" respectively
//4. Skip test2
//5. print the test in this order: Test3, Test4, Test1
   // WebDriver driver;
    @BeforeMethod
    public void setup(){
        System.out.println("This is BeforeMethod");
     //   WebDriverManager.chromedriver().setup();
    //    driver = new ChromeDriver();
    }

    @Test (priority = 10)
    public void test1(){
        System.out.println("Test1");

    }
   @Ignore
    @Test
    public void test2(){
        System.out.println("test2");

    }
    @Test(priority = 6)
    public void test3(){
        System.out.println("test3");

    }

    @Test(priority = 7)
    public void test4(){
        System.out.println("test4");

    }

    @AfterMethod
    public void tearDown(){
        System.out.println("this is afterMethod");

    }

}
