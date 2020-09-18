package com.techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethods {

    @Test
    public void login(){
        System.out.println(" log in test");
    }
    @Test
    public void homePage(){
        System.out.println("home page test");
      //  Assert.assertEquals(3,4);
      Assert.assertTrue(false);
    }
    @Test(dependsOnMethods = "homePage")
    public void searchTest(){
        System.out.println("search test");

    }
    @Test
    public void verifyTheResults(){
        System.out.println("verify the result");

    }

}
